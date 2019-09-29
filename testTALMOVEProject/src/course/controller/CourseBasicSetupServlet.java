package course.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import course.model.service.CourseService;
import course.model.vo.Course;
import tag.model.service.TagService;
import teacher.model.vo.Teacher;

@WebServlet("/courseset.ed")
public class CourseBasicSetupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CourseBasicSetupServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("index.jsp");
			request.setAttribute("message", "Enctype속성이 누락되었어요!");
			view.forward(request, response);
		}
		
		String savePath = request.getSession().getServletContext().getRealPath("/resources/course_upfiles");
		MultipartRequest mrequest = new MultipartRequest(request, savePath, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
        
		Teacher loginTeacher = (Teacher)request.getSession(false).getAttribute("loginTeacher");
		Course course = new Course();
		String tags = mrequest.getParameter("tags");
		String courseName = mrequest.getParameter("lectureName");
		course.setTeacherNo(loginTeacher.getTeacherNo());
		course.setCategoryNo(Integer.parseInt(mrequest.getParameter("categoryNo")));
		course.setCourseName(courseName);
		course.setDescription(mrequest.getParameter("lecIntro"));
		System.out.println("넘겨받은 des"+mrequest.getParameter("lecIntro"));
		System.out.println("넘겨받은 des2"+request.getParameter("lecIntro"));
		System.out.println(course.getDescription());
		String oFileName = mrequest.getFilesystemName("lecThumb");
		course.setThumbnailOfileName(oFileName);
		if(oFileName != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String rFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "." + oFileName.substring(oFileName.lastIndexOf('.') + 1);
			
			File oFile = new File(savePath + "/" + oFileName);
			File rFile = new File(savePath + "/" + rFileName);
			
			if(!oFile.renameTo(rFile)) {
				int read = -1;
				byte[] buf = new byte[1024];
				
				FileInputStream fin = new FileInputStream(oFile);
				FileOutputStream fout = new FileOutputStream(rFile);
				
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}
				fin.close();
				fout.close();
				oFile.delete();
			}
			course.setThumbnailRfileName(rFileName);
		}
		CourseService courseService = new CourseService();
		int result = courseService.setCourseBasic(course);
		
		//전달받은 태그리스트 ','로 분리해서 TAG 테이블에 집어넣기
		TagService tagservice = new TagService();
		String[] tagList = tags.split(",");
		int tagResult = tagservice.insertTag(tagList);
		//그럴리가 잘 없지만 모두 이미 존재하는 태그일 경우 0이 return되기 때문에 굳이 돌아온 return값에 따라 처리할 필요가 있을까? 없으면 변수 제거하자
		Course registedCourse = courseService.getCourseByName(courseName);
		int courseTagResult = tagservice.insertTagCourse(registedCourse.getCourseNo(), tagList);
		
        
        
		if(result > 0 && courseTagResult > 0) {
			System.out.println("강좌 정보 등록 성공\n강좌_태그 테이블 정보 등록 성공");
			view = request.getRequestDispatcher("/editPageLoad");
			//request.setAttribute("course", registedCourse);
            		//go to CourseLoadServlet
          			 request.setAttribute("courseNo", registedCourse.getCourseNo());
			view = request.getRequestDispatcher("views/teacherPage/editLecture.jsp");
			request.setAttribute("course", registedCourse);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("index.jsp");
			request.setAttribute("message", "강좌등록에 실패하였습니다");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

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
import course_tag.model.service.CourseTagService;
import tag.model.service.TagService;
import teacher.model.vo.Teacher;

@WebServlet("/cbupdate.ed")
public class CourseBasicUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CourseBasicUpdateServlet() {
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
		
		//전송온 값들 받고 course 객체에 담기
		Course course = new Course();
		int courseNo = Integer.parseInt(mrequest.getParameter("courseNo"));
		String courseName = mrequest.getParameter("courseName");
		String description = mrequest.getParameter("description");
		String[] tags = mrequest.getParameterValues("tagName");
		int categoryNo = Integer.parseInt(mrequest.getParameter("2ndC"));
		String oimgname = mrequest.getParameter("oimagename");
		String rimgname = mrequest.getParameter("rimagename");
		String oFileName = mrequest.getFilesystemName("changeThumb");
		
		course.setCourseNo(courseNo);
		course.setCourseName(courseName);
		course.setDescription(description);
		course.setCategoryNo(categoryNo);
		
		if(oFileName != null && !oFileName.equals(oimgname)) {
			new File(savePath + "/" + rimgname).delete();
			course.setThumbnailOfileName(oFileName);
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
		}else {
			course.setThumbnailOfileName(oimgname);
			course.setThumbnailRfileName(rimgname);
		}
		int result = new CourseService().cBasicUpdate(course);
		
		if(result > 0) {
			int tagresult = new TagService().insertTag(tags);
			//관계 테이블에 데이터 넣기 이전에 해당 강좌번호의 데이터 지우기
			int courseTagResult1 = new CourseTagService().clearTags(courseNo);
			if(courseTagResult1 > 0) {
				int courseTagResult2 = new CourseTagService().insertTags(courseNo, tags);
			}
			
			response.sendRedirect("/testt/gtcourse");
		}else {
			response.sendRedirect("/testt/gtcourse");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

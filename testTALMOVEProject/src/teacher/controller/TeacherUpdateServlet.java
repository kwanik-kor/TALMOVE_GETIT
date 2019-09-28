package teacher.controller;

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

import teacher.model.service.TeacherService;
import teacher.model.vo.Teacher;

@WebServlet("/teaup.ed")
public class TeacherUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TeacherUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("index.jsp");
			request.setAttribute("message", "Enctype속성이 누락되었어요!");
			view.forward(request, response);
		}
		
		String savePath = request.getSession().getServletContext().getRealPath("/resources/tprofile_upfiles");
		MultipartRequest mrequest = new MultipartRequest(request, savePath, 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		Teacher loginTeacher = (Teacher)request.getSession(false).getAttribute("loginTeacher");
		
		String tname = mrequest.getParameter("tname");
		String tcareer = mrequest.getParameter("tcareer");
		String tintro = mrequest.getParameter("tintro");
		loginTeacher.setTeacherName(tname);
		loginTeacher.setTeacherCareer(tcareer);
		loginTeacher.setTeacherIntro(tintro);
		String originFileName = mrequest.getParameter("oimage");
		String originRenameFileName = mrequest.getParameter("rimage");
		String oFileName = mrequest.getFilesystemName("pffile");
		if(originFileName != "") {
			if(oFileName != loginTeacher.getTeacherOimageName()) {
				if(loginTeacher.getTeacherRimageName() != null) {
					new File(request.getSession().getServletContext().getRealPath("/resources/tprofile_upfiles") + "/" + loginTeacher.getTeacherRimageName()).delete();
				}
				loginTeacher.setTeacherOimageName(oFileName);
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
					loginTeacher.setTeacherRimageName(rFileName);
				}
			}
		}
		int result = new TeacherService().upTeacherInfo(loginTeacher);
		if(result > 0) {
			request.getSession(false).setAttribute("loginTeacher", loginTeacher);
			response.sendRedirect("views/teacherPage/teacherPageDetail.jsp");
		}else {
			view = request.getRequestDispatcher("index.jsp");
			request.setAttribute("message", "강사정보 업데이트 실패");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package lecture.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import lecture.model.service.LectureService;
import lecture.model.vo.Lecture;

@WebServlet("/createNewLecture.do")
public class CreateNewLecture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateNewLecture() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String name = (request.getParameter("name"));
		Lecture lecture = new Lecture();
		LectureService lservice = new LectureService();
		int lectureNo = lservice.lectureCreate(no,name);
		if(lectureNo ==0) System.out.println("객체생성실패");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(lectureNo);
		out.flush();
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

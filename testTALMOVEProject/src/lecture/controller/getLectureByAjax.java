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

/**
 * Servlet implementation class getLectureByAjax
 */
@WebServlet("/getLectureByAjax.do")
public class getLectureByAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getLectureByAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블렛진입");
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("lecture no : " +no);
		Lecture lecture = new Lecture();
		LectureService lservice = new LectureService();
		lecture = lservice.getLectureByAjax(no);
		System.out.println("가져온 렉쳐이름"+ lecture.getLectureName());
		JSONObject sendJson =new JSONObject();
		sendJson.put("lectureNo",lecture.getLectureNo());
		sendJson.put("sectionNo",lecture.getSectionNo());
		sendJson.put("courseName",URLEncoder.encode(lecture.getCourseName(), "UTF-8"));
		sendJson.put("sectionName",URLEncoder.encode(lecture.getSectionName(), "UTF-8"));
		sendJson.put("LectureName",URLEncoder.encode(lecture.getLectureName(), "UTF-8"));
		if(lecture.getLectureOFileName() != null)
		sendJson.put("lectureOFileName",URLEncoder.encode(lecture.getLectureOFileName(), "UTF-8"));
		if(lecture.getLectureRFileName() != null)
		sendJson.put("lectureRFileName",URLEncoder.encode(lecture.getLectureRFileName(), "UTF-8"));
		if(lecture.getAttachmentOfileName() != null)
		sendJson.put("attachmentOfileName",URLEncoder.encode(lecture.getAttachmentOfileName(), "UTF-8"));
		if(lecture.getAttachmentRfileName() != null)
		sendJson.put("attachmentRfileName",URLEncoder.encode(lecture.getAttachmentRfileName(), "UTF-8"));
		if(lecture.getLectureContent() != null)
		sendJson.put("lectureContent",URLEncoder.encode(lecture.getLectureContent(), "UTF-8"));

		System.out.println(sendJson.toString());
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//json 객체를 json 문자열로 바꾸어 내보냄
		out.print(sendJson.toJSONString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

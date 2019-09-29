package course.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import course.model.service.CourseService;
import lecture.model.vo.Lecture;

/**
 * Servlet implementation class ajaxTestServlet
 */
@WebServlet("/test1.do")
public class ajaxTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajaxTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ajax 통신으로 요청받은 결과로 문자열을 내보내는 컨트롤러
		System.out.println("아작스 진입");
		int no = Integer.parseInt((request.getParameter("no")));
		System.out.println("넘어온 값 : " +no);
		CourseService cservice = new CourseService();
		ArrayList<Lecture> list = cservice.getLectureBySectionNo(no);
		/*
		for(Lecture l:list) {
			Lecture lecture = new Lecture();
			lecture.setLectureNo(l.getLectureNo());
			lecture.setSectionNo(l.getSectionNo());
			lecture.setCourseName(l.getCourseName());
			lecture.setSectionName(l.getSectionName());
			lecture.setLectureName(l.getLectureName());
			lecture.setLectureOFileName(l.getLectureOFileName());
			lecture.setLectureRFileName(l.getLectureRFileName());
			lecture.setAttachmentOfileName(l.getAttachmentOfileName());
			lecture.setAttachmentRfileName(l.getAttachmentRfileName());
			lecture.setLectureContent(l.getLectureContent());
			list.add(lecture);
		}*/
		
		JSONObject sendJSON = new JSONObject();
		JSONArray jarr = new JSONArray();
		for(Lecture lecture: list) {
			JSONObject job = new JSONObject();
			job.put("LectureNo",  lecture.getLectureNo());
			job.put("SectionNo", lecture.getSectionNo());
			job.put("CourseName", URLEncoder.encode(lecture.getCourseName(),"UTF-8"));
			job.put("SectionName", URLEncoder.encode(lecture.getSectionName(),"UTF-8"));
			job.put("LectureName", URLEncoder.encode(lecture.getLectureName(),"UTF-8"));
			job.put("LectureContent", URLEncoder.encode(lecture.getLectureContent(),"UTF-8"));
			jarr.add(job);
			System.out.println("인코딩 jarr: "+jarr.toString());
		}
		
		/*
		//job에 넣기
		JSONObject job = new JSONObject();
		job.put("LectureNo",  lecture.getLectureNo());
		job.put("SectionNo", lecture.getSectionNo());
		job.put("CourseName", URLEncoder.encode(lecture.getCourseName(),"UTF-8"));
		job.put("SectionName", URLEncoder.encode(lecture.getSectionName(),"UTF-8"));
		job.put("LectureName", URLEncoder.encode(lecture.getLectureName(),"UTF-8"));
		job.put("LectureOFileName", URLEncoder.encode(lecture.getLectureOFileName(),"UTF-8"));
		job.put("LectureRFileName", URLEncoder.encode(lecture.getLectureRFileName(),"UTF-8"));
		job.put("AttachmentRfileName", URLEncoder.encode(lecture.getAttachmentRfileName(),"UTF-8"));
		job.put("LectureContent", URLEncoder.encode(lecture.getLectureContent(),"UTF-8"));
		
		System.out.println("저장된 job : " + job.toJSONString());
		*/
		sendJSON.put("list", jarr);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(sendJSON.toJSONString());
		out.flush();
		out.close();;	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

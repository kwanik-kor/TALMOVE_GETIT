package category.controller;

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

import category.model.service.CategoryService;
import course.model.vo.Course;

/**
 * Servlet implementation class CourseSortServlet
 */
@WebServlet("/selsort")
public class CourseSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseSortServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryService cservice = new CategoryService();
		String category = request.getParameter("category");
		System.out.println(category);
		ArrayList<Course> list = cservice.selectSortPurchaseCounrt(category);

		// 전송할 json 객체 생성
		JSONObject sendJson = new JSONObject();
		JSONArray jarr = new JSONArray();

		// list 의 객체들을 하나씩 json 배열에 옮겨 저장 처리
		for (Course course : list) {
			// course 를 json 객체로 값 옮겨 저장
			JSONObject job = new JSONObject();
			job.put("courseNo", course.getCourseNo());
			// json 에서 한글 깨짐 막으려면,
			// java.net.URLEncoder 의 encode() 로 인코딩함
			job.put("courseName", URLEncoder.encode(course.getCourseName(), "UTF-8"));
			job.put("fileName", course.getThumbnailOfileName());
			job.put("description", URLEncoder.encode(course.getDescription(),"UTF-8"));
			job.put("price", course.getPrice());

			jarr.add(job);
		}
		
		//전송용 객체에 배열 저장
		sendJson.put("list", jarr);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(sendJson.toJSONString());
		out.flush();
		out.close();

		/*
		 * if(sortName == "인기도") { ArrayList<Course> list =
		 * cservice.selectSortPurchaseCounrt(); }else if(sortName == "최고평점") {
		 * 
		 * }else if(sortName == "최저가") {
		 * 
		 * }else {
		 * 
		 * }
		 */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

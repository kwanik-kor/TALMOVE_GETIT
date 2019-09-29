package category.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
		int currentPage = Integer.parseInt(request.getParameter("page"));
		 String category = request.getParameter("category");
		 String sortName = request.getParameter("sortName");
		 
		 System.out.println(sortName + category + currentPage);

	     int limit = 10;
	     
	     CategoryService cservice = new CategoryService();
	     
	     // 상위카테고리 조회
	     String categoryUpper = cservice.getCategoryUpper(category);
	     
	     // 총 목록 갯수 조회
	     int listCount = cservice.getListCount(category);
	     ArrayList<Course> list = null;
	     // 현재 페이지에 출력할 게시글 목록 조회
	     if(sortName.equals("pop")) {
	    	 list = cservice.selectSortPurchaseCounrt(currentPage, limit, category);
	     }else if(sortName.equals("row")) {
	    	 list = cservice.selectSortRowPrice(currentPage, limit, category);
	     }else {
	    	 list = cservice.selectSortHighPrice(currentPage, limit, category);
	     }
	     
	     
	     // 인기 강좌
	     ArrayList<Course> flist = cservice.starCourse(category);
	     
	     int maxPage = (int)((double)listCount / limit + 0.9);
	     int startPage = (((int)((double)currentPage / limit + 0.9))-1) * limit + 1;
	     int endPage = startPage + limit -1;
	     
	     if(maxPage < endPage) {
	    	 endPage = maxPage;
	     }
	     
	     RequestDispatcher view = null;
	     response.setContentType("text/html; charset=utf-8");
	     if(list.size() > 0) {
	    	 view = request.getRequestDispatcher("/views/category/categoryDetail.jsp");
	    	 request.setAttribute("list", list);
	    	 request.setAttribute("category", category);
	    	 request.setAttribute("currentPage", currentPage);
	    	 request.setAttribute("maxPage", maxPage);
	    	 request.setAttribute("startPage", startPage);
	    	 request.setAttribute("endPage", endPage);
	    	 request.setAttribute("listCount", listCount);
	    	 request.setAttribute("categoryUpper", categoryUpper);
	    	 request.setAttribute("flist", flist);
	    	 view.forward(request, response);
	     }else{
	    	 view = request.getRequestDispatcher("/views/category/noCourseCategory.jsp");
	    	 request.setAttribute("category", category);
	    	 request.setAttribute("categoryUpper", categoryUpper);
	    	 view.forward(request, response);
	     }
		
		/*// 전송할 json 객체 생성
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
		out.close();*/

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

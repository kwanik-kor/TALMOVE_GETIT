package course.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.model.service.CourseService;
import course.model.vo.Course;

/**
 * Servlet implementation class MyCourseServlet
 */
@WebServlet("/mclist")
public class MyCourseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyCourseListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentPage = 1;

		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		int limit = 8;

		CourseService cservice = new CourseService();
		
		int listCount = cservice.getListCount();

		// 현재 페이지에 출력할 강좌 목록 조회
		ArrayList<Course> list = cservice.selectCourse(currentPage, limit);

		
		int maxPage = listCount / limit;
		maxPage += (listCount % limit > 0) ? 1 : 0;

		int startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;
		int endPage = startPage + limit - 1;

		if (maxPage < endPage) {
			endPage = maxPage;
		}
		
		RequestDispatcher view = null;
		response.setContentType("text/html; charset=utf-8"); 
		if(list.size() > 0) {
			view = request.getRequestDispatcher("views/myCourse/myCourse.jsp");
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
			view.forward(request, response);
		}
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

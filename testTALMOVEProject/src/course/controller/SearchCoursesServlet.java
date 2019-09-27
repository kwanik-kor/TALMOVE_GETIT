package course.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.model.service.CourseService;
import course.model.vo.Course;

@WebServlet("/searchcourses.ed")
public class SearchCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchCoursesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt(request.getParameter("page"));
		String keyword = request.getParameter("keyword");
		String[] keywords = keyword.split(" ");
		ArrayList<Course> clist = new CourseService().getSearchedCourse(keywords);
		HashSet<Course> distinct = new HashSet<Course>(clist);
		clist = new ArrayList<Course>(distinct);
		
		int limit = 10;
		int listCount = clist.size();
		int maxPage = (int)((double)listCount / limit + 0.9);
		int startPage = (((int)((double)currentPage / limit + 0.9))-1) * limit + 1;
		int endPage = startPage + limit -1;
		 
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		RequestDispatcher view = request.getRequestDispatcher("views/course/searchedCourses.jsp");
		request.setAttribute("keyword", keyword);
		request.setAttribute("clist", clist);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("listCount", listCount);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package course.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

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
    private ArrayList<Course> sortCourseList(ArrayList<Course> clist, String sort){
    	if(sort.equals("popular")) {
    		clist = sortByPopular(clist);
    	}else if(sort.equals("price-asc")) {
    		clist = sortByPriceAsc(clist);
    	}
    	return clist;
    }
    private ArrayList<Course> sortByPriceAsc(ArrayList<Course> clist){
    	Collections.sort(clist, new Comparator<Course>() {
			@Override
			public int compare(Course c1, Course c2) {
				if(c1.getPrice() < c2.getPrice()) {
					return -1;
				}else if(c1.getPrice() > c2.getPrice()) {
					return 1;
				}
				return 0;
			}
    	});
    	return clist;
    }
    private ArrayList<Course> sortByPopular(ArrayList<Course> clist){
    	Collections.sort(clist, new Comparator<Course>() {
			@Override
			public int compare(Course c1, Course c2) {
				if(c1.getPurchaseCount() > c2.getPurchaseCount()) {
					return -1;
				}else if(c1.getPurchaseCount() < c2.getPurchaseCount()) {
					return 1;
				}
				return 0;
			}
    	});
    	return clist;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt(request.getParameter("page"));
		String keyword = request.getParameter("keyword");
		String[] keywords = keyword.split(" ");
		ArrayList<Course> clist = new CourseService().getSearchedCourse(keywords);
		HashSet<Course> distinct = new HashSet<Course>(clist);
		clist = new ArrayList<Course>(distinct);
		//sort : featured / popular / price-asc
		//priceRange : all / free / paid
		String sort = request.getParameter("sort");
		String priceRange = request.getParameter("priceRange");
		
		if(priceRange.equals("free")) {
			for(Iterator<Course> it = clist.iterator(); it.hasNext();) {
				Course c = it.next();
				if(c.getPrice() != 0) {
					it.remove();
				}
			}
			clist = sortCourseList(clist, sort);
		}else if(priceRange.equals("paid")) {
			for(Iterator<Course> it = clist.iterator(); it.hasNext();) {
				Course c = it.next();
				if(c.getPrice() == 0) {
					it.remove();
				}
			}
			clist = sortCourseList(clist, sort);
		}else {
			clist = sortCourseList(clist, sort);
		}
		
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
		request.setAttribute("sort", sort);
		request.setAttribute("priceRange", priceRange);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

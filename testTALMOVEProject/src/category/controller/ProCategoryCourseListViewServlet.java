package category.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import category.model.service.CategoryService;
import course.model.vo.Course;

/**
 * Servlet implementation class ProCategoryCourseListViewServlet
 */
@WebServlet("/pccourse")
public class ProCategoryCourseListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProCategoryCourseListViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt(request.getParameter("page"));
		 String category = request.getParameter("category");

	     int limit = 10;
	     
	     CategoryService cservice = new CategoryService();
	     
	     // 상위카테고리 조회
	     String categoryUpper = cservice.getCategoryUpper(category);
	     
	     // 총 목록 갯수 조회
	     int listCount = cservice.getListCount(category);
	     
	     // 현재 페이지에 출력할 게시글 목록 조회
	     ArrayList<Course> list = cservice.courseListView(currentPage, limit, category);
	     
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
	    	 view = request.getRequestDispatcher("/views/category/ProCategory.jsp");
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
	    	 view = request.getRequestDispatcher("/views/category/proNoCourse.jsp");
	    	 request.setAttribute("category", category);
	    	 request.setAttribute("categoryUpper", categoryUpper);
	    	 view.forward(request, response);
	     }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

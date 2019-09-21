package review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;

/**
 * Servlet implementation class CourseReviewDeleteServlet
 */
@WebServlet("/crdelete")
public class CourseReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CourseReviewDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int courseNo = Integer.parseInt(request.getParameter("cno"));
		int userNo = Integer.parseInt(request.getParameter("uno"));
		
		if (new ReviewService().deleteReview(reviewNo))
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

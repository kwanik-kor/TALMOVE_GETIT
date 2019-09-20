package review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * Servlet implementation class CourseReviewServlet
 */
@WebServlet("/creview")
public class CourseReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CourseReviewServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//리뷰 작성 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		
		int rating = Integer.parseInt(request.getParameter("star"));
		String reviewContent = request.getParameter("content");
		int courseNo = Integer.parseInt(request.getParameter("cno"));
		int userNo = Integer.parseInt(request.getParameter("uno"));
		
		Review review = new Review();
		
		review.setCourseNo(courseNo);
		review.setRating(rating);
		review.setUserNo(userNo);
		review.setReviewContent(reviewContent);;
		
		
		//리뷰 등록처리
		int result = new ReviewService().insertReview(review);
		
		RequestDispatcher view = null;
		response.setContentType("text/html; charset=utf-8"); 
		
		
		String mapping = "/mclist?userNo=" + userNo;
		if(result > 0) {
			view = request.getRequestDispatcher(mapping);
			request.setAttribute("rating", rating);
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

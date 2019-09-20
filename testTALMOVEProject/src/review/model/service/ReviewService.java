package review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import review.model.dao.ReviewDao;
import review.model.vo.Review;
import static common.JDBCTemplate.*;

public class ReviewService {
	private ReviewDao rdao = new ReviewDao();
	
	//학열
	public int insertReview(Review review) {
		Connection conn = getConnection();
		int result = rdao.insertReview(conn, review);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
	}
	
	public int updateReview(Review review){
		return 0;
	}

	public int deleteReview(int reviewNo) {
		Connection conn = getConnection();
		int result = rdao.deleteReview(conn, reviewNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		
		return result;
	}
	
	public Review reviewOne(int loginUserNo)  {
		Connection conn = getConnection();
		Review review = rdao.reviewOne(conn, loginUserNo);
		close(conn);
		return review;
	}
	
	//지우
	public ArrayList<Review> courseReviewView(int loginUserNo)  {
		Connection conn = getConnection();
		ArrayList<Review> list = rdao.courseReviewView(conn, loginUserNo);
		close(conn);
		return list;
	} //강좌 리뷰 뷰
}

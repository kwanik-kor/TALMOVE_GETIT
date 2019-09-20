package review.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import course.model.vo.Course;
import review.model.vo.Review;

public class ReviewDao {

	//학열
	public int insertReview(Connection conn, Review review) {
	
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into review values ("
				+ "(select max(review_no) + 1 from review), "
				+ "?, ?, ?, ?, sysdate, null)";
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, review.getCourseNo());
			pstmt.setInt(2, review.getUserNo());
			pstmt.setInt(3, review.getRating());
			pstmt.setString(4, review.getReviewContent());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateReview(Connection conn, Review review){
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update review set rating=?, review_content = ? where review_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  review.getReviewContent());
			pstmt.setInt(2, review.getRating());
			pstmt.setInt(3, review.getReviewNo());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteReview(Connection conn, int reviewNo) {
		int result=0;
		PreparedStatement pstmt = null;
		
		String query = "delete from review where review_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	} 
	
	public Review reviewOne(Connection conn, int loginUserNo) {
		Review review = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select c.course_no, teacher_no, course_name, thumbnail_ofilename, thumbnail_rfilename, "
				+ "review_no, user_no, rating, review_content, review_date, modified_review_date "
				+ "from course c join review r on(c.course_no = r.course_no) "
				+ "where r.user_no = ?";
		
		int userNo = loginUserNo;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				review = new Review();
				review.setReviewNo(rset.getInt("review_no"));
				review.setUserNo(rset.getInt("userNo"));
				review.setRating(rset.getInt("rating"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewDate(rset.getDate("review_date"));
				review.setModifiedReviewDate(rset.getDate("modified_review_date"));
			}
			
		} catch(Exception e) {
			close(rset);
			close(pstmt);
		}
		
		return review;
	}
	
	//지우 //강좌 리뷰 뷰
	public ArrayList<Review> courseReviewView(Connection conn, int loginUserNo) {
		ArrayList<Review> list = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select c.course_no, teacher_no, course_name, thumbnail_ofilename, thumbnail_rfilename, "
				+ "review_no, user_no, rating, review_content, review_date, modified_review_date "
				+ "from course c join review r on(c.course_no = r.course_no) "
				+ "where r.user_no = ?";
		
		int userNo = loginUserNo;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Review review = new Review();
				review.setReviewNo(rset.getInt("review_no"));
				review.setUserNo(rset.getInt("userNo"));
				review.setRating(rset.getInt("rating"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewDate(rset.getDate("review_date"));
				review.setModifiedReviewDate(rset.getDate("modified_review_date"));
			}
			
		} catch(Exception e) {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	
}

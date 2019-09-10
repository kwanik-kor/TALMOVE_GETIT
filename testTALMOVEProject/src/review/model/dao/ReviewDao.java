package review.model.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import review.model.vo.Review;

public class ReviewDao {

	//학열
	public HashMap<Integer, String> insertReview(Connection conn, int userNo, int lectureNo, Review review) {
		return null;}
	
	public int UpdateReview(Connection conn, Review review){
		return 0;}
	
	//지우 //강좌 리뷰 뷰
	public ArrayList<Review> courseReviewView(Connection conn, int courseNo)  {
		return null;} 
}

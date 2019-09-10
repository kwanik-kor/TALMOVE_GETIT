package review.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Review implements Serializable{
	private static final long serialVersionUID = 1900L; 

	private  int reviewNo;
	private  int courseNo;
	private  int userNo;
	private  int rating;
	private  String reviewContent;
	private  Date reviewDate;
	private  Date modifiedReviewDate;
	
	
	public Review(int reviewNo, int courseNo, int userNo, int rating, String reviewContent, Date reviewDate,
			Date modifiedReviewDate) {
		super();
		this.reviewNo = reviewNo;
		this.courseNo = courseNo;
		this.userNo = userNo;
		this.rating = rating;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.modifiedReviewDate = modifiedReviewDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public int getCourseNo() {
		return courseNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public int getRating() {
		return rating;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public Date getModifiedReviewDate() {
		return modifiedReviewDate;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public void setModifiedReviewDate(Date modifiedReviewDate) {
		this.modifiedReviewDate = modifiedReviewDate;
	}
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", courseNo=" + courseNo + ", userNo=" + userNo + ", rating=" + rating
				+ ", reviewContent=" + reviewContent + ", reviewDate=" + reviewDate + ", modifiedReviewDate="
				+ modifiedReviewDate + "]";
	}
	
	
	
	
}

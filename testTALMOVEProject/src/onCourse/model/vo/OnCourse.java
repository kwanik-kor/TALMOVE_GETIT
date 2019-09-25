package onCourse.model.vo;

public class OnCourse {
	
	private int userNo;
	private int courseNo;
	
	
	public OnCourse() {}


	public OnCourse(int userNo, int courseNo) {
		super();
		this.userNo = userNo;
		this.courseNo = courseNo;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public int getCourseNo() {
		return courseNo;
	}


	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}


	@Override
	public String toString() {
		return "OnCourse [userNo=" + userNo + ", courseNo=" + courseNo + "]";
	};
	
}
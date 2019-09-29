package onCourse.model.vo;

import java.io.Serializable;

public class OnCourse implements Serializable{
	private static final long serialVersionUID = 2200L; 
	
	private int userNo;
	private int courseNo;
	
	
	public OnCourse() {}





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





	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	@Override
	public String toString() {
		return "OnCourse [userNo=" + userNo + ", courseNo=" + courseNo + "]";
	};
	
}
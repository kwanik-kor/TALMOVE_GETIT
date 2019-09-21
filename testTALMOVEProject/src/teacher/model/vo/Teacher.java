package teacher.model.vo;

import java.io.Serializable;

public class Teacher implements Serializable{
	private static final long serialVersionUID = 1100L; 
	private int teacherNo;
	private int userNo;
	private String teacherName;
	private String teacherCareer;
	private String teacherIntro;
	private String teacherOimageName;
	private String teacherRimageName;
	private int teacherAccountnumber;
	
	public Teacher() {}
	
	public Teacher(int teacherNo, int userNo, String teacherName, String teacherCareer, String teacherIntro,
			String teacherOimageName, String teacherRimageName, int teacherAccountnumber) {
		super();
		this.teacherNo = teacherNo;
		this.userNo = userNo;
		this.teacherName = teacherName;
		this.teacherCareer = teacherCareer;
		this.teacherIntro = teacherIntro;
		this.teacherOimageName = teacherOimageName;
		this.teacherRimageName = teacherRimageName;
		this.teacherAccountnumber = teacherAccountnumber;
	}


	public int getTeacherNo() {
		return teacherNo;
	}


	public void setTeacherNo(int teacherNo) {
		this.teacherNo = teacherNo;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public String getTeacherCareer() {
		return teacherCareer;
	}


	public void setTeacherCareer(String teacherCareer) {
		this.teacherCareer = teacherCareer;
	}


	public String getTeacherIntro() {
		return teacherIntro;
	}


	public void setTeacherIntro(String teacherIntro) {
		this.teacherIntro = teacherIntro;
	}


	public String getTeacherOimageName() {
		return teacherOimageName;
	}


	public void setTeacherOimageName(String teacherOimageName) {
		this.teacherOimageName = teacherOimageName;
	}


	public String getTeacherRimageName() {
		return teacherRimageName;
	}


	public void setTeacherRimageName(String teacherRimageName) {
		this.teacherRimageName = teacherRimageName;
	}


	public int getTeacherAccountnumber() {
		return teacherAccountnumber;
	}


	public void setTeacherAccountnumber(int teacherAccountnumber) {
		this.teacherAccountnumber = teacherAccountnumber;
	}


	@Override
	public String toString() {
		return "Teacher [teacherNo=" + teacherNo + ", userNo=" + userNo + ", teacherName=" + teacherName
				+ ", teacherCareer=" + teacherCareer + ", teacherIntro=" + teacherIntro + ", teacherOimageName="
				+ teacherOimageName + ", teacherRimageName=" + teacherRimageName + ", teacherAccoumtnumber="
				+ teacherAccountnumber + "]";
	}
	
	
	
	
}

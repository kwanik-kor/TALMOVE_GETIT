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
	private int teacherAccoumtnumber;
	
	
	public Teacher(int teacherNo, int userNo, String teacherName, String teacherCareer, String teacherIntro,
			String teacherOimageName, String teacherRimageName, int teacherAccoumtnumber) {
		super();
		this.teacherNo = teacherNo;
		this.userNo = userNo;
		this.teacherName = teacherName;
		this.teacherCareer = teacherCareer;
		this.teacherIntro = teacherIntro;
		this.teacherOimageName = teacherOimageName;
		this.teacherRimageName = teacherRimageName;
		this.teacherAccoumtnumber = teacherAccoumtnumber;
	}

	
	
}

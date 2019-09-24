package lecture.model.vo;

import java.io.Serializable;

public class Lecture implements Serializable{
	private static final long serialVersionUID = 1400L;
	
	private int lectureNo;
	private int sectionNo;
	private String courseName;
	private String sectionName;
	private String lectureName;
	private String lerctureOFileName;
	private String lerctureRFileName;
	private String attachmentOfileName;
	private String attachmentRfileName;
	private String lectureContent;
	public Lecture(int lectureNo, int sectionNo, String courseName, String sectionName, String lectureName,
			String lerctureOFileName, String lerctureRFileName, String attachmentOfileName, String attachmentRfileName,
			String lectureContent) {
		super();
		this.lectureNo = lectureNo;
		this.sectionNo = sectionNo;
		this.courseName = courseName;
		this.sectionName = sectionName;
		this.lectureName = lectureName;
		this.lerctureOFileName = lerctureOFileName;
		this.lerctureRFileName = lerctureRFileName;
		this.attachmentOfileName = attachmentOfileName;
		this.attachmentRfileName = attachmentRfileName;
		this.lectureContent = lectureContent;
	}
	
	public Lecture() {}

	public int getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}

	public int getSectionNo() {
		return sectionNo;
	}

	public void setSectionNo(int sectionNo) {
		this.sectionNo = sectionNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getLerctureOFileName() {
		return lerctureOFileName;
	}

	public void setLerctureOFileName(String lerctureOFileName) {
		this.lerctureOFileName = lerctureOFileName;
	}

	public String getLerctureRFileName() {
		return lerctureRFileName;
	}

	public void setLerctureRFileName(String lerctureRFileName) {
		this.lerctureRFileName = lerctureRFileName;
	}

	public String getAttachmentOfileName() {
		return attachmentOfileName;
	}

	public void setAttachmentOfileName(String attachmentOfileName) {
		this.attachmentOfileName = attachmentOfileName;
	}

	public String getAttachmentRfileName() {
		return attachmentRfileName;
	}

	public void setAttachmentRfileName(String attachmentRfileName) {
		this.attachmentRfileName = attachmentRfileName;
	}

	public String getLectureContent() {
		return lectureContent;
	}

	public void setLectureContent(String lectureContent) {
		this.lectureContent = lectureContent;
	}
	

}

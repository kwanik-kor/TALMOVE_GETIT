package lecture.model.vo;

import java.io.Serializable;

public class Lecture implements Serializable{
	private static final long serialVersionUID = 1400L;
	
	private int lectureNo;
	private int sectionNo;
	private String courseName;
	private String sectionName;
	private String lectureName;
	private String lectureOFileName;
	private String lectureRFileName;
	private String attachmentOfileName;
	private String attachmentRfileName;
	private String lectureContent;
	
	public Lecture() {}

	@Override
	public String toString() {
		return "Lecture [lectureNo=" + lectureNo + ", sectionNo=" + sectionNo + ", courseName=" + courseName
				+ ", sectionName=" + sectionName + ", lectureName=" + lectureName + ", lectureOFileName="
				+ lectureOFileName + ", lectureRFileName=" + lectureRFileName + ", attachmentOfileName="
				+ attachmentOfileName + ", attachmentRfileName=" + attachmentRfileName + ", lectureContent="
				+ lectureContent + "]";
	}

	public Lecture(int lectureNo, int sectionNo, String courseName, String sectionName, String lectureName,
			String lectureOFileName, String lectureRFileName, String attachmentOfileName, String attachmentRfileName,
			String lectureContent) {
		super();
		this.lectureNo = lectureNo;
		this.sectionNo = sectionNo;
		this.courseName = courseName;
		this.sectionName = sectionName;
		this.lectureName = lectureName;
		this.lectureOFileName = lectureOFileName;
		this.lectureRFileName = lectureRFileName;
		this.attachmentOfileName = attachmentOfileName;
		this.attachmentRfileName = attachmentRfileName;
		this.lectureContent = lectureContent;
	}

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

	public String getLectureOFileName() {
		return lectureOFileName;
	}

	public void setLectureOFileName(String lectureOFileName) {
		this.lectureOFileName = lectureOFileName;
	}

	public String getLectureRFileName() {
		return lectureRFileName;
	}

	public void setLectureRFileName(String lectureRFileName) {
		this.lectureRFileName = lectureRFileName;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	};
	

}

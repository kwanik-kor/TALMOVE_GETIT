package comment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Comment implements Serializable{
	private static final long serialVersionUID = 1700L; 

	private int commentNo;
	private int userNo;
	private int lectureNo;
	private String commentContent;
	private String commentOriginalFileName;
	private String commentRenameFileName;
	private Date commentDate;
	private Date modifiedDate;
	
	public Comment() {}

	public Comment(int commentNo, int userNo, int lectureNo, String commentContent, String commentOriginalFileName,
			String commentRenameFileName, Date commentDate, Date modifiedDate) {
		super();
		this.commentNo = commentNo;
		this.userNo = userNo;
		this.lectureNo = lectureNo;
		this.commentContent = commentContent;
		this.commentOriginalFileName = commentOriginalFileName;
		this.commentRenameFileName = commentRenameFileName;
		this.commentDate = commentDate;
		this.modifiedDate = modifiedDate;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getLectureNo() {
		return lectureNo;
	}

	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentOriginalFileName() {
		return commentOriginalFileName;
	}

	public void setCommentOriginalFileName(String commentOriginalFileName) {
		this.commentOriginalFileName = commentOriginalFileName;
	}

	public String getCommentRenameFileName() {
		return commentRenameFileName;
	}

	public void setCommentRenameFileName(String commentRenameFileName) {
		this.commentRenameFileName = commentRenameFileName;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", userNo=" + userNo + ", lectureNo=" + lectureNo
				+ ", commentContent=" + commentContent + ", commentOriginalFileName=" + commentOriginalFileName
				+ ", commentRenameFileName=" + commentRenameFileName + ", commentDate=" + commentDate
				+ ", modifiedDate=" + modifiedDate + "]";
	}
}

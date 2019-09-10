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
}

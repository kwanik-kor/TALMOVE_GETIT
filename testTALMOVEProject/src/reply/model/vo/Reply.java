package reply.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Reply implements Serializable{
	private static final long serialVersionUID = 1800L;

	
	private int replyNo;
	private int userNo;
	private int lectureNo;
	private String replyContent;
	private String replyOriginalFileName;
	private String replyRenameFileName;
	private Date replyDate;
	private Date modifiedDate;
}

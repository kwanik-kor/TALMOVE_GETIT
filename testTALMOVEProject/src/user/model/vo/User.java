package user.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{
	private static final long serialVersionUID = 1000L;
	
	private int userNo;
	private String userEmail;
	private String userPwd;
	private String userName;
	private String userOImageName;
	private String userRImageName;
	private Date userEnrollDate;
	private String userEmailHash;
	private String userEmailChecked;
	
	public User() {}

	public User(int userNo, String userEmail, String userPwd, String userName, String userOImageName,
			String userRImageName, Date userEnrollDate, String userEmailHash, String userEmailChecked) {
		super();
		this.userNo = userNo;
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userOImageName = userOImageName;
		this.userRImageName = userRImageName;
		this.userEnrollDate = userEnrollDate;
		this.userEmailHash = userEmailHash;
		this.userEmailChecked = userEmailChecked;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserOImageName() {
		return userOImageName;
	}

	public void setUserOImageName(String userOImageName) {
		this.userOImageName = userOImageName;
	}

	public String getUserRImageName() {
		return userRImageName;
	}

	public void setUserRImageName(String userRImageName) {
		this.userRImageName = userRImageName;
	}

	public Date getUserEnrollDate() {
		return userEnrollDate;
	}

	public void setUserEnrollDate(Date userEnrollDate) {
		this.userEnrollDate = userEnrollDate;
	}

	public String getUserEmailHash() {
		return userEmailHash;
	}

	public void setUserEmailHash(String userEmailHash) {
		this.userEmailHash = userEmailHash;
	}

	public String getUserEmailChecked() {
		return userEmailChecked;
	}

	public void setUserEmailChecked(String userEmailChecked) {
		this.userEmailChecked = userEmailChecked;
	}

	@Override
	public String toString() {
		return "User [userNo=" + userNo + ", userEmail=" + userEmail + ", userPwd=" + userPwd + ", userOImageName="
				+ userOImageName + ", userRImageName=" + userRImageName + ", userEnrollDate=" + userEnrollDate
				+ ", userEmailHash=" + userEmailHash + ", userEmailChecked=" + userEmailChecked + "]";
	}
}

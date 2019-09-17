package user.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import user.model.vo.User;

import static common.JDBCTemplate.*;

public class UserDao {
	public UserDao() {}
	
	public int registUser(Connection conn, User user) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO TALMOVE_USER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, NULL, NULL, DEFAULT, ?, 0, NULL)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getUserEmail());
			pstmt.setString(2, user.getUserPwd());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserEmailHash());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public User getUserOneByMail(Connection conn, String uemail) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT USER_EMAILHASH FROM TALMOVE_USER WHERE USER_EMAILHASH = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uemail);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				user = new User();
				user.setUserEmailHash(rset.getString("user_emailhash"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return user;
	}

	public int setEmailCheckedUser(Connection conn, String uemail) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE TALMOVE_USER SET USER_EMAILCHECKED='1' WHERE USER_EMAILHASH = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uemail);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public User loginCheck(Connection conn, String uemail, String upwd) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM TALMOVE_USER WHERE USER_EMAIL = ? AND USER_PWD = ? AND USER_EMAILCHECKED = '1'";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uemail);
			pstmt.setString(2, upwd);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				user = new User();
				user.setUserNo(rset.getInt("user_no"));
				user.setUserEmail(uemail);
				user.setUserPwd(upwd);
				user.setUserName(rset.getString("user_name"));
				user.setUserOImageName(rset.getString("user_oimage_name"));
				user.setUserRImageName(rset.getString("user_rimage_name"));
				user.setUserEnrollDate(rset.getDate("user_enroll_date"));
				user.setUserEmailHash(rset.getString("user_emailhash"));
				user.setUserEmailChecked(rset.getString("user_emailchecked"));
				user.setTeacherNo(rset.getInt("teacher_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return user;
	}

	public User checkPwdSame(Connection conn, String upwd, String uemail) {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT USER_EMAIL, USER_PWD FROM TALMOVE_USER WHERE USER_PWD = ? AND USER_EMAIL = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, upwd);
			pstmt.setString(2, uemail);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				user = new User();
				user.setUserEmail(uemail);
				user.setUserPwd(upwd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		return user;
	}

	public int setNewPwd(Connection conn, String uemail, String upwd) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE TALMOVE_USER SET USER_PWD = ? WHERE USER_EMAILHASH = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, upwd);
			pstmt.setString(2, uemail);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}

package user.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import user.model.dao.UserDao;
import user.model.vo.User;

public class UserService {
	private UserDao udao = new UserDao();
	
	public UserService() {}
	
	public int RegistUser(User user) {
		Connection conn = getConnection();
		int result = udao.registUser(conn, user);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	//인증메일 통해서 왔을 때 해당 이메일 해시값이 존재하는지 확인용
	public User getUserOneByMail(String uemail) {
		Connection conn = getConnection();
		User user = udao.getUserOneByMail(conn, uemail);
		close(conn);
		return user;
	}
	//있을 경우 이메일 인증 완료 처리
	public int setEmailChecked(String uemail) {
		Connection conn = getConnection();
		int result = udao.setEmailCheckedUser(conn, uemail);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public User loginCheck(String uemail, String upwd) {
		Connection conn = getConnection();
		User user = udao.loginCheck(conn, uemail, upwd);
		close(conn);
		return user;
	}

	public User checkPwdSame(String upwd, String uemail) {
		Connection conn = getConnection();
		User user = udao.checkPwdSame(conn, upwd, uemail);
		close(conn);
		return user;
	}

	public int setNewPwd(String uemail, String upwd) {
		Connection conn = getConnection();
		int result = udao.setNewPwd(conn, uemail, upwd);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public int tnumUpdate(int userNo) {
		Connection conn = getConnection();
		int result = udao.tnumUpdate(conn, userNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	public int deleteUser(String uemail) {
		Connection conn = getConnection();
		int result = udao.deleteUser(conn, uemail);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
}

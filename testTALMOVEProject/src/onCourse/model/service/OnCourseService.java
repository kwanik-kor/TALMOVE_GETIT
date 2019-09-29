package onCourse.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import cart.model.vo.Cart;
import onCourse.model.dao.OnCourseDao;
import onCourse.model.vo.OnCourse;


public class OnCourseService {
	
	OnCourseDao oDao = new OnCourseDao();

	
	public int addOnCourse(int userNo, int courseNo) {
		Connection conn = getConnection();
		int result = oDao.addOnCourse(conn, userNo, courseNo);
		System.out.println("서비스로 넘어온 userNo" + userNo + " courseNo" + courseNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	
	public int onCourseCheck(int userNo, int courseNo) {
		Connection conn = getConnection();
		int result = oDao.onCourseCheck(conn, userNo, courseNo);
		System.out.println("onCourseCheck 서비스로 넘어온 userNo" + userNo + " courseNo" + courseNo);
		close(conn);
		return result;
	}

}

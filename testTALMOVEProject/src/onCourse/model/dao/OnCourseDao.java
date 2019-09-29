package onCourse.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;

import onCourse.model.vo.OnCourse;


public class OnCourseDao {

	public int addOnCourse(Connection conn, int userNo, int courseNo) {
		OnCourse onCourse = new OnCourse();
		int result = 0;
		PreparedStatement pstmt = null;
		System.out.println("DAO로 넘어온 userNo" + userNo + "courseNo" + courseNo);
		System.out.println("DAO getUserNo" + onCourse.getUserNo() + "getCourseNo" + onCourse.getCourseNo());
		
		String query = "INSERT INTO ON_COURSE VALUES(?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, courseNo);
			
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		
		return result;
	}

	
	

	
	
}

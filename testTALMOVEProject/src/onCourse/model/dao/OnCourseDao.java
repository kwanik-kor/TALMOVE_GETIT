package onCourse.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	public int onCourseCheck(Connection conn, int userNo, int courseNo) {
		OnCourse onCourse = new OnCourse();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int result = 0;
		
		String query = "SELECT * " 
						+ "FROM ON_COURSE " 
						+ "WHERE USER_NO = ? " 
						+ "AND COURSE_NO = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, courseNo);
			
			rset = pstmt.executeQuery();
			onCourse.setUserNo(userNo);
			onCourse.setCourseNo(courseNo);
			//1이면 정보가 있음
			//0이면 정보 없음 
			System.out.println("onCourseCheckDao에서 사용된 userNo " + userNo);
			System.out.println("onCourseCheckDao에서 사용된 courseNO " + courseNo);
			
			if(rset.next()) {
				result = 1;
			}else {
				result = 0;
			}
				
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		
		return result;
	}

	
/*	public ArrayList<OnCourse> onCourseCheck(Connection conn, int userNo, int courseNo) {
		ArrayList<OnCourse> onCourseList = new ArrayList<OnCourse>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * " 
						+ "FROM ON_COURSE " 
						+ "WHERE USER_NO = ? " 
						+ "AND COURSE_NO = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, courseNo);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				OnCourse onCourse = new OnCourse();
				onCourse.setUserNo(rset.getInt(1));
				onCourse.setCourseNo(rset.getInt(2));
				
				onCourseList.add(onCourse);
				System.out.println("onCourseList dao에 대한 확인 " + onCourseList.size());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		
		return onCourseList;
	}*/

	
	
}

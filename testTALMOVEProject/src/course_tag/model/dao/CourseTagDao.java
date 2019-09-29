package course_tag.model.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import course_tag.model.vo.CourseTag;

public class CourseTagDao {
	public CourseTagDao() {}

	public ArrayList<CourseTag> getCourseTagList(Connection conn, int teacherNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM COURSE_TAG WHERE COURSE_NO IN (SELECT COURSE_NO FROM COURSE WHERE TEACHER_NO = ?)";
		ArrayList<CourseTag> ctList = new ArrayList<CourseTag>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, teacherNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				CourseTag ct = new CourseTag();
				ct.setCourseNo(rset.getInt("course_no"));
				ct.setTagId(rset.getInt("tag_id"));
				ctList.add(ct);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return ctList;
	}

	public int insertTags(Connection conn, int courseNo, String[] tags) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO COURSE_TAG SELECT ?, (SELECT TAG_ID FROM TAG WHERE TAG_NAME = ?) FROM DUAL WHERE NOT EXISTS(SELECT COURSE_NO, TAG_ID FROM COURSE_TAG LEFT OUTER JOIN TAG USING(TAG_ID) WHERE TAG_NAME = ? AND COURSE_NO = ?)";
		try {
			pstmt = conn.prepareStatement(query);
			for(int i = 0; i<tags.length; i++) {
				pstmt.setInt(1, courseNo);
				pstmt.setString(2, tags[i]);
				pstmt.setString(3, tags[i]);
				pstmt.setInt(4, courseNo);
				result += pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int clearTags(Connection conn, int courseNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM COURSE_TAG WHERE COURSE_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, courseNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
}

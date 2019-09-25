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
	
	
}

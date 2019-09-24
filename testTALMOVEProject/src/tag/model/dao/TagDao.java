package tag.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import tag.model.vo.Tag;

public class TagDao {
	
	
	
	public ArrayList<Tag> exixtingCheck(Connection conn, Tag tag){
		return null;}
	
	public ArrayList<Tag> tagSave(Connection conn, Tag tag){
		return null;}
	
	public ArrayList<Tag> TagRestoreProcess(Connection conn, Tag tag){
		return null;}

	public int insertTag(Connection conn, String[] tagList) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO TAG SELECT SEQ_TAGNO.NEXTVAL, ? FROM DUAL WHERE NOT EXISTS(SELECT TAG_NAME FROM TAG WHERE TAG_NAME = ?)";
		try {
			pstmt = conn.prepareStatement(query);
			for(int i = 0; i<tagList.length; i++) {
				pstmt.setString(1, tagList[i]);
				pstmt.setString(2, tagList[i]);
				result += pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertTagCourse(Connection conn, int courseNo, String[] tagList) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO COURSE_TAG VALUES(?, (SELECT TAG_ID FROM TAG WHERE TAG_NAME = ?))";
		try {
			pstmt = conn.prepareStatement(query);
			for(int i = 0; i < tagList.length; i++) {
				pstmt.setInt(1, courseNo);
				pstmt.setString(2, tagList[i]);
				result += pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Tag> getTagListByTNo(Connection conn, int teacherNo) {
		ArrayList<Tag> tagList = new ArrayList<Tag>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT TAG_ID, TAG_NAME FROM TAG WHERE TAG_ID IN (SELECT TAG_ID FROM COURSE_TAG WHERE COURSE_NO IN(SELECT COURSE_NO FROM COURSE WHERE TEACHER_NO = ?))";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, teacherNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Tag t = new Tag();
				t.setTagId(rset.getInt("tag_id"));
				t.setTagName(rset.getString("tag_name"));
				tagList.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return tagList;
	}

}

package lecture.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import static common.JDBCTemplate.*;
import lecture.model.vo.Lecture;
public class LectureDao {

	
	public Lecture selectOne(Connection conn, int lectureNo){
		return null;}//해당강의불러오기(강의상세
	
	
	public ArrayList<Lecture> selectLecture(Connection conn, int lectureNo){
		return null;} //강의목록불러오기
	
	public ArrayList<Lecture> LectureListLoad(Connection conn, int sectionNo) {
		ArrayList<Lecture> list = new ArrayList<Lecture>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = 	"SELECT LECTURE_NO ,COURSE_NAME, SECTION_NAME, LECTURE_NAME, LECTURE_ORIGINAL_FILENAME, LECTURE_RENAME_FILENAME, ATTACHMENT_OFILENAME, ATTACHMENT_RFILENAME, LECTURE_CONTENT " + 
						"FROM LECTURE " + 
						"WHERE SECTION_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sectionNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Lecture lecture = new Lecture();
				lecture.setLectureNo(rset.getInt("lecture_no"));
				lecture.setSectionNo(sectionNo);
				lecture.setCourseName(rset.getString("course_name")	);
				lecture.setSectionName(rset.getString("section_name"));
				lecture.setLectureName(rset.getString("lecture_Name"));
				lecture.setLectureOFileName(rset.getString("lecture_original_filename"));
				lecture.setLectureRFileName(rset.getString("lecture_rename_filename"));
				lecture.setAttachmentOfileName(rset.getString("attachment_ofileName"));
				lecture.setAttachmentRfileName(rset.getString("attachment_rfilename"));
				lecture.setLectureContent(rset.getString("lecture_content"));
			
				list.add(lecture);
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}


	public ArrayList<Lecture> LectureNameLoad(Connection conn, int sectionNo) {
		ArrayList<Lecture> list = new ArrayList<Lecture>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = 	"SELECT LECTURE_NO, LECTURE_NAME " + 
						"FROM LECTURE " + 
						"WHERE SECTION_NO = ?" +
						"ORDER BY LECTURE_NO";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, sectionNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				Lecture lecture = new Lecture();
				
				
				lecture.setLectureNo(rset.getInt("lecture_no"));
				lecture.setSectionNo(sectionNo);
				lecture.setLectureName(rset.getString("lecture_name"));
				list.add(lecture);
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("LECTURE NAME SEARCHIN SUCESS!");
		return list;
	}


	public int createNewClass(Connection conn, int va) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = 	"SELECT LECTURE_NO, LECTURE_NAME " + 
						"FROM LECTURE " + 
						"WHERE SECTION_NO = ?" +
						"ORDER BY LECTURE_NO";
		
		
		
		return result;
		
		
		
	}
	
}

package lecture.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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





	public int lectureDelete(Connection conn, int lectureNo) {
		PreparedStatement pstmt = null;
		String query = 	"delete LECTURE	WHERE LECTURE_NO=? ";
				
		int result=0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, lectureNo);
			result=pstmt.executeUpdate();
			System.out.println("try");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}


	public int lectureCreate(Connection conn, int no, String name) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = "	insert into lecture values (SEQ_LECTURENO.nextval, ?,?,(select section_name from section where section_no = ?),  'new class',null,null,null,null,'WELCOME TO TALMOVE!')";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setString(2, name);
			pstmt.setInt(3, no);
			
			result=pstmt.executeUpdate();
			System.out.println("try");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}


	public int lectureRename(Connection conn, int no, String name) {
		PreparedStatement pstmt = null;
		String query = 	"UPDATE LECTURE SET LECTURE_NAME = ? WHERE LECTURE_NO=? ";
		int result=0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,name);
			pstmt.setInt(2,no);
			result=pstmt.executeUpdate();
			System.out.println("try");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("저장결과 : "+result);
		return result;
	}


	public Lecture getLectureByAjax(Connection conn, int no) {
		Lecture lecture = new Lecture();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = 	"SELECT * " + 
						"FROM LECTURE " + 
						"WHERE LECTURE_NO= ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				lecture.setLectureNo(rset.getInt("lecture_no"));
				lecture.setSectionNo(rset.getInt("section_no"));
				lecture.setCourseName(rset.getString("course_name")	);
				lecture.setSectionName(rset.getString("section_name"));
				lecture.setLectureName(rset.getString("lecture_name"));
				lecture.setLectureOFileName(rset.getString("lecture_original_filename"));
				lecture.setLectureRFileName(rset.getString("lecture_rename_filename"));
				lecture.setAttachmentOfileName(rset.getString("attachment_ofileName"));
				lecture.setAttachmentRfileName(rset.getString("attachment_rfilename"));
				lecture.setLectureContent(rset.getString("lecture_content"));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return lecture;
	}




	public int updateLectureContent(Connection conn, Lecture lec , int courseNo) {
		System.out.println("진입2");
		PreparedStatement pstmt = null;
		int result = 0;
		String query =  "UPDATE  LECTURE SET LECTURE_ORIGINAL_FILENAME =?, ATTACHMENT_OFILENAME = ?,  ATTACHMENT_RFILENAME = ?, LECTURE_CONTENT = ?  WHERE LECTURE_NO= ? ";
		try {
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, lec.getLectureOFileName());
					pstmt.setString(2, lec.getAttachmentOfileName());
					System.out.println(lec.getAttachmentRfileName());
					pstmt.setString(3, lec.getAttachmentRfileName());
					pstmt.setString(4, lec.getLectureContent());
					pstmt.setInt(5, lec.getLectureNo());
					result=pstmt.executeUpdate();
					System.out.println(lec.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	public int getLastedCreateLectureNo(Connection conn, int no) {
		int lectureNo=0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT LECTURE_NO "+
				"FROM LECTURE "+
				"WHERE SECTION_NO=? AND ROWNUM=1 "+
				"ORDER BY LECTURE_NO DESC "; 
		try {	
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				lectureNo=(rset.getInt("lecture_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return lectureNo;
	}


	public ArrayList<Lecture> getLectureByCourseName(Connection conn, String courseName) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Lecture> llist = new ArrayList<Lecture>();
		String query = "SELECT * FROM LECTURE WHERE COURSE_NAME = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, courseName);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Lecture l = new Lecture();
				l.setLectureNo(rset.getInt("lecture_no"));
				l.setSectionNo(rset.getInt("section_no"));
				l.setCourseName(rset.getString("course_name"));
				l.setSectionName(rset.getString("section_name"));
				l.setLectureName(rset.getString("lecture_name"));
				l.setLectureOFileName(rset.getString("lecture_original_filename"));
				l.setLectureRFileName(rset.getString("lecture_rename_filename"));
				l.setAttachmentOfileName(rset.getString("attachment_ofilename"));
				l.setAttachmentRfileName(rset.getString("attachment_rfilename"));
				l.setLectureContent(rset.getString("lecture_content"));
				llist.add(l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return llist;
	}
	
}

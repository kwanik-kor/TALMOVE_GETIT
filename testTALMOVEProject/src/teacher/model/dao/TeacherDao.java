package teacher.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import course.model.vo.Course;
import lecture.model.vo.Lecture;
import teacher.model.vo.Teacher;
import user.model.vo.User;

public class TeacherDao {
	
	public int TpageTeacherEnroll(Connection conn, User user) {
		return 0;}
	
	public ArrayList<Teacher> TpageInfoLoad(Connection conn, User user){
		return null;}
	
	public int TpageInfoSave(Connection conn, Teacher teacher){
		return 0;}
	public ArrayList<Lecture> TpageLectureLoad(Connection conn, Teacher teacher){
		return null;}
	public ArrayList<Teacher> TpageLectureDetailLoad(Connection conn, Teacher teacher){
		return null;}
	public ArrayList<Course> tpageLectureOpen(Connection conn, Teacher teacher, int course_no){
		return null;}
	public int TaccountmentLoad(Connection conn, Teacher teacher){
		return 0;}
	public int TaccountmentSave(Connection conn, Teacher teacher){
		return 0;}
	
	//지우
	public Teacher teacherIntroView(Connection conn, int courseNo, int teacherNo)  {
		return null;} //강사 설명 뷰

	public int tRegister(Connection conn, int userNo, String userName) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO TEACHER VALUES(SEQ_TEACHERNO.NEXTVAL, ?, ?, NULL, NULL, DEFAULT, DEFAULT, NULL)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setString(2, userName);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Teacher getTeacherInfo(Connection conn, int teacherNo) {
		Teacher teacher = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM TEACHER WHERE TEACHER_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, teacherNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				teacher = new Teacher();
				teacher.setTeacherNo(teacherNo);
				teacher.setUserNo(rset.getInt("user_no"));
				teacher.setTeacherName(rset.getString("teacher_name"));
				teacher.setTeacherCareer(rset.getString("teacher_career"));
				teacher.setTeacherIntro(rset.getString("teacher_intro"));
				teacher.setTeacherOimageName(rset.getString("teacher_oimage_name"));
				teacher.setTeacherRimageName(rset.getString("teacher_rimage_name"));
				teacher.setTeacherAccountnumber(rset.getInt("teacher_account_number"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return teacher;
	}

	public int upTeacherInfo(Connection conn, Teacher loginTeacher) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE TEACHER SET TEACHER_NAME = ?, TEACHER_CAREER = ?, TEACHER_INTRO = ?, TEACHER_OIMAGE_NAME = ?, TEACHER_RIMAGE_NAME = ? WHERE TEACHER_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginTeacher.getTeacherName());
			pstmt.setString(2, loginTeacher.getTeacherCareer());
			pstmt.setString(3, loginTeacher.getTeacherIntro());
			pstmt.setString(4, loginTeacher.getTeacherOimageName());
			pstmt.setString(5, loginTeacher.getTeacherRimageName());
			pstmt.setInt(6, loginTeacher.getTeacherNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


}

package teacher.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import course.model.vo.Course;
import lecture.model.vo.Lecture;
import teacher.model.vo.Teacher;
import user.model.vo.User;
import static common.JDBCTemplate.*;

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


}

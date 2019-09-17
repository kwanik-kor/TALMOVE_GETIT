package teacher.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import course.model.vo.Course;
import lecture.model.vo.Lecture;
import teacher.model.dao.TeacherDao;
import teacher.model.vo.Teacher;
import user.model.vo.User;

import static common.JDBCTemplate.*;

public class TeacherService {
	public TeacherDao tDao = new TeacherDao();
	
	//건우
	public int TpageTeacherEnroll(User user) {
		return 0;}

	public ArrayList<Teacher> TpageInfoLoad(User user){
		return null;}
	public int TpageInfoSave(Teacher teacher){
		return 0;}
	public ArrayList<Lecture> TpageLectureLoad(Teacher teacher){
		return null;}
	public ArrayList<Teacher> TpageLectureDetailLoad(Teacher teacher){
		return null;}
	public ArrayList<Course> tpageLectureOpen(Teacher teacher, int course_no){
		return null;}
	
	
	
	public int TaccountmentLoad(Teacher teacher){
		return 0;}
	public int TaccountmentSave(Teacher teacher){
		return 0;}

	
	//지우
	public Teacher teacherIntroView( int courseNo, int teacherNo)  {
		return null;} //강사 설명 뷰

	public int tRegister(int userNo, String userName) {
		Connection conn = getConnection();
		int result = tDao.tRegister(conn, userNo, userName);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	
}

package teacher.model.dao;

import java.sql.Connection;
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


}

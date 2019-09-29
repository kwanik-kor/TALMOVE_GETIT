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
	
}

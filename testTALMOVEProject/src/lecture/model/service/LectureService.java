package lecture.model.service;

import java.util.ArrayList;

import lecture.model.dao.LectureDao;
import lecture.model.vo.Lecture;



public class LectureService {
	LectureDao ldao = new LectureDao();
	
//학열 	
	
	public Lecture selectOne(int lectureNo){
		return null;}//해당강의불러오기(강의상세
	
	
	public ArrayList<Lecture> selectLecture(int lectureNo){
		return null;} //강의목록불러오기
	//건우 렉쳐 이름만 불러오기
	public ArrayList<Lecture> lectureNameLoad(int sectionNo) {
		Connection conn = getConnection();
		ArrayList<Lecture> list = ldao.LectureNameLoad(conn,sectionNo);
		close(conn);
		return list;
	}

	//건우 렉쳐생성
	public int createNewClass(int va) {
		Connection conn = getConnection();
		int result = ldao.createNewClass(conn,va);
		close(conn);
		return result;
	}
}

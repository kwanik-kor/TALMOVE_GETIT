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
	
}

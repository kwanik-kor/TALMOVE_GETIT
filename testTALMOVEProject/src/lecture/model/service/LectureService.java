package lecture.model.service;
import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
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

	public void lectureDelete(int lectureNo) {
		Connection conn = getConnection();
		int result = ldao.lectureDelete(conn,lectureNo);
		if(result>0) {
			commit(conn);
			System.out.println(lectureNo+" 렉쳐 삭제 완료");
		}else {
			System.out.println("삭제실패");
			rollback(conn);
		}close(conn);
		
	}

	//건우 렉쳐생성
	public int lectureCreate(int no, String name) {
		Connection conn = getConnection();
		int lectureNo=0;
		int result = ldao.lectureCreate(conn,no,name);
		if(result>0) {
			commit(conn);
			System.out.println( "렉쳐 생성 완료");
			lectureNo=ldao.getLastedCreateLectureNo(conn, no);
		}else {
			System.out.println("생성실패");
			rollback(conn);
		}close(conn);
		
		return lectureNo;
	}


	public int lectureRename(int no, String name) {
		Connection conn = getConnection();
		int result = ldao.lectureRename(conn,no,name);
		if(result>0) {
			commit(conn);
			System.out.println(no+" 섹션 이름변경 완료");
		}else {
			System.out.println("이름변경실패");
			rollback(conn);
		}close(conn);
		return result;
	}

	public Lecture getLectureByAjax(int no) {
		Connection conn = getConnection();
		Lecture lecture = ldao.getLectureByAjax(conn,no);
		return lecture;
	}


	public void updateLectureContent(Lecture lecture , int courseNo) {
		System.out.println("진입");
		Connection conn = getConnection();
		int result = ldao.updateLectureContent(conn,lecture, courseNo);
		if(result > 0) {
			commit(conn);
			System.out.println("성공");}
		else {
			rollback(conn);
			System.out.println("실패");
		}close(conn);
	}
}

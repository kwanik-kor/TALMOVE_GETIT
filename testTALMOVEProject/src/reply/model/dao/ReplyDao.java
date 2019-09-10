package reply.model.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import lecture.model.vo.Lecture;
import reply.model.vo.Reply;

public class ReplyDao {
	
	//덧글 불러오기
	public ArrayList<Reply> selectReplys(Connection conn, int lectureNo, int currentpage){
		return null;}

	//덧글 입력
	public HashMap<String, Object> insertReply(Connection conn, int userNo, String ReplyContent, int lectureNo){
		return null;}

	//덧글 수정
	public int updateReply(Connection conn, Lecture reply){
		return 0;}


	//덧글 삭제
	public int deleteReply(Connection conn, int replyNo){
		return replyNo;}


}

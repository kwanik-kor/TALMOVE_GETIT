package reply.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import lecture.model.vo.Lecture;
import reply.model.vo.Reply;

public class ReplyService {
	
	
	//덧글 불러오기
	public ArrayList<Reply> selectReplys(int lectureNo, int currentpage){
		return null;}

	//덧글 입력
	public HashMap<String, Object> insertReply(int userNo, String ReplyContent, int lectureNo){
		return null;}

	//덧글 수정
	public int updateReply(Lecture reply){
		return 0;}


	//덧글 삭제
	public int deleteReply(int replyNo){
		return replyNo;}


}

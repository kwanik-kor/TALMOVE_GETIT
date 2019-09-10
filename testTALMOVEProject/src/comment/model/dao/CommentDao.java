package comment.model.dao;

import java.sql.Connection;
import java.util.HashMap;

import lecture.model.vo.Lecture;

public class CommentDao {

	
	public HashMap<String, Object> insertComment(Connection conn, int userNo, String commentContent, int lectureNo){
		return null;}
	
	public int updateComment(Connection conn, Lecture comment) {
		return 0;}
	
	public int deleteComment(Connection conn, int commentNo){
		return commentNo;}
}

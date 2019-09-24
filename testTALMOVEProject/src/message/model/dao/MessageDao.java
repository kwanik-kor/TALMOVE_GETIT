package message.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import message.model.vo.Message;

public class MessageDao {
	public MessageDao() {}
	
	//전체메시지목록용
	public ArrayList<Message> selectList(Connection conn) {
		ArrayList<Message> list = new ArrayList<Message>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from message";
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Message message = new Message();
				
				message.setMsgNum(rset.getInt("MESSAGE_NO"));	
				message.setUserNum(rset.getInt("USER_NO"));	
				message.setMsgSender(rset.getString("SENDER"));				
				message.setMsgRecipient(rset.getString("RECIPIENT"));

				message.setMsgContent(rset.getString("MESSAGE_CONTENT"));
				message.setMsgDate(rset.getDate("MESSAGE_TIME"));
				message.setMsgReadCount(rset.getInt("MESSAGE_READCOUNTER"));
				
				list.add(message);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
	
	//전체메시지목록용2
	public int getListCount(){
		return 0;}
	
	//최근 메시지1개 출력용
	public ArrayList<Message> selectTop1(Connection conn){
		return null;}
	
	//새메세지 보내기 처리용
	public int sendMessage(Connection conn, Message msg){
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO MESSAGE VALUES ("
				+ "SEQ_MESSAGENO.NEXTVAL, "
				+ "?, ?, ?, ?, DEFAULT, DEFAULT)";
		
/*		
		MESSAGE_NO
		USER_NO
		SENDER
		RECIPIENT
		MESSAGE_CONTENT
		MESSAGE_TIME
		MESSAGE_READCOUNTER*/
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, msg.getUserNum());
			pstmt.setString(2, msg.getMsgSender());
			pstmt.setString(3, msg.getMsgRecipient());
			pstmt.setString(4, msg.getMsgContent());
	
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	
	}
	
	//새메시지 이메일목록 조회용
	public ArrayList<Message> selectSearchEmail(Connection conn, String uemail){
		
		ArrayList<Message> list = new ArrayList<Message>();
		/*Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from message where RECIPIENT =  ";
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			pstmt.setString(1, uemail);
		
			while(rset.next()) {
				Message message = new Message();
				
				message.setMsgNum(rset.getInt("MESSAGE_NO"));	
				message.setUserNum(rset.getInt("USER_NO"));	
				message.setMsgSender(rset.getString("SENDER"));				
				message.setMsgRecipient(rset.getString("RECIPIENT"));

				message.setMsgContent(rset.getString("MESSAGE_CONTENT"));
				message.setMsgDate(rset.getDate("MESSAGE_TIME"));
				message.setMsgReadCount(rset.getInt("MESSAGE_READCOUNTER"));
				
				list.add(message);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		*/
		return list;
	}
	
	//상세보기시 조회수 1증가 처리용
	public int addReadCount(Connection conn, int msgNum){
		return msgNum;}
	
	//1:1 개인메시지 상세조회용
	public Message selectOneEmailMessage(Connection conn, int msgNum){
		return null;}


	
	
	
}

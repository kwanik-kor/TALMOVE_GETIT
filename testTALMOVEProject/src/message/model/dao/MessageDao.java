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
	public ArrayList<Message> selectList(Connection conn, String uemail) {
		ArrayList<Message> list = new ArrayList<Message>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*String query = "select * from message where RECIPIENT = ?";*/
		String query = "select * from MESSAGE where(SENDER, MESSAGE_TIME) in (select SENDER, max (MESSAGE_TIME) from (select * from message where RECIPIENT = ?) group by SENDER) order by MESSAGE_TIME desc";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uemail);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Message message = new Message();
				
				message.setMsgNum(rset.getInt("MESSAGE_NO"));	
				message.setUserNum(rset.getInt("USER_NO"));	
				message.setMsgSender(rset.getString("SENDER"));				
				message.setMsgRecipient(rset.getString("RECIPIENT"));

				message.setMsgContent(rset.getString("MESSAGE_CONTENT"));
				message.setMsgDate(rset.getDate("MESSAGE_TIME"));
				message.setMsgReadCount(rset.getInt("MESSAGE_READCOUNTER"));
				message.setMsgstar(rset.getInt("MESSAGE_STAR"));
				
				list.add(message);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public ArrayList<Message> selectImpList(Connection conn, String uemail) {
		ArrayList<Message> list = new ArrayList<Message>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*String query = "select * from message where RECIPIENT = ?";*/
		String query = "select * from MESSAGE where((SENDER, MESSAGE_TIME) in (select SENDER, max (MESSAGE_TIME) from (select * from message where RECIPIENT = ?) group by SENDER)) and MESSAGE_STAR = 1 order by MESSAGE_TIME desc";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uemail);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Message message = new Message();
				
				message.setMsgNum(rset.getInt("MESSAGE_NO"));	
				message.setUserNum(rset.getInt("USER_NO"));	
				message.setMsgSender(rset.getString("SENDER"));				
				message.setMsgRecipient(rset.getString("RECIPIENT"));

				message.setMsgContent(rset.getString("MESSAGE_CONTENT"));
				message.setMsgDate(rset.getDate("MESSAGE_TIME"));
				message.setMsgReadCount(rset.getInt("MESSAGE_READCOUNTER"));
				message.setMsgstar(rset.getInt("MESSAGE_STAR"));
				
				list.add(message);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


	
	//최근 메시지1개 출력용
	public ArrayList<Message> selectTop1(Connection conn){
		return null;}
	
	//새메세지 보내기 처리용
	public int sendMessage(Connection conn, Message msg){
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "INSERT INTO MESSAGE VALUES ("
				+ "SEQ_MESSAGENO.NEXTVAL, "
				+ "?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT)";
		
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

	public int starCheck(Connection conn, int msgno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "select MESSAGE_STAR FROM MESSAGE WHERE MESSAGE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, msgno);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
/*		System.out.println("checkDao");*/
		return result;
		
	}

	public int starUpdate(Connection conn, int msgno, int starflag) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE MESSAGE SET MESSAGE_STAR = ? WHERE MESSAGE_NO = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, starflag);
			pstmt.setInt(2, msgno);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			close(pstmt);
		}
	/*	System.out.println("updateDao 완료");*/
		
		return result;
		
	}

	public int starDelete(Connection conn, int msgno) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "UPDATE MESSAGE SET MESSAGE_STAR = MESSAGE_STAR - 1 WHERE MESSAGE_NO = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, msgno);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
/*		System.out.println("DeleteDao 완료");*/
		
		return result;
	}

	public int starCount(Connection conn, int msgno) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT MESSAGE_STAR FROM MESSAGE WHERE MESSAGE_NO = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, msgno);
			rset = pstmt.executeQuery();
		/*	Message message = new Message();
			*/

			while(rset.next()) {
				result = rset.getInt("MESSAGE_STAR");
			}
			
/*			result = rset.getInt("MESSAGE_STAR");*/
		
			/*result = pstmt.executeUpdate();*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
/*		System.out.println("CountDao 완료" + result);*/
		
		return result;
		
		
	}


	
	
	
}

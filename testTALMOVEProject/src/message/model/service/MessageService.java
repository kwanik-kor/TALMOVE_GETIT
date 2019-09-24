package message.model.service;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import message.model.dao.MessageDao;
import message.model.vo.Message;

public class MessageService {
	
	private MessageDao mdao = new MessageDao();
	
	public MessageService() {}
	
	
	//전체메시지목록용

public ArrayList<Message> selectList(/*int currentPage, int limit*/) {
	Connection conn = getConnection();
	ArrayList<Message> list = mdao.selectList(conn);
	close(conn);
	return list;
}


	//전체메시지목록용2
public int getListCount(){
	return 0;}
	//최근 메시지1개 출력용
public ArrayList<Message> selectTop1(){
	return null;}
	//새메세지 보내기 처리용
public int sendMessage(Message msg){
	Connection conn = getConnection();
	int result = mdao.sendMessage(conn, msg);
	if(result > 0)
		commit(conn);
	else
		rollback(conn);
	close(conn);
	return result;
}


//새메시지 이메일목록 조회용
public ArrayList<Message> selectSearchEmail(String uemail) {
	Connection conn = getConnection();
	ArrayList<Message> list = mdao.selectSearchEmail(conn, uemail);
	close(conn);
	return list;
}


	//상세보기시 조회수 1증가 처리용
public int addReadCount(int msgNum){
	return msgNum;}
	//1:1 개인메시지 상세조회용
public	Message selectOneEmailMessage(Connection conn, int msgNum){
	return null;}








	
	
}

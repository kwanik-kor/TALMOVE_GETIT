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

public ArrayList<Message> selectList(String uemail/*int currentPage, int limit*/) {
	Connection conn = getConnection();
	ArrayList<Message> list = mdao.selectList(conn, uemail);
	if(list.size() > 0)
		commit(conn);
	else
		rollback(conn);
	close(conn);
	return list;
}


public ArrayList<Message> selectImpList(String uemail) {
	Connection conn = getConnection();
	ArrayList<Message> list = mdao.selectImpList(conn, uemail);
	if(list.size() > 0)
		commit(conn);
	else
		rollback(conn);
	close(conn);
	return list;
}




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
	if(list.size() > 0)
		commit(conn);
	else
		rollback(conn);
	close(conn);
	return list;
}


	//상세보기시 조회수 1증가 처리용
public int addReadCount(int msgNum){
	return msgNum;}


//개인메시지 조회용
public ArrayList<Message> msgone(String sendere, String recipe) {
	Connection conn = getConnection();
	ArrayList<Message> list = mdao.msgone(conn, sendere, recipe);
	if(list.size() > 0)
		commit(conn);
	else
		rollback(conn);
	close(conn);
	return list;
}




// 중요메시지 표시용
public int starUpdate(int msgno, int starflag) {
	Connection conn = getConnection();
	int result = mdao.starUpdate(conn, msgno, starflag); //중요표시 ox 여부

	if(result >0 ) {
		commit(conn);
	} else {
		rollback(conn);
	}
	close(conn);
	return result;
	
}


public int checkMsg(int msgno) {
	Connection conn = getConnection();
	int importantFlag = mdao.starCheck(conn, msgno); //중요표시 ox 여부

	close(conn);
	return importantFlag;
	
}







	
	
}

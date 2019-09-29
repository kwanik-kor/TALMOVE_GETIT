package message.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import message.model.vo.Message;

public class MessageDao {
	public MessageDao() {}
	
	//전체메시지목록용
	public ArrayList<Message> selectList(Connection conn, int currentPage, int limit){
		return null;}
	
	//전체메시지목록용2
	public int getListCount(){
		return 0;}
	
	//최근 메시지1개 출력용
	public ArrayList<Message> selectTop1(Connection conn){
		return null;}
	
	//새메세지 보내기 처리용
	public int sendMessage(Connection conn, Message msg){
		return 0;}
	
	//새메시지 이메일목록 조회용
	public ArrayList<Message> selectSearchEmail(Connection conn, int userNum){
		return null;}
	
	//상세보기시 조회수 1증가 처리용
	public int addReadCount(Connection conn, int msgNum){
		return msgNum;}
	
	//1:1 개인메시지 상세조회용
	public Message selectOneEmailMessage(Connection conn, int msgNum){
		return null;}
	
	
}

package message.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Message implements Serializable{
	private static final long serialVersionUID = 1500L;

	private int msgNum; //메시지번호
	private int userNum; //유저번호
	private String msgSender; //보낸유저이메일
	private String msgRecipient; //받는유저이메일
	
	private String msgContent; //메시지내용
public String getMsgContent() {
		return msgContent;
	}


	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}


/*	private String msgContentS; //보낸메시지내용
	private String msgContentR; //받은메시지내용
*/	private int msgReadCount; //조회수
	private Date msgDate; //메시지날짜	
	
	 
	public Message() {}


	public Message(int msgNum, int userNum, String msgSender, String msgRecipient, String msgContent,  /*String msgContentS,
			String msgContentR, */int msgReadCount, Date msgDate) {
		super();
		this.msgNum = msgNum;
		this.userNum = userNum;
		this.msgSender = msgSender;
		this.msgRecipient = msgRecipient;
/*		this.msgContentS = msgContentS;
		this.msgContentR = msgContentR;*/
		this.msgReadCount = msgReadCount;
		this.msgDate = msgDate;
	}


	public int getMsgNum() {
		return msgNum;
	}


	public int getUserNum() {
		return userNum;
	}


	public String getMsgSender() {
		return msgSender;
	}


	public String getMsgRecipient() {
		return msgRecipient;
	}

/*
	public String getMsgContentS() {
		return msgContentS;
	}


	public String getMsgContentR() {
		return msgContentR;
	}

*/
	public int getMsgReadCount() {
		return msgReadCount;
	}


	public Date getMsgDate() {
		return msgDate;
	}


	public void setMsgNum(int msgNum) {
		this.msgNum = msgNum;
	}


	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}


	public void setMsgSender(String msgSender) {
		this.msgSender = msgSender;
	}


	public void setMsgRecipient(String msgRecipient) {
		this.msgRecipient = msgRecipient;
	}

/*
	public void setMsgContentS(String msgContentS) {
		this.msgContentS = msgContentS;
	}


	public void setMsgContentR(String msgContentR) {
		this.msgContentR = msgContentR;
	}*/


	public void setMsgReadCount(int msgReadCount) {
		this.msgReadCount = msgReadCount;
	}


	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}


	@Override
	public String toString() {
		return "Message [msgNum=" + msgNum + ", userNum=" + userNum + ", msgSender=" + msgSender + ", msgRecipient="
				+ msgRecipient + ", msgContent=" + msgContent +
				/* ", msgContentS=" + msgContentS + ", msgContentR=" + msgContentR +*/ ", msgReadCount="
				+ msgReadCount + ", msgDate=" + msgDate + "]";
	}

	
}

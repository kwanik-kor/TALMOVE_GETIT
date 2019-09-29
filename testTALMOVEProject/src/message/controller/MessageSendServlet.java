package message.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.model.service.MessageService;
import message.model.vo.Message;

/**
 * Servlet implementation class MessageSendServlet
 */
@WebServlet("/msgsend")
public class MessageSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	<!--  보낸유저번호 송신자 수신자 메시지내용 -->*/
		request.setCharacterEncoding("utf-8");
		Message msg = new Message();
		
		msg.setUserNum(Integer.parseInt(request.getParameter("senderNo")));
		msg.setMsgSender(request.getParameter("sendermail"));
		msg.setMsgRecipient(request.getParameter("recipientmail"));
		msg.setMsgContent(request.getParameter("msgcontent"));
		
		MessageService msgservice = new MessageService();
		int result = msgservice.sendMessage(msg);
		response.setContentType("text/html;charset=utf-8");
		if(result > 0) {
			response.sendRedirect("/testt/msglist");  /*메시지목록으로 고치기*/
		} else {
	  
	
			RequestDispatcher view = request.getRequestDispatcher("MessageNewSendView.jsp");
			request.setAttribute("message", msg);
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

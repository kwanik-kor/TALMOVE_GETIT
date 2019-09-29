package message.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.model.service.MessageService;
import message.model.vo.Message;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/msg")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		System.out.println("jsp>servlet");
		String sendere = request.getParameter("sendere");
		String recipe = request.getParameter("recipe");
		String mdate = request.getParameter("mdate");
		
		ArrayList<Message> msgone = new MessageService().msgone(sendere, recipe);
		
		RequestDispatcher view = null;
		
		if(msgone.size() > 0) {
			view = request.getRequestDispatcher("views/mypage/MessageTextView.jsp");
			request.setAttribute("list", msgone);
			request.setAttribute("other", sendere);
			request.setAttribute("mdate", mdate);
			view.forward(request, response);
			System.out.println("dao>servlet");
		
		} else {
			view = request.getRequestDispatcher("views/mypage/MessageTextView.jsp");
			request.setAttribute("list", msgone);
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

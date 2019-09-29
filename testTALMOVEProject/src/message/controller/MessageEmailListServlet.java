package message.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class MessageEmailListServle
 */
@WebServlet("/msgelist")
public class MessageEmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageEmailListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = request.getParameter("uemail");
		
		ArrayList<Message> msgelist = 
				new MessageService().selectSearchEmail(uemail);
		
		RequestDispatcher view = null;
		//응답할 페이지로 전달할 값에 한글이 있다면
		response.setContentType("text/html; charset=utf-8");
		if(msgelist.size() > 0) {
			view = request.getRequestDispatcher("views/mypage/MessageListView.jsp");
			request.setAttribute("list", msgelist);
			view.forward(request, response);
		}else {	         
        PrintWriter out= response.getWriter();
			view = request.getRequestDispatcher("views/mypage/MessageListView.jsp");
	      /*   out.println("<script>");
	         out.println("alert('다시 시도해주세요.')");

	         out.println();
	         out.println("</script>");*/
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

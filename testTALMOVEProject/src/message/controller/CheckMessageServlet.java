package message.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import message.model.service.MessageService;

/**
 * Servlet implementation class CheckMessageServlet
 */
@WebServlet("/chmsg")
public class CheckMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int msgno = Integer.parseInt(request.getParameter("msgno"));
			int starflag = Integer.parseInt(request.getParameter("starflag"));
			System.out.println("js에서 servlet옴" + msgno + starflag);
			MessageService mservice = new MessageService();
			
			int result = mservice.starUpdate(msgno, starflag);
			PrintWriter out = response.getWriter();

			
			if( result > 0) {
				
				System.out.println("dao에서 서블릿까지옴");
				out.append("1");
				
			} else {
				System.out.println("service에서 서블릿 전송 실패");
	
				out.append("0");
				
			}
			out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

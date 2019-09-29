package user.controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import user.model.service.UserService;
import util.SHA256;

/**
 * Servlet implementation class UserDelServlet
 */
@WebServlet("/udelete.ed")
public class UserDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*	System.out.println("del");*/
		String uemail = SHA256.getSHA256(request.getParameter("uemail"));
	/*	System.out.println("del : " + uemail);*/
		int result = new UserService().deleteUser(uemail);
		
		if(result > 0) {
		/*	response.sendRedirect("/testt/logout");
*/	
					response.sendRedirect("/testt/logout");
			 // 성공시
		}else {
			
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

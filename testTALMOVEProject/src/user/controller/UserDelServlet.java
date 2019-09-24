package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		
		String uemail = SHA256.getSHA256(request.getParameter("uemail"));
		System.out.println("mdel : " + uemail);
		int result = new UserService().deleteUser(uemail);
		PrintWriter out = response.getWriter();
		if(result > 0) {
		/*	response.sendRedirect("/testt/logout");
*/
			out.append("1"); // 성공시
		}else {
			out.append("0");
		}
		out.flush();
		
		out.close();
/*		// 회원 탈퇴 처리용 컨트롤러
		String uemail = request.getParameter("usmail");
		// System.out.println("mdel : " + userId);

		int result = new UserService().deleteUser(uemail);

		if (result > 0) {
			response.sendRedirect("/testt/logout");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/member/memberError.jsp");
			request.setAttribute("message", "회원 탈퇴 실패하셨습니다.");
			view.forward(request, response);
		}*/
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

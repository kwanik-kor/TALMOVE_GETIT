package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import util.SHA256;

/**
 * Servlet implementation class UserImgUpServlet
 */
@WebServlet("/useriup.ed")
public class UserImgUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserImgUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = SHA256.getSHA256(request.getParameter("uemail"));
		v upimg = SHA256.getSHA256(request.getParameter("upwd"));
		int result = new UserService().setNewPwd(uemail, upwd);
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.append("1"); //비밀번호 업데이트 성공시
		}else {
			out.append("0");
		}
		out.flush();
		out.close();	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

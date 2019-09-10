package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.service.UserService;
import user.model.vo.User;
import util.SHA256;

@WebServlet("/login.ed")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService uservice = new UserService();
		String uemail = request.getParameter("uemail");
		String upwd = request.getParameter("upwd");
		
		User loginUser = uservice.loginCheck(uemail, SHA256.getSHA256(upwd));
		HttpSession session = request.getSession();
		if(loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			response.sendRedirect("index.jsp");
		}else {
			session.setAttribute("message", "인증받지 않은 회원입니다.");
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

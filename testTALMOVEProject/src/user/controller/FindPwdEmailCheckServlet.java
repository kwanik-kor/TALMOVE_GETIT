package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import user.model.vo.User;

@WebServlet("/newpwd")
public class FindPwdEmailCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindPwdEmailCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService uservice = new UserService();
		String uemail = request.getParameter("code");
		User user = uservice.getUserOneByMail(uemail);
		if(user != null && uemail.equals(user.getUserEmailHash())) {
			RequestDispatcher view = request.getRequestDispatcher("views/findpwd/newpwd.jsp");
			request.setAttribute("uemail", uemail);
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

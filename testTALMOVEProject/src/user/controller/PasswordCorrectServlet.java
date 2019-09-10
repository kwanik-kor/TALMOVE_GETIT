package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import user.model.vo.User;
import util.SHA256;

@WebServlet("/pwd.do")
public class PasswordCorrectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PasswordCorrectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String upwd = SHA256.getSHA256(request.getParameter("upwd"));
		String uemail = request.getParameter("uemail");
		User user = new UserService().checkPwdSame(upwd, uemail);
		PrintWriter out = response.getWriter();
		if(user != null) {
			out.append("0");
		}else {
			out.append("1");
		}
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

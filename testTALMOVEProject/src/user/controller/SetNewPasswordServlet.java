package user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import util.SHA256;

@WebServlet("/setpwd.ed")
public class SetNewPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetNewPasswordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = request.getParameter("uemail");
		String upwd = SHA256.getSHA256(request.getParameter("upwd"));
		int result = new UserService().setNewPwd(uemail, upwd);
		if(result > 0) {
			response.sendRedirect("views/findpwd/complete.jsp");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			request.setAttribute("message", "비밀번호 변경에 실패하였습니다.");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

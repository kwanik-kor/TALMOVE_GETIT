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

@WebServlet("/pwdnew.ed")
public class SetNewPasswordServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetNewPasswordServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = SHA256.getSHA256(request.getParameter("uemail"));
		String upwd = SHA256.getSHA256(request.getParameter("upwd"));
		int result = new UserService().setNewPwd(uemail, upwd);
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.append("1"); //비밀번호 업데이트 성공시
		}else {
			out.append("0");
		}
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

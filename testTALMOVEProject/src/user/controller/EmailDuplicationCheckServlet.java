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

@WebServlet("/eduple.do")
public class EmailDuplicationCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmailDuplicationCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = SHA256.getSHA256(request.getParameter("uemail"));
		User user = new UserService().getUserOneByMail(uemail);
		PrintWriter out = response.getWriter();
		if(user != null) { //이메일이 등록되어 있는 경우
			out.append("0");
		}else { //이메일이 등록되어 있지 않은 경우
			out.append("1");
		}
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

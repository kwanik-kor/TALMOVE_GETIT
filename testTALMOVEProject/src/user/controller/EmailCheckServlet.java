package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserService;
import user.model.vo.User;

@WebServlet("/echeck")
public class EmailCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmailCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService uservice = new UserService();
		String uemail = request.getParameter("code");
		User user = uservice.getUserOneByMail(uemail);
		
		if(user != null && uemail.equals(user.getUserEmailHash())) {
			int result = uservice.setEmailChecked(uemail);
			if(result > 0 ) {
				response.sendRedirect("emailCheckAction.jsp");
			}else {// 이메일 인증 컬럼 1로 바꾸지 못했을 경우
				
			}
		}// 같은 이메일 해시값이 없을 경우
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

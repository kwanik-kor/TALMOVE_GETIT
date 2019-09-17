package teacher.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teacher.model.service.TeacherService;
import user.model.service.UserService;
import user.model.vo.User;

@WebServlet("/tregi")
public class TeacherRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TeacherRegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loginUser = (User)session.getAttribute("loginUser");
		UserService uservice = new UserService();
		int result1 = new TeacherService().tRegister(loginUser.getUserNo(), loginUser.getUserName());
		if(result1 > 0) {
			int result2 = new UserService().tnumUpdate(loginUser.getUserNo());
			if(result2 > 0) {
				session.removeAttribute("loginUser");
				session.setAttribute("loginUser", uservice.loginCheck(loginUser.getUserEmail(), loginUser.getUserPwd()));
				response.sendRedirect("views/teacherPage/teacherPageDetail.jsp");
			}else {
				RequestDispatcher view = request.getRequestDispatcher("index.jsp");
				request.setAttribute("message", "강사 번호 등록에 실패하였습니다.");
				view.forward(request, response);
			}
		}else {
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			request.setAttribute("message", "강사 등록에 실패하였습니다.");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

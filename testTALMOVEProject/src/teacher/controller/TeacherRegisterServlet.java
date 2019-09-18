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
import teacher.model.vo.Teacher;
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
		int userNo = loginUser.getUserNo();
		String userName = loginUser.getUserName();
		String userEmail = loginUser.getUserEmail();
		String userPwd = loginUser.getUserPwd();
		UserService uservice = new UserService();
		TeacherService tservice = new TeacherService();
		
		int result1 = tservice.tRegister(userNo, userName);
		if(result1 > 0) {
			int result2 = uservice.tnumUpdate(userNo);
			if(result2 > 0) {
				User newLoginUser = uservice.loginCheck(userEmail, userPwd);
				Teacher loginTeacher = tservice.getTeacherInfo(newLoginUser.getTeacherNo());
				
				session.removeAttribute("loginUser");
				session.setAttribute("loginUser", newLoginUser);
				session.setAttribute("loginTeacher", loginTeacher);
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

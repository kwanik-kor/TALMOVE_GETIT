package course.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.model.service.CourseService;
import course.model.vo.Course;
import teacher.model.vo.Teacher;

@WebServlet("/gtcourse")
public class getTeacherCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getTeacherCoursesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher loginTeacher = (Teacher)request.getSession(false).getAttribute("loginTeacher");
		ArrayList<Course> courseList = new CourseService().getCourseListByTNo(loginTeacher.getTeacherNo());
		RequestDispatcher view = request.getRequestDispatcher("views/teacherPage/teacherManageLecture.jsp");
		request.setAttribute("courseList", courseList);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

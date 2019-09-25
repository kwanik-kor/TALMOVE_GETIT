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



@WebServlet("/mclist")
public class MyCourseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyCourseListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
        CourseService courseService = new CourseService();
        ArrayList<Course> course = courseService.myCourse(userNo);
        System.out.println("서블릿에 확인 " + course);

	

	RequestDispatcher view  = request.getRequestDispatcher("views/myCourse/myCourse.jsp");
        request.setAttribute("course", course);
        view.forward(request, response);
}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

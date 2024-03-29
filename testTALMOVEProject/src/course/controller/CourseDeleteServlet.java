package course.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.model.service.CourseService;

@WebServlet("/coursedel")
public class CourseDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CourseDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int courseNo = Integer.parseInt(request.getParameter("cno"));
		String thumbnailRfileName = request.getParameter("cothumb");
		int result = new CourseService().deleteCourse(courseNo);
		if(result > 0) {
			new File(request.getSession().getServletContext().getRealPath("/resources/course_upfiles") + "/" + thumbnailRfileName).delete();
			response.sendRedirect("/testt/gtcourse");
		}else {
			response.sendRedirect("/testt/gtcourse");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

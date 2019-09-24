package course.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.model.service.CourseService;

@WebServlet("/copen")
public class CourseOpenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CourseOpenServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int courseNo = Integer.parseInt(request.getParameter("cno"));
		int price = Integer.parseInt(request.getParameter("cprice"));
		System.out.println(courseNo + "," + price);
		int result = new CourseService().setCourseOpen(courseNo, price);
		if(result > 0) {
			response.sendRedirect("/testt/gtcourse");
		}else {
			response.sendRedirect("/testt/gtcourse");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

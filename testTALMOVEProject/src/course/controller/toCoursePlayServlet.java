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
import lecture.model.service.LectureService;
import lecture.model.vo.Lecture;
import section.model.vo.Section;

@WebServlet("/cplay.ed")
public class toCoursePlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public toCoursePlayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int courseNo = Integer.parseInt(request.getParameter("courseNo"));
		CourseService courseService = new CourseService();
		Course c = courseService.getCourse(courseNo);
		ArrayList<Section> slist = courseService.SectionList(courseNo);
		ArrayList<Lecture> llist = new LectureService().getLectureByCourseName(c.getCourseName());
		RequestDispatcher view = request.getRequestDispatcher("views/coursePlay/coursePlay.jsp");
		request.setAttribute("course", c);
		request.setAttribute("slist", slist);
		request.setAttribute("llist", llist);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

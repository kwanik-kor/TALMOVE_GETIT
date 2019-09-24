package course.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import category.model.service.CategoryService;
import category.model.vo.Category;
import course.model.service.CourseService;
import course.model.vo.Course;
import course_tag.model.service.CourseTagService;
import course_tag.model.vo.CourseTag;
import tag.model.service.TagService;
import tag.model.vo.Tag;
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
		ArrayList<Tag> tagList = new TagService().getTagListByTNo(loginTeacher.getTeacherNo());
		ArrayList<CourseTag> ctList = new CourseTagService().getCourseTagList(loginTeacher.getTeacherNo());
		ArrayList<Category> caList = new CategoryService().getAllCategoryList();
		
		RequestDispatcher view = request.getRequestDispatcher("views/teacherPage/teacherManageLecture.jsp");
		request.setAttribute("courseList", courseList);
		request.setAttribute("tagList", tagList);
		request.setAttribute("ctList", ctList);
		view.forward(request, response);
		
		for(Course c : courseList) {
			int upper = 0;
			for(Category ca : caList) {
				if(c.getCategoryNo() == ca.getCategoryNo()) {
					System.out.println(c.getCourseName() + ": " + ca.getCategoryName());
					upper = ca.getCategoryUpper();
				}
			}
			for(Category ca : caList) {
				if(upper == ca.getCategoryNo()) {
					System.out.println(ca.getCategoryName());
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

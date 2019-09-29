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
import section.model.vo.Section;
import teacher.model.service.TeacherService;
import teacher.model.vo.Teacher;

/**
 * Servlet implementation class PageLoadServlet
 */
@WebServlet("/editPageLoad")
public class PageLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("페이지로드 서블릿진입");
		Course course = new Course();
		Teacher teacher = new Teacher();
		int courseNumber =0;
		System.out.println("1번 "+(request.getParameter("courseNo")));
		System.out.println("2번 "+request.getAttribute("courseNo"));
		if(request.getParameter("courseNo")!=null) {
			courseNumber= Integer.parseInt(request.getParameter("courseNo"));
		}else {
			courseNumber= (Integer)request.getAttribute("courseNo");
		}			
		System.out.println("코스넘버 : "+ courseNumber);

		//코스번호로 선생님이름, 코스객체
		CourseService cservice = new CourseService();
		course = cservice.getCourse(courseNumber);
		TeacherService tservice = new TeacherService();
		teacher=  tservice.getTeacherInfo(course.getTeacherNo());
		System.out.println(teacher.getTeacherName());
		//정보를가진 섹션객체, 섹션리스트
		ArrayList<Section> sectionList = cservice.SectionList(courseNumber);
		RequestDispatcher view = null;

		//넘기자
		if(teacher.getTeacherName()!=null) {
			view = request.getRequestDispatcher("views/teacherPage/editLecture.jsp");
			request.setAttribute("sectionList", sectionList);
			request.setAttribute("teacherName", teacher.getTeacherName() );
			request.setAttribute("courseName", course.getCourseName());
			request.setAttribute("courseDescription", course.getDescription());
			request.setAttribute("courseNumber", courseNumber);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/common/Error.jsp");
			request.setAttribute("message", "에러ㅏ에러!");
			view.forward(request, response );
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

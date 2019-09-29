package category.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import category.model.service.CategoryService;
import course.model.vo.Course;
import lecture.model.vo.Lecture;
import review.model.vo.Review;
import section.model.vo.Section;
import teacher.model.vo.Teacher;

/**
 * Servlet implementation class CourseDetailView
 */
@WebServlet("/coursedetail")
public class CourseDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int courseNo = Integer.parseInt(request.getParameter("courseNo"));
	
		
		CategoryService cservice = new CategoryService();
		
		//강좌정보 불러오기
		ArrayList<Course> list = cservice.courseDetailView(courseNo);
		
		//수강생 인원 
		int studentCount = cservice.studentCount(courseNo);
		
		//리뷰 인원
		int reviewCount = cservice.reviewCount(courseNo);
		
		//리뷰 평점
		double reviewPoint = cservice.reviewPoint(courseNo);
		
		//동영상 갯수
		int videoCount = cservice.videoCount(courseNo);
		
		//자료 갯수
		int fileCount = cservice.fileCount(courseNo);
		
		//섹션 이름
		ArrayList<Section> slist = cservice.sectionView(courseNo);
		
		//강의 이름
		ArrayList<Lecture> llist = cservice.lectureView(courseNo);
		
		//강사 정보
		ArrayList<Teacher> tlist = cservice.teachherView(courseNo);
		
		//리뷰 
		ArrayList<Review> rlist = cservice.reviewView(courseNo);
		
		RequestDispatcher view = null;
	     response.setContentType("text/html; charset=utf-8");
	     if(list.size() > 0) {
	    	 view = request.getRequestDispatcher("/views/course/courseDetail.jsp");
	    	 request.setAttribute("list", list);
	    	 request.setAttribute("studentCount", studentCount);
	    	 request.setAttribute("reviewCount", reviewCount);
	    	 request.setAttribute("reviewPoint", reviewPoint);
	    	 request.setAttribute("videoCount", videoCount);
	    	 request.setAttribute("fileCount", fileCount);
	    	 request.setAttribute("slist", slist);
	    	 request.setAttribute("llist", llist);
	    	 request.setAttribute("tlist", tlist);
	    	 request.setAttribute("rlist", rlist);
	    	 view.forward(request, response);
	     }else {
	    	 view = request.getRequestDispatcher("views/common/Error.jsp");
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

package section.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.model.service.LectureService;
import section.model.service.SectionService;

/**
 * Servlet implementation class sectionDelete
 */
@WebServlet("/sectionDelete.do")
public class SectionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SectionDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("섹션딜리트 서블렛진입");
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("sectionNo: " +no);
		SectionService sservice = new SectionService();
		sservice.lectureAllDelete(no);
		sservice.sectionDelete(no);
		System.out.println("섹션삭제 서블렛종료");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

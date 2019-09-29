package lecture.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import lecture.model.service.LectureService;
import section.model.service.SectionService;

/**
 * Servlet implementation class LectureRename
 */
@WebServlet("/lectureRename.do")
public class LectureRename extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LectureRename() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("섹션리네임 서블렛진입");
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		System.out.println("sectionNo :" +no+",rename ="+name);
		LectureService lservice = new LectureService();
		int res = lservice.lectureRename(no,name);
		JSONObject sendJson = new JSONObject();
		sendJson.put("resltNum",res);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(sendJson.toJSONString());
		out.flush();
		out.close();
		System.out.println("섹션이름변경 서블렛종료");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

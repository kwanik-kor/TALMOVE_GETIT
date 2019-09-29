package course.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import course.model.service.CourseService;
import course.model.vo.Course;

@WebServlet("/searchco.ed")
public class SearchCourseNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchCourseNameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String[] keywords = keyword.split(" ");
		ArrayList<String> clist = new CourseService().getSearchedCourseName(keywords);
		HashSet<String> distinct = new HashSet<String>(clist);
		clist = new ArrayList<String>(distinct);
		
		JSONObject sendJson = new JSONObject();
		JSONArray jarr = new JSONArray();
		for(String c : clist) {
			JSONObject jobj = new JSONObject();
			jobj.put("cname", URLEncoder.encode(c, "UTF-8"));
			jarr.add(jobj);
		}
		sendJson.put("clist", jarr);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(sendJson.toJSONString());
		out.flush();
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

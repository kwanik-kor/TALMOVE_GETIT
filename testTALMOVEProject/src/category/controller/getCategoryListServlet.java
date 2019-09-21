package category.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import category.model.service.CategoryService;
import category.model.vo.Category;

@WebServlet("/gcateli.ed")
public class getCategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getCategoryListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryName = request.getParameter("categoryName");
		ArrayList<Category> clist = new CategoryService().getCategoryList(categoryName);
		JSONObject sendJson = new JSONObject();
		JSONArray jarr = new JSONArray();
		for(Category c : clist) {
			JSONObject jobj = new JSONObject();
			jobj.put("cNo", c.getCategoryNo());
			jobj.put("cName", URLEncoder.encode(c.getCategoryName(), "UTF-8"));
			jobj.put("cUp", c.getCategoryUpper());
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

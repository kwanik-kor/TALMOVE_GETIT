package cart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import cart.model.service.CartService;
import cart.model.vo.Cart;
import user.model.vo.User;


@WebServlet("/coverlap")
public class CartOverlapCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CartOverlapCheckServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cart cart = new Cart();
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		int userNo;
		
		if(loginUser != null) {
		 userNo = loginUser.getUserNo();
		 System.out.println(userNo);
		}else {
			userNo = 0;
			System.out.println("coursecheck서블릿에서 useNo는" + userNo);
		}
		 
		 int courseNo = (Integer.parseInt(request.getParameter("courseNo")));//onCourse.getCourseNo();   //
		 System.out.println("ONCourseCheckservlet에서 온 courseNO는 " + courseNo);
		cart.setUserNo(userNo);
		cart.setCourseNo(courseNo);
		
		CartService cartService = new CartService();
		int result = cartService.cartOverlap(userNo, courseNo);
		
		if(result > 0 ) {
			
			System.out.println("CartOverlap 값 있음");
			JSONObject job = new JSONObject();
			
			job.put("cartOverlap", "장바구니중복");
			/*job.put("userNo", onCourse.getUserNo());
			job.put("courseNo", onCourse.getCourseNo());
			System.out.println(onCourse.getCourseNo());*/
			
			System.out.println("job : " + job.toJSONString());
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			//json 객체를 json 문자열로 바꾸어 내보냄
			out.print(job.toJSONString());
			out.flush();
			out.close();		
			
			
			
		}else {
			System.out.println("CourseCheck 값 없음 ");
		
			/*
			JSONObject job = new JSONObject();
			
			job.put("cartContent", "장바구니에 추가");
			job.put("userNo", onCourse.getUserNo());
			job.put("courseNo", onCourse.getCourseNo());
			System.out.println(onCourse.getCourseNo());
			
			System.out.println("job : " + job.toJSONString());
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			//json 객체를 json 문자열로 바꾸어 내보냄
			out.print(job.toJSONString());
			out.flush();
			out.close();	*/
			
			
		}
		

		
	}
		
}

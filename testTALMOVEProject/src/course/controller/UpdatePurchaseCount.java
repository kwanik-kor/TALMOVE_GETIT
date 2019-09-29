package course.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.model.service.CourseService;
import course.model.vo.Course;


@WebServlet("/uppcount")
public class UpdatePurchaseCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public UpdatePurchaseCount() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		Course course = new Course();
		
		int courseNo = (Integer.parseInt(request.getParameter("courseNo")));
		System.out.println("UpdatePurchaseCount 서블릿에서 courseNo는 " + courseNo);
		

		course.setCourseNo(courseNo);
		System.out.println("구매횟수증가 서블릿에 저장된 courseNo는 " + courseNo);

		CourseService cService = new CourseService();
		int result = cService.updatePurchaseCount(courseNo);
		
		if(result > 0) {
			//성공시
			//response.sendRedirect("views/payment/paymentFinish.jsp");
			System.out.println("증가성공");
			RequestDispatcher view = 
					request.getRequestDispatcher("/cdall?userNo=<%=loginUser.getUserNo()%>");
			
				view.forward(request, response);
	
			
		
		}else {
			//실패시
			RequestDispatcher view = 
			request.getRequestDispatcher("views/cart/cartError.jsp");
			request.setAttribute("message", "실패!");
			view.forward(request, response);
		}
	
	}		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

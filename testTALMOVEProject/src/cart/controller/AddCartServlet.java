package cart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.model.vo.Cart;



@WebServlet("/addcart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddCartServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 처리용 컨트롤러
		//1. 전송온 값에 한글이 있으면, 반드시 인코딩 처리함
		request.setCharacterEncoding("utf-8");
		
		//2. 전송온 값 꺼내서 변수 또는 객체에 저장
		//Payment payment = new Payment();
		Cart cart = new Cart();
		
		
		int userNo = (Integer.parseInt(request.getParameter("userNo")));
		int courseNo = (Integer.parseInt(request.getParameter("courseNo")));
		cart.setUserNo(userNo);
		cart.setCourseNo(courseNo);
		System.out.println("userNo는 " + userNo);
		System.out.println("courseNo는 " + courseNo);
		
		
		//3. 서비스로 객체 전달하고, 처리된 결과 받기
		//PaymentService paymentService = new PaymentService();
		OnCourseService onCourseService = new OnCourseService();
		int result = onCourseService.addOnCourse(userNo, courseNo);
		
		//4. 받은 결과에 따라 뷰 선택해서 내보내기
		if(result > 0) {
			//성공시
			//강좌 상세페이지에서 어떻게 구성하느냐에따라서 링크 다르게 작성할것 
			System.out.println("장바구니 담기 성공 ");
			//response.sendRedirect("views/payment/paymentFinish.jsp");
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

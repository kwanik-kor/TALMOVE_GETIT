package onCourse.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onCourse.model.service.OnCourseService;
import onCourse.model.vo.OnCourse;


@WebServlet("/addonc")
public class AddOncourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddOncourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 처리용 컨트롤러
				//1. 전송온 값에 한글이 있으면, 반드시 인코딩 처리함
				request.setCharacterEncoding("utf-8");
				
				//2. 전송온 값 꺼내서 변수 또는 객체에 저장
				//Payment payment = new Payment();
				OnCourse onCourse = new OnCourse();
				
				
				int userNo = (Integer.parseInt(request.getParameter("userNo")));
				int courseNo = (Integer.parseInt(request.getParameter("courseNo")));
				onCourse.setUserNo(userNo);
				onCourse.setCourseNo(courseNo);
				System.out.println("userNo는 " + userNo);
				System.out.println("courseNo는 " + courseNo);
				
				
				//3. 서비스로 객체 전달하고, 처리된 결과 받기
				//PaymentService paymentService = new PaymentService();
				OnCourseService onCourseService = new OnCourseService();
				int result = onCourseService.addOnCourse(userNo, courseNo);
				
			/*	HttpSession session = request.getSession();
				//세션 생성
				session.setAttribute("userNo", userNo);
				session.setAttribute("courseNo", courseNo);*/


				
				
				//4. 받은 결과에 따라 뷰 선택해서 내보내기
				if(result > 0) {
					//성공시
					//response.sendRedirect("views/payment/paymentFinish.jsp");
					System.out.println(" onCourse 추가성공");
					RequestDispatcher view = 
							request.getRequestDispatcher("/uppcount?courseNo=<%= courseNo %>");
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

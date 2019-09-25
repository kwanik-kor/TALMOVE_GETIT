package payment.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import payment.model.service.PaymentService;
import payment.model.vo.Payment;

/**
 * Servlet implementation class PaymentListServlet
 */
@WebServlet("/plist")
public class PaymentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PaymentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int userNo = Integer.parseInt(request.getParameter("userNo"));
	        PaymentService paymentService = new PaymentService();
	        ArrayList<Payment> payments = paymentService.getPayment(userNo);
	        System.out.println("서블릿에 확인 " + payments);

		
	
		RequestDispatcher view  = request.getRequestDispatcher("views/payment/paymentPage.jsp");
	        request.setAttribute("payments", payments);
	        view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

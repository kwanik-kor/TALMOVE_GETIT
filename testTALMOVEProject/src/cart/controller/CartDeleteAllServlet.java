package cart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.model.service.CartService;
import cart.model.vo.Cart;


@WebServlet("/cdel")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CartDeleteServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int cartNo = Integer.parseInt(request.getParameter("cartNo"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		if(new CartService().deleteCart(cartNo, userNo) > 0) {
			System.out.println("삭제완료");
			response.sendRedirect("/testt/cartl?userNo="+userNo);
		}else {
			//response.sendRedirect("views/payment/paymentFinish.jsp");
			RequestDispatcher view = request.getRequestDispatcher("views/payment/paymentFinish.jsp");
		
			view.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

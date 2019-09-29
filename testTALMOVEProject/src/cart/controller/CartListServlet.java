package cart.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cart.model.service.CartService;
import cart.model.vo.Cart;

/**
 * Servlet implementation class CartListServlet
 */
@WebServlet("/cartl")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CartListServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 int userNo = Integer.parseInt(request.getParameter("userNo"));
	        CartService cartService = new CartService();
	        ArrayList<Cart> carts = cartService.getCart(userNo);
	        System.out.println("서블릿에 확인 " + carts);

		
	
		RequestDispatcher view  = request.getRequestDispatcher("views/cart/cartPage.jsp");
	        request.setAttribute("carts", carts);
	        view.forward(request, response);

	}
	
		/*
		//int cartNo = Integer.parseInt(request.getParameter(("cartNo")));
	
		String userN =request.getParameter(("userNo"));
	if(userN == null) {
		userN = "0";
	}
		int userNo =  Integer.parseInt(userN);
		
		
		
		ArrayList<Cart> list = 
				new CartService().addCart(userNo);
		
		RequestDispatcher view = null;
		//응답할 페이지로 전달할 값에 한글이 있다면
		response.setContentType("text/html; charset=utf-8");
		if(list.size() > 0) {
			view = request.getRequestDispatcher("views/cart/cartPage.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/cart/cartError.jsp");
			request.setAttribute("message", "리스트가 0개 입니다.");
			view.forward(request, response);
		}
	}
	
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

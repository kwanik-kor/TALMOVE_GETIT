package cart.model.service;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static common.JDBCTemplate.*;
import cart.model.dao.CartDao;
import cart.model.vo.Cart;



public class CartService {
	private CartDao cdao = new CartDao();
	
	
	
	
	public int addCart(int userNo, int courseNo) {
		Connection conn = getConnection();
		int result = cdao.addCart(conn, userNo, courseNo);
		System.out.println("add cart 서비스로 넘어온 userNo" + userNo + " courseNo" + courseNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	
	
	
	public ArrayList<Cart> getCart(int userNo) {
		Connection conn = getConnection();
		 ArrayList<Cart> carts = cdao.cartList(conn, userNo);
	            System.out.println("sevrvice에 확인 " + carts.size());
	    		close(conn);
	       
	        return carts;
	    }

	

 
    //  장바구니 삭제
  
    public int deleteCart(int cartNo, int userNo) {
    	Connection conn = getConnection();
		int result = cdao.deleteCart(conn, cartNo, userNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}
   
    //결제완료시 장바구니 전체 삭제 

	public int deleteCartAll(int userNo) {
		Connection conn = getConnection();
		int result = cdao.deleteCartAll(conn, userNo);
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

     
    	


	public int cartOverlap(int userNo, int courseNo) {
		Connection conn = getConnection();
		int result = cdao.cartOverlap(conn, userNo, courseNo);
		System.out.println("cartOverlap 서비스로 넘어온 userNo" + userNo + " courseNo" + courseNo);
		close(conn);
		return result;
	}













    
    //결제페이지로 객체 전송 


}

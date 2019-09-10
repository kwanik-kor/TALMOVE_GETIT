package cart.model.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cart.model.vo.Cart;

public class CartDao {
	
	
	//지우
	//장바구니 추가
	public Cart addCart(Connection conn, int courseNo, String courseName, int price)  {
		return null;} 
	
	
	//영찬
    //장바구니 목록

    public ArrayList<Cart> listCart(Connection conn, int userId) {
        
    	return null;
    }
    //장바구니 삭제
  
    public int delete(Connection conn, int userNo, int cartNo) {
       return 0;
    }
    //장바구니 금액 합계

    public int sumMoney(Connection conn, int userId) {
        int total = 0;
    	
        return total;
        		}
    
    
    //장바구니 동일한 상품 레코드 확인
    public int countCart(Connection conn, int productId, String userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("productId", productId);
        map.put("userId", userId);
       // return sqlSession.selectOne("cart.countCart", map);
		return 0;
        
    }
    
    //결제페이지로 이동 

	

}

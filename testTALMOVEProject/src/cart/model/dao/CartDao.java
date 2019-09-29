package cart.model.dao;

import static common.JDBCTemplate.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cart.model.vo.Cart;
import onCourse.model.vo.OnCourse;


public class CartDao {
	
	public int addCart(Connection conn, int userNo, int courseNo) {
		OnCourse onCourse = new OnCourse();
		int result = 0;
		PreparedStatement pstmt = null;
		System.out.println("DAO로 넘어온 userNo" + userNo + "courseNo" + courseNo);
		System.out.println("DAO getUserNo" + onCourse.getUserNo() + "getCourseNo" + onCourse.getCourseNo());
		
		String query = "INSERT INTO CART VALUES(SEQ_CARTNO.NEXTVAL, ?, ?);";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, courseNo);
			
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		
		return result;
	}


	
	
    //장바구니추가

    public ArrayList<Cart> addCart(Connection conn, int userId) {
        
    	return null;
    }
	
	
	//장바구니 목록
	public ArrayList<Cart> cartList(Connection conn, int userNo) {
		ArrayList<Cart> carts = new ArrayList<Cart>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT B.CART_NO, B.USER_NO, T.TEACHER_NAME, C.COURSE_NO, C.COURSE_NAME, "
						+ "C.THUMBNAIL_OFILENAME, C.THUMBNAIL_RFILENAME, C.PRICE " 
						+ "FROM CART B LEFT OUTER JOIN COURSE C "  
						+	"ON (B.COURSE_NO = C.COURSE_NO) " + 
							"LEFT JOIN TEACHER T " + 
							"ON(C.TEACHER_NO = T.TEACHER_NO) " + 
							"WHERE B.USER_NO= ? ";

				try {
					pstmt = conn.prepareStatement(query);
					pstmt.setInt(1, userNo);

		
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Cart cart = new Cart();
				cart.setCartNo(rset.getInt(1));
				cart.setUserNo(rset.getInt(2));
				cart.setTeacherName(rset.getString(3));
				cart.setCourseNo(rset.getInt(4));
				cart.setCourseName(rset.getString(5));
				cart.setThumbnailOfileName(rset.getString(6));
				cart.setThumbnailRfileName(rset.getString(7));
				cart.setPrice(rset.getInt(8));
			
				carts.add(cart);
				System.out.println("dao에 대한 확인 " + carts.size());
			}
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return carts;
		
		
	}
	

    //장바구니 삭제
  
    public int deleteCart(Connection conn, int cartNo, int userNo) {
    	int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from CART "
					+ "where CART_NO = ? AND USER_NO = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cartNo);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
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

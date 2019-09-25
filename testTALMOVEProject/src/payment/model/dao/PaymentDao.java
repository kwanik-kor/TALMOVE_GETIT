package payment.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import payment.model.vo.Payment;

public class PaymentDao {

	
	public ArrayList<Payment> listPayment(Connection conn, int userNo) {
		ArrayList<Payment> payments = new ArrayList<Payment>();
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
				Payment payment = new Payment();
				
				payment.setCartNo(rset.getInt(1));
				payment.setUserNo(rset.getInt(2));
				payment.setTeacherName(rset.getString(3));
				payment.setCourseNo(rset.getInt(4));
				payment.setCourseName(rset.getString(5));
				payment.setThumbnailOfileName(rset.getString(6));
				payment.setThumbnailRfileName(rset.getString(7));
				payment.setPrice(rset.getInt(8));
			
				payments.add(payment);
				System.out.println("dao에 대한 확인 " + payments.size());
			}
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return payments;
		
		
	}
	
	
	public int addOnCourse(Connection conn, Payment payment) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO ON_COURSE values "
				+ "(?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, payment.getUserNo());
			pstmt.setInt(2, payment.getCourseNo());
			
			
			result = pstmt.executeUpdate();
			System.out.println("addOnCourse DAO 확인");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		
		return result;
	}

	
	
	
	
	
	
}

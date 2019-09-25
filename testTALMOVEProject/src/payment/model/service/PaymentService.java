package payment.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import payment.model.dao.PaymentDao;
import payment.model.vo.Payment;

import static common.JDBCTemplate.*;

public class PaymentService {
	PaymentDao pDao = new PaymentDao();

	public ArrayList<Payment> getPayment( int paymentNo) {
		Connection conn = getConnection();
		ArrayList<Payment> list = pDao.listPayment(conn, paymentNo);
		System.out.println("service에 확인 " + list.size());
		close(conn);
		
		return list;
	}
	
	
	public int addOnCourse(Payment payment) {
		Connection conn = getConnection();
		int result = pDao.addOnCourse(conn, payment);
		if(result > 0) {
			commit(conn);
			System.out.println("addOnCourse 서비스 확인");
		}
		else
			rollback(conn);
		close(conn);
		return result;
	}
	
	
}

package section.model.service;
import static common.JDBCTemplate.*;

import java.sql.Connection;

import section.model.dao.SectionDao;

public class SectionService {
	SectionDao sdao = new SectionDao();

	public void createNewSection(int no) {
		Connection conn = getConnection();
		int result = sdao.createNewSection(conn,no);
		if(result>0) {
			commit(conn);
			System.out.println( "렉쳐 생성 완료");
		}else {
			System.out.println("생성실패");
			rollback(conn);
		}close(conn);
		
		
	}
	
	public void sectionDelete(int no) {
		Connection conn = getConnection();
		int result = sdao.sectionDelete(conn,no);
		if(result>0) {
			commit(conn);
			System.out.println(no+" 섹션 삭제 완료");
		}else {
			System.out.println("삭제실패");
			rollback(conn);
		}close(conn);
		
		
	}

	public void lectureAllDelete(int no) {
		Connection conn = getConnection();
		int result = sdao.lectureAllDelete(conn,no);
		if(result>0) {
			commit(conn);
			System.out.println(no+" 섹션 삭제 완료");
		}else {
			System.out.println("삭제실패");
			rollback(conn);
		}close(conn);
		
		
	}

	public int sectionRename(int no, String name) {
		Connection conn = getConnection();
		int result = sdao.sectionRename(conn,no,name);
		if(result>0) {
			commit(conn);
			System.out.println(no+" 섹션 이름변경 완료");
		}else {
			System.out.println("이름변경실패");
			rollback(conn);
		}close(conn);
		return result;
	}
	
}

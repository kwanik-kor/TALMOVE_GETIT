package section.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SectionDao {

	public int createNewSection(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result=0;
		String query ="INSERT INTO SECTION VALUES (SEQ_SECTIONNO.NEXTVAL,?,'NEW SECTION')";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			result=pstmt.executeUpdate();
			System.out.println("try");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}

	public int sectionDelete(Connection conn, int no) {
		PreparedStatement pstmt = null;
		String query = 	"delete section	WHERE section_NO=? ";
				
		int result=0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,no);
			result=pstmt.executeUpdate();
			System.out.println("try");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}

	public int lectureAllDelete(Connection conn, int no) {
		PreparedStatement pstmt = null;
		String query = 	"delete lecture	WHERE section_NO=? ";
				
		int result=0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,no);
			result=pstmt.executeUpdate();
			System.out.println("try");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}

	public int sectionRename(Connection conn, int no, String name) {
		PreparedStatement pstmt = null;
		String query = 	"UPDATE SECTION SET SECTION_NAME = ? WHERE SECTION_NO=? ";
		int result=0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,name);
			pstmt.setInt(2,no);
			result=pstmt.executeUpdate();
			System.out.println("try");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("저장결과 : "+result);
		return result;
	}


}

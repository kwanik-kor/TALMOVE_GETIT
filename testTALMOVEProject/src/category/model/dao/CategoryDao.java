package category.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import category.model.vo.Category;
import course.model.vo.Course;

import static common.JDBCTemplate.*;

public class CategoryDao {
	public ArrayList<Course> selectSortPurchaseCounrt(Connection conn, String sortKeyword){
		return null;}  // 인기도 정렬
	
	public ArrayList<Course> selectSortGoodReview(Connection conn, String sortKeyword){
		return null;}  // 최고 평점 정렬
	
	public ArrayList<Course> selectSortRowPrice(Connection conn, String sortKeyword){
		return null;}  // 최저가 정렬
	
	public ArrayList<Course> selectSortHighPrice(Connection conn, String sortKeyword){
		return null;}  // 최고가 정렬
	
	public ArrayList<Course> categoryCourseListView(Connection conn, int categoryNo){
		return null;}  // 카테고리 별 강좌 뷰
	
	public int selectCourse(Connection conn, int courseNo){
		return courseNo;}  // 강좌 선택
	
	public int pagePassing(Connection conn, int pageNo){
		return pageNo;}  // 페이지 넘김

	public ArrayList<Course> selectList(Connection conn, int currentPage, int limit, String category) {
		ArrayList<Course> list = new ArrayList<Course>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, COURSE_NO, TEACHER_NO, CATEGORY_NO, COURSE_NAME, "
				+ "THUMBNAIL_OFILENAME, THUMBNAIL_RFILENAME, DESCRIPTION, OPEN_YN, PRICE, PURCHASE_COUNT "
				+ "from(select * from course order by course_no)) "
				+ "join category using (category_no) "
				+ "join teacher using (teacher_no) where category_name like ? and rnum >= ? and rnum <= ?";
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Course course = new Course();
				
				course.setCourseNo(rset.getInt("course_no"));
				course.setTeacherNo(rset.getInt("teacher_no"));
				course.setCategoryNo(rset.getInt("category_no"));
				course.setCourseName(rset.getString("course_name"));
				course.setThumbnailOfileName(rset.getString("thumbnail_ofilename"));
				course.setThumbnailRfileName(rset.getString("thumbnail_rfilename"));
				course.setDescription(rset.getString("description"));
				course.setOpenYN(rset.getString("open_yn"));
				course.setPrice(rset.getInt("price"));
				course.setPurchaseCount(rset.getInt("purchase_count"));
				course.setTeacherName(rset.getString("teacher_name"));
				course.setCategoryUpper(rset.getString("category_upper"));
				
				list.add(course);
			} 
		}catch(Exception e) {
				e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int getListCount(Connection conn, String category) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) "
				+ "from course "
				+ "join category using (category_no) "
				+ "where category_name like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	public ArrayList<Category> getCategoryList(Connection conn, String categoryName) {
		ArrayList<Category> clist = new ArrayList<Category>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM CATEGORY WHERE CATEGORY_UPPER = (SELECT CATEGORY_NO FROM CATEGORY WHERE CATEGORY_NAME = ?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, categoryName);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Category c = new Category();
				c.setCategoryNo(rset.getInt("category_no"));
				c.setCategoryName(rset.getString("category_name"));
				c.setCategoryUpper(rset.getInt("category_upper"));
				clist.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return clist;
	}

	public String getCategoryUpper(Connection conn, String category) {
		String categoryUpper = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT B.CATEGORY_NAME AS 상위카테고리 FROM CATEGORY A JOIN CATEGORY B ON(A.CATEGORY_UPPER = B.CATEGORY_NO) "
				+ "WHERE A.CATEGORY_NAME=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				categoryUpper = rset.getString(1);

			} 
		}catch(Exception e) {
				e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return categoryUpper;
	}
	
}

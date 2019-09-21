package category.model.dao;

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

	
	
	
}

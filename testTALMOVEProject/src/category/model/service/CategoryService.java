package category.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import category.model.dao.CategoryDao;
import course.model.vo.Course;

public class CategoryService {
	private CategoryDao cdao = new CategoryDao();
	
	public ArrayList<Course> selectSortPurchaseCounrt(String sortKeyword){
		return null;}  // 인기도 정렬
	
	public ArrayList<Course> selectSortGoodReview(String sortKeyword){
		return null;}  // 최고 평점 정렬
	
	public ArrayList<Course> selectSortRowPrice(String sortKeyword){
		return null;}  // 최저가 정렬
	
	public ArrayList<Course> selectSortHighPrice(String sortKeyword){
		return null;}  // 최고가 정렬
	
	public ArrayList<Course> categoryCourseListView(int categoryNo){
		return null;}  // 카테고리 별 강좌 뷰
	
	public int pagePassing(int pageNo){
		return pageNo;}  // 페이지 넘김

	public ArrayList<Course> courseListView(int currentPage, int limit, String category) {
		Connection conn = getConnection();
		ArrayList<Course> list = cdao.selectList(conn, currentPage, limit, category);
		close(conn);
		return list;
	}

	public int getListCount(String category) {
		Connection conn = getConnection();
		int listCount = cdao.getListCount(conn, category);
		close(conn);
		return listCount;
	}

	public String getCategoryUpper(String category) {
		Connection conn = getConnection();
		String categoryUpper = cdao.getCategoryUpper(conn, category);
		close(conn);
		return categoryUpper;
	}


}



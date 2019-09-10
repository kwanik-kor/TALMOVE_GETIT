package category.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import course.model.vo.Course;

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

	
	
	
}

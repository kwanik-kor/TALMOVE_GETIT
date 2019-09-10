package category.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import course.model.vo.Course;

public class CategoryService {
	
	
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
	
	public int selectCourse(int courseNo){
		return courseNo;}  // 강좌 선택
	
	public int pagePassing(int pageNo){
		return pageNo;}  // 페이지 넘김

}



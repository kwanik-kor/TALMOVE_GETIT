package category.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import category.model.dao.CategoryDao;
import course.model.vo.Course;
import lecture.model.vo.Lecture;
import section.model.vo.Section;
import teacher.model.vo.Teacher;
import category.model.vo.Category;
import course.model.vo.Course;

public class CategoryService {
	private CategoryDao cDao = new CategoryDao();
	
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

	public ArrayList<Course> courseListView(int currentPage, int limit, String category) {
		Connection conn = getConnection();
		ArrayList<Course> list = cDao.selectList(conn, currentPage, limit, category);
		close(conn);
		return list;
	}

	public int getListCount(String category) {
		Connection conn = getConnection();
		int listCount = cDao.getListCount(conn, category);
		close(conn);
		return listCount;
	}

	public String getCategoryUpper(String category) {
		Connection conn = getConnection();
		String categoryUpper = cDao.getCategoryUpper(conn, category);
		close(conn);
		return categoryUpper;
	}


	public ArrayList<Category> getCategoryList(String categoryName) {
		Connection conn = getConnection();
		ArrayList<Category> clist = cDao.getCategoryList(conn, categoryName);
		close(conn);
		return clist;
	}

	public ArrayList<Course> courseDetailView(int courseNo) {
		Connection conn = getConnection();
		ArrayList<Course> list = cDao.courseDetailView(conn, courseNo);
		close(conn);
		return list;
	}

	public int studentCount(int courseNo) {
		Connection conn = getConnection();
		int studentCount = cDao.studentCount(conn, courseNo);
		close(conn);
		return studentCount;
	}

	public int reviewCount(int courseNo) {
		Connection conn = getConnection();
		int reviewCount = cDao.reviewCount(conn, courseNo);
		close(conn);
		return reviewCount;
	}

	public double reviewPoint(int courseNo) {
		Connection conn = getConnection();
		double reviewPoint = cDao.reviewPoint(conn, courseNo);
		close(conn);
		return reviewPoint;
	}

	public int videoCount(int courseNo) {
		Connection conn = getConnection();
		int videoCount = cDao.videoCount(conn, courseNo);
		close(conn);
		return videoCount;
	}

	public int fileCount(int courseNo) {
		Connection conn = getConnection();
		int fileCount = cDao.fileCount(conn, courseNo);
		close(conn);
		return fileCount;
	}

	public ArrayList<Section> sectionView(int courseNo) {
		Connection conn = getConnection();
		ArrayList<Section> slist = cDao.sectionView(conn, courseNo);
		close(conn);
		return slist;
	}

	public ArrayList<Lecture> lectureView(int courseNo) {
		Connection conn = getConnection();
		ArrayList<Lecture> llist = cDao.lectureView(conn, courseNo);
		close(conn);
		return llist;
	}

	public ArrayList<Teacher> teachherView(int courseNo) {
		Connection conn = getConnection();
		ArrayList<Teacher> tlist = cDao.teacherView(conn, courseNo);
		close(conn);
		return tlist;
	}

}



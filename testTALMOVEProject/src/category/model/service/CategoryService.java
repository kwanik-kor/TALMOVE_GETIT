package category.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import category.model.dao.CategoryDao;
import course.model.vo.Course;
import lecture.model.vo.Lecture;
import review.model.vo.Review;
import section.model.vo.Section;
import teacher.model.vo.Teacher;
import category.model.vo.Category;
import course.model.vo.Course;

public class CategoryService {
	private CategoryDao cDao = new CategoryDao();
	
	public ArrayList<Course> selectSortPurchaseCounrt(int currentPage, int limit, String category){
		Connection conn = getConnection();
		ArrayList<Course> list = cDao.selectSortPurchaseCounrt(conn, currentPage, limit, category);
		close(conn);
		return list;
	}  // 인기도 정렬
	
	
	public ArrayList<Course> selectSortRowPrice(int currentPage, int limit, String category){
		Connection conn = getConnection();
		ArrayList<Course> list = cDao.selectSortRowPrice(conn, currentPage, limit, category);
		close(conn);
		return list;
	}  // 최저가 정렬
	
	public ArrayList<Course> selectSortHighPrice(int currentPage, int limit, String category){
		Connection conn = getConnection();
		ArrayList<Course> list = cDao.selectSortHighPrice(conn, currentPage, limit, category);
		close(conn);
		return list;
	}  // 최고가 정렬
	

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

	public ArrayList<Category> getAllCategoryList() {
		Connection conn = getConnection();
		ArrayList<Category> clist = cDao.getAllCategoryList(conn);
		close(conn);
		return clist;
	}

	public ArrayList<Review> reviewView(int courseNo) {
		Connection conn = getConnection();
		ArrayList<Review> rlist = cDao.reviewView(conn, courseNo);
		close(conn);
		return rlist;
	}

	public ArrayList<Course> starCourse(String category) {
		Connection conn = getConnection();
		ArrayList<Course> flist = cDao.starCourse(conn, category);
		close(conn);
		return flist;
	}


	public ArrayList<Course> UppercourseListView(int currentPage, int limit, String category) {
		Connection conn = getConnection();
		ArrayList<Course> list = cDao.UppercourseListView(conn, currentPage, limit, category);
		close(conn);
		return list;
	}


	public int getUpperListCount() {
		Connection conn = getConnection();
		int UppderListCount = cDao.getUppderListCount(conn);
		close(conn);
		return UppderListCount;
	}


	public ArrayList<Course> UpperstarCourse() {
		Connection conn = getConnection();
		ArrayList<Course> flist = cDao.UpperstarCourse(conn);
		close(conn);
		return flist;
	}


	public ArrayList<Course> ProUppercourseListView(int currentPage, int limit, String category) {
		Connection conn = getConnection();
		ArrayList<Course> list = cDao.ProUppercourseListView(conn, currentPage, limit, category);
		close(conn);
		return list;
	}


	public int getProUpperListCount() {
		Connection conn = getConnection();
		int UppderListCount = cDao.getProUpperListCount(conn);
		close(conn);
		return UppderListCount;
	}


	public ArrayList<Course> ProUpperstarCourse() {
		Connection conn = getConnection();
		ArrayList<Course> flist = cDao.ProUpperstarCourse(conn);
		close(conn);
		return flist;
	}


	public String videoPlay(int courseNo) {
		Connection conn = getConnection();
		String videoSrc = cDao.videoPlay(conn, courseNo);
		close(conn);
		return videoSrc;
	}


}



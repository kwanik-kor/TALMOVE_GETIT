package course.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import course.model.dao.CourseDao;
import course.model.vo.Course;
import payment.model.vo.Payment;

import static common.JDBCTemplate.*;

public class CourseService {
	private CourseDao cdao = new CourseDao();
	
	//지우
	
	public Course courseDetailView( int courseNo)  {
		return null;} //상세 강좌 뷰
	public Payment directPay( int courseNo, int price)  {
		return null;} //바로 결제(강좌 수강)
	public Object playVideo( int courseNo, String lerctureOriginalFileName)  {
		return lerctureOriginalFileName;
		} //샘플동영상 재생

	




	
	
	//건우
	public ArrayList<Course> CourseLoad( int courseNo, Course course){
		return null;}

	public int CourseSave( int courseNo,Course course){
		return courseNo;}


	public int CourseCreate( int courseNo,Course course){
		return courseNo;}



	public String NameChange( int courseNo,Course course, String newname){
		return newname;}



	public int AttachmentEnroll( int courseNo,Course course){
		return courseNo;}




	public int AttachmentDelete( int courseNo,Course course){
		return courseNo;}



	public Object  VideoUpload( int courseNo,Course course,Object video){
		return video;}



	public int VideoDelete( int courseNo,Course course, Object video){
		return courseNo;}
	
	
	
	
	
	
	//학열
	public ArrayList<Course>selectCourse (int currentPage, int limit){
		Connection conn = getConnection();
		ArrayList<Course> list = cdao.selectCourse(conn, currentPage, limit);
		close(conn);
		return list;
	}
	
	public int getListCount() {
		Connection conn = getConnection();
		int listCount = cdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	//강좌 정렬
	public ArrayList<Course> sortCourse (int courseNo){
		return null;}

}

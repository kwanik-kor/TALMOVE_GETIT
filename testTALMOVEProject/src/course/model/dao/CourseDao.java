package course.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import cart.model.vo.Cart;
import course.model.vo.Course;
import course.model.vo.Course;
import payment.model.vo.Payment;
import review.model.vo.Review;
import teacher.model.vo.Teacher;

public class CourseDao {
	
	//지우
		
		public Course courseDetailView(Connection conn, int courseNo)  {
			return null;} //상세 강좌 뷰
		public Payment directPay(Connection conn, int courseNo, int price)  {
			return null;} //바로 결제(강좌 수강)
		public Object playVideo(Connection conn, int courseNo, String lerctureOriginalFileName)  {
			return lerctureOriginalFileName;
			} //샘플동영상 재생
		
		





		
		
		//건우
		public ArrayList<Course> CourseLoad(Connection conn, int courseNo, Course course){
			return null;}

		public int CourseSave(Connection conn, int courseNo,Course course){
			return courseNo;}


		public int CourseCreate(Connection conn, int courseNo,Course course){
			return courseNo;}



		public String NameChange(Connection conn, int courseNo,Course course, String newname){
			return newname;}



		public int AttachmentEnroll(Connection conn, int courseNo,Course course){
			return courseNo;}




		public int AttachmentDelete(Connection conn, int courseNo,Course course){
			return courseNo;}



		public Object  VideoUpload(Connection conn, int courseNo,Course course,Object video){
			return video;}



		public int VideoDelete(Connection conn, int courseNo,Course course, Object video){
			return courseNo;}
		
		
		
		
		
		
		//학열
		public ArrayList<Course>selecCourse (Connection conn, int courseNo){
			return null;}

		//강좌 정렬
		public ArrayList<Course> sortCourse (Connection conn, int courseNo){
			return null;}


}

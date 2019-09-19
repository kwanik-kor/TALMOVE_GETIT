package course.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import course.model.vo.Course;
import payment.model.vo.Payment;

import static common.JDBCTemplate.*;

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
		public ArrayList<Course>selectCourse (Connection conn, int currentPage, int limit){
			ArrayList<Course> list = new ArrayList<Course>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String query = "select * from ("
					+ "select rownum rnum, course_no, teacher_no, category_no, course_name, "
					+ "thumbnail_ofilename, thumbnail_rfilename, description, "
					+ "open_yn, price, purchase_count from (select * from course)) "
					+ "where rnum >= ? and rnum <= ?";
					
			
			int startRow = (currentPage -1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rset=pstmt.executeQuery();
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
					
					list.add(course);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
		
		public int getListCount(Connection conn) {
			int listCount = 0;
			Statement stmt = null;
			ResultSet rset = null;
			
			String query = "select count(*) from course";
			
			try {
				stmt = conn.createStatement();
				rset = stmt.executeQuery(query);
				
				if(rset.next()) {
					listCount = rset.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(stmt);
			}
			
			return listCount;
		}


		//강좌 정렬
		public ArrayList<Course> sortCourse (Connection conn, int courseNo){
			return null;
		}
		

}

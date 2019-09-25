package course.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import course.model.vo.Course;
import payment.model.vo.Payment;

public class CourseDao {
		public CourseDao() {}
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

		public int setCourseBasic(Connection conn, Course course) {
			int result = 0;
			PreparedStatement pstmt = null;
			String query = "INSERT INTO COURSE VALUES(SEQ_COURSENO.NEXTVAL, ?, ?, ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT)";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, course.getTeacherNo());
				pstmt.setInt(2, course.getCategoryNo());
				pstmt.setString(3, course.getCourseName());
				pstmt.setString(4, course.getThumbnailOfileName());
				pstmt.setString(5, course.getThumbnailRfileName());
				pstmt.setString(6, course.getDescription());
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			
			return result;
		}

		public Course getCourseByName(Connection conn, String courseName) {
			Course course = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query = "SELECT * FROM COURSE WHERE COURSE_NAME = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, courseName);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					course = new Course();
					course.setCourseNo(rset.getInt("course_no"));
					course.setTeacherNo(rset.getInt("teacher_no"));
					course.setCategoryNo(rset.getInt("category_no"));
					course.setCourseName(courseName);
					course.setThumbnailOfileName(rset.getString("thumbnail_ofilename"));
					course.setThumbnailRfileName(rset.getString("thumbnail_rfilename"));
					course.setDescription(rset.getString("description"));
					course.setOpenYN(rset.getString("open_yn"));
					course.setPrice(rset.getInt("price"));
					course.setPurchaseCount(rset.getInt("purchase_count"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return course;
		}

		public ArrayList<Course> getCourseListByTNo(Connection conn, int teacherNo) {
			ArrayList<Course> courseList = new ArrayList<Course>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query = "SELECT * FROM COURSE WHERE TEACHER_NO = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, teacherNo);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					Course course = new Course();
					course.setCourseNo(rset.getInt("course_no"));
					course.setTeacherNo(teacherNo);
					course.setCategoryNo(rset.getInt("category_no"));
					course.setCourseName(rset.getString("course_name"));
					course.setThumbnailOfileName(rset.getString("thumbnail_ofilename"));
					course.setThumbnailRfileName(rset.getString("thumbnail_rfilename"));
					course.setDescription(rset.getString("description"));
					course.setOpenYN(rset.getString("open_yn"));
					course.setPrice(rset.getInt("price"));
					course.setPurchaseCount(rset.getInt("purchase_count"));
					courseList.add(course);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return courseList;
		}

		public int setCourseOpen(Connection conn, int courseNo, int price) {
			int result = 0;
			PreparedStatement pstmt = null;
			String query = "UPDATE COURSE SET OPEN_YN = 'Y', PRICE = ? WHERE COURSE_NO = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, price);
				pstmt.setInt(2, courseNo);
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}

		public int deleteCourse(Connection conn, int courseNo) {
			int result = 0;
			PreparedStatement pstmt = null;
			String query = "DELETE FROM COURSE WHERE COURSE_NO = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, courseNo);
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}

		public int cBasicUpdate(Connection conn, Course course) {
			int result = 0;
			PreparedStatement pstmt = null;
			String query = "UPDATE COURSE SET CATEGORY_NO = ?, COURSE_NAME = ?, THUMBNAIL_OFILENAME = ?, THUMBNAIL_RFILENAME = ?, DESCRIPTION = ? WHERE COURSE_NO = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, course.getCategoryNo());
				pstmt.setString(2, course.getCourseName());
				pstmt.setString(3, course.getThumbnailOfileName());
				pstmt.setString(4, course.getThumbnailRfileName());
				pstmt.setString(5, course.getDescription());
				pstmt.setInt(6, course.getCourseNo());
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
			}
			return result;
		}


}

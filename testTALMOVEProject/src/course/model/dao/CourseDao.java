package course.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import course.model.vo.Course;
import lecture.model.vo.Lecture;
import payment.model.vo.Payment;
import section.model.vo.Section;

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
		
		// 건우_editLecture.jsp 섹션정보 불러오기
	public ArrayList<Section> getSectionList(Connection conn, int courseNo) {
			ArrayList<Section> list = new ArrayList<Section>();
	
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query = 	"SELECT SECTION_NO , SECTION_NAME " + 
							"FROM SECTION WHERE COURSE_NO = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, courseNo);
				rset = pstmt.executeQuery();
				while(rset.next()) {

					Section section = new Section();
					section.setSectionNo(rset.getInt("section_no"));
					section.setCourseNo(courseNo);
					section.setSectionName(rset.getString("section_name"));
					list.add(section);

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			System.out.println("코스번호로 섹션리스트 불러오기 완료");
			return list;
		}
		//세션개수 가져오기 ?? 어디쓰더라
		public int getSectionCount(Connection conn, int courseNo) {
		int SectionCount = 0;
		PreparedStatement pstmt  = null;
		ResultSet rset = null;
		
		String query = "SELECT COUNT(*) FROM SECTION WHERE COURSE_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, courseNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				SectionCount = rset.getInt(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("SECTION COUNTING SUCCESS");
		System.out.println("섹션개수 ㅣ" + SectionCount);
		return SectionCount;
		
	}
		public Course getCourse(Connection conn, int courseNumber) {

			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query = "SELECT * FROM COURSE WHERE COURSE_NO = ?";
			Course course = new Course();
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, courseNumber);
				rset = pstmt.executeQuery();
				
				 
			if(rset.next()) {	
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
			}	
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			System.out.println("코스넘버 리턴 :"+course.getCourseNo());
			return course;
		}
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
		
		
		//영찬
		public ArrayList<Course>myCourse(Connection conn, int userNo){
			ArrayList<Course> myCourse = new ArrayList<Course>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query = "SELECT O.COURSE_NO, C.THUMBNAIL_OFILENAME, C.THUMBNAIL_RFILENAME, C.COURSE_NAME, T.TEACHER_NAME " 
							+ "FROM ON_COURSE O " 
							+ "LEFT OUTER JOIN COURSE C " 
							+ "ON (O.COURSE_NO = C.COURSE_NO ) " 
							+ "LEFT JOIN TEACHER T " 
							+ "ON (C.TEACHER_NO = T.TEACHER_NO) " 
							+ "WHERE O.USER_NO = ? ";

					try {
						pstmt = conn.prepareStatement(query);
						pstmt.setInt(1, userNo);

			
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Course course = new Course();
					
					
					course.setCourseNo(rset.getInt(1));
					course.setThumbnailOfileName(rset.getString(2));
					course.setThumbnailRfileName(rset.getString(3));
					course.setCourseName(rset.getString(4));
					course.setTeacherName(rset.getString(5));
					
					
					myCourse.add(course);
					System.out.println("dao에 대한 확인 " + myCourse.size());
				}
			
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			return myCourse;
			
			
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

		public ArrayList<String> getSearchedCourseName(Connection conn, String[] keywords) {
			ArrayList<String> clist = new ArrayList<String>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query = "SELECT DISTINCT COURSE_NAME FROM COURSE LEFT OUTER JOIN COURSE_TAG USING(COURSE_NO) LEFT OUTER JOIN TAG USING(TAG_ID) WHERE COURSE_NAME LIKE '%'||?||'%' OR DESCRIPTION LIKE '%'||?||'%' OR TAG_NAME LIKE '%'||?||'%'";
			try {
				pstmt = conn.prepareStatement(query);
				for(int i = 0; i<keywords.length; i++) {
					pstmt.setString(1, keywords[i]);
					pstmt.setString(2, keywords[i]);
					pstmt.setString(3, keywords[i]);
					rset = pstmt.executeQuery();
					while(rset.next()) {
						String s = "";
						s = rset.getString("course_name");
						clist.add(s);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return clist;
		}

		public ArrayList<Course> getSearchedCourse(Connection conn, String[] keywords) {
			ArrayList<Course> clist = new ArrayList<Course>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query = "SELECT * FROM COURSE LEFT OUTER JOIN COURSE_TAG USING(COURSE_NO) LEFT OUTER JOIN TAG USING(TAG_ID) WHERE (COURSE_NAME LIKE '%'||?||'%' OR DESCRIPTION LIKE '%'||?||'%' OR TAG_NAME LIKE '%'||?||'%') AND OPEN_YN = 'Y'";
			try {
				pstmt = conn.prepareStatement(query);
				for(int i = 0; i < keywords.length; i++) {
					pstmt.setString(1, keywords[i]);
					pstmt.setString(2, keywords[i]);
					pstmt.setString(3, keywords[i]);
					rset = pstmt.executeQuery();
					while(rset.next()) {
						Course c = new Course();
						c.setCourseNo(rset.getInt("course_no"));
						c.setTeacherNo(rset.getInt("teacher_no"));
						c.setCategoryNo(rset.getInt("category_no"));
						c.setCourseName(rset.getString("course_name"));
						c.setThumbnailOfileName(rset.getString("thumbnail_ofilename"));
						c.setThumbnailRfileName(rset.getString("thumbnail_rfilename"));
						c.setDescription(rset.getString("description"));
						c.setOpenYN(rset.getString("open_yn"));
						c.setPrice(rset.getInt("price"));
						c.setPurchaseCount(rset.getInt("purchase_count"));
						clist.add(c);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return clist;
		}

		public ArrayList<Lecture> getLectureList(Connection conn, int sectionNo) {
			// TODO Auto-generated method stub
			return null;
		}

		public ArrayList<Lecture> getLectureBySectionNo(Connection conn, int no) {

			ArrayList<Lecture> list = new ArrayList<Lecture>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			String query = "SELECT * FROM LECTURE WHERE SECTION_NO=?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, no);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					Lecture lecture = new Lecture();
					lecture.setLectureNo(rset.getInt("lecture_no"));
					lecture.setSectionNo(rset.getInt("section_no"));
					lecture.setCourseName(rset.getString("course_name"));
					lecture.setSectionName(rset.getString("section_name"));
					lecture.setLectureName(rset.getString("lecture_name"));
					lecture.setLectureOFileName(rset.getString("lecture_original_filename"));
					lecture.setLectureRFileName(rset.getString("lecture_rename_filename"));
					lecture.setAttachmentOfileName(rset.getString("attachment_ofilename"));
					lecture.setAttachmentRfileName(rset.getString("attachment_rfilename"));
					lecture.setLectureContent(rset.getString("lecture_content"));
					list.add(lecture);

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return list;
		}

	
	

}

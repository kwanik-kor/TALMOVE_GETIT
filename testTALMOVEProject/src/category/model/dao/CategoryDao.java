package category.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import category.model.vo.Category;
import course.model.vo.Course;
import lecture.model.vo.Lecture;
import review.model.vo.Review;
import section.model.vo.Section;
import teacher.model.vo.Teacher;

public class CategoryDao {
	public ArrayList<Course> selectSortPurchaseCounrt(Connection conn, int currentPage, int limit, String category){
		ArrayList<Course> list = new ArrayList<Course>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, COURSE_NO, TEACHER_NO, CATEGORY_NO, COURSE_NAME, " + 
				"THUMBNAIL_OFILENAME, THUMBNAIL_RFILENAME, DESCRIPTION, OPEN_YN, PRICE, PURCHASE_COUNT, teacher_name, category_upper " + 
				"from(select * from course join category using (category_no) " + 
				"join teacher using (teacher_no) where category_name like ? " + 
				"order by purchase_count desc)) where rnum >= ? and rnum <= ?";
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
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
				course.setTeacherName(rset.getString("teacher_name"));
				course.setCategoryUpper(rset.getInt("category_upper"));
				
				list.add(course);
			} 
		}catch(Exception e) {
				e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}  // 인기도 정렬
   
   
   public ArrayList<Course> selectSortRowPrice(Connection conn, int currentPage, int limit, String category){
	   ArrayList<Course> list = new ArrayList<Course>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, COURSE_NO, TEACHER_NO, CATEGORY_NO, COURSE_NAME, " + 
				"THUMBNAIL_OFILENAME, THUMBNAIL_RFILENAME, DESCRIPTION, OPEN_YN, PRICE, PURCHASE_COUNT, teacher_name, category_upper " + 
				"from(select * from course join category using (category_no) " + 
				"join teacher using (teacher_no) where category_name like ? " + 
				"order by price)) where rnum >= ? and rnum <= ?";
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
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
				course.setTeacherName(rset.getString("teacher_name"));
				course.setCategoryUpper(rset.getInt("category_upper"));
				
				list.add(course);
			} 
		}catch(Exception e) {
				e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
    }  // 최저가 정렬
   
   public ArrayList<Course> selectSortHighPrice(Connection conn, int currentPage, int limit, String category){
	   ArrayList<Course> list = new ArrayList<Course>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, COURSE_NO, TEACHER_NO, CATEGORY_NO, COURSE_NAME, " + 
				"THUMBNAIL_OFILENAME, THUMBNAIL_RFILENAME, DESCRIPTION, OPEN_YN, PRICE, PURCHASE_COUNT, teacher_name, category_upper " + 
				"from(select * from course join category using (category_no) " + 
				"join teacher using (teacher_no) where category_name like ? " + 
				"order by price desc)) where rnum >= ? and rnum <= ?";
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
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
				course.setTeacherName(rset.getString("teacher_name"));
				course.setCategoryUpper(rset.getInt("category_upper"));
				
				list.add(course);
			} 
		}catch(Exception e) {
				e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
    }  // 최고가 정렬

   public ArrayList<Course> selectList(Connection conn, int currentPage, int limit, String category) {
		ArrayList<Course> list = new ArrayList<Course>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, COURSE_NO, TEACHER_NO, CATEGORY_NO, COURSE_NAME, " + 
				"THUMBNAIL_OFILENAME, THUMBNAIL_RFILENAME, DESCRIPTION, OPEN_YN, PRICE, PURCHASE_COUNT, teacher_name, category_upper " + 
				"from(select * from course join category using (category_no) " + 
				"join teacher using (teacher_no) where category_name like ?" + 
				"order by course_no)) " + 
				"where rnum >= ? and rnum <= ?";
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
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
				course.setTeacherName(rset.getString("teacher_name"));
				course.setCategoryUpper(rset.getInt("category_upper"));
				
				list.add(course);
			} 
		}catch(Exception e) {
				e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

   public int getListCount(Connection conn, String category) {
      int listCount = 0;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query = "select count(*) "
            + "from course "
            + "join category using (category_no) "
            + "where category_name like ?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, category);
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            listCount = rset.getInt(1);
         } 
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      return listCount;
   }
   public ArrayList<Category> getCategoryList(Connection conn, String categoryName) {
      ArrayList<Category> clist = new ArrayList<Category>();
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      String query = "SELECT * FROM CATEGORY WHERE CATEGORY_UPPER = (SELECT CATEGORY_NO FROM CATEGORY WHERE CATEGORY_NAME = ?)";
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, categoryName);
         rset = pstmt.executeQuery();
         
         while(rset.next()) {
            Category c = new Category();
            c.setCategoryNo(rset.getInt("category_no"));
            c.setCategoryName(rset.getString("category_name"));
            c.setCategoryUpper(rset.getInt("category_upper"));
            clist.add(c);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      
      return clist;
   }

   public String getCategoryUpper(Connection conn, String category) {
      String categoryUpper = null;
      
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query = "SELECT B.CATEGORY_NAME AS 상위카테고리 FROM CATEGORY A JOIN CATEGORY B ON(A.CATEGORY_UPPER = B.CATEGORY_NO) "
            + "WHERE A.CATEGORY_NAME=?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, category);
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            categoryUpper = rset.getString(1);

         } 
      }catch(Exception e) {
            e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }

      return categoryUpper;
   }

   public ArrayList<Course> courseDetailView(Connection conn, int courseNo) {
      ArrayList<Course> list = new ArrayList<Course>();
      
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query="select * from course "
            + "join teacher using (teacher_no) "
            + "where course_no = ?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, courseNo);
         rset = pstmt.executeQuery();
         
         while(rset.next()) {
            Course course = new Course();
            
            course.setCategoryNo(rset.getInt("course_no"));
            course.setTeacherNo(rset.getInt("teacher_no"));
            course.setCategoryNo(rset.getInt("category_no"));
            course.setCourseName(rset.getString("course_name"));
            course.setThumbnailOfileName(rset.getString("thumbnail_ofilename"));
            course.setThumbnailRfileName(rset.getString("thumbnail_rfilename"));
            course.setDescription(rset.getString("description"));
            course.setOpenYN(rset.getString("open_yn"));
            course.setPrice(rset.getInt("price"));
            course.setPurchaseCount(rset.getInt("purchase_count"));
            course.setTeacherName(rset.getString("teacher_name"));
            
            list.add(course);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      return list;
   }

   public int studentCount(Connection conn, int courseNo) {
      int studentCount = 0;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query = "select count(*) "
            + "from on_course "
            + "where course_no = ?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, courseNo);
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            studentCount = rset.getInt(1);
         } 
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      return studentCount;
   }

   public int reviewCount(Connection conn, int courseNo) {
      int reviewCount = 0;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query = "select count(*) "
            + "from review "
            + "where course_no = ?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, courseNo);
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            reviewCount = rset.getInt(1);
         } 
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      return reviewCount;
   }

   public double reviewPoint(Connection conn, int courseNo) {
      double reviewPoint = 0.0;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query = "select avg(rating) "
            + "from review "
            + "where course_no = ?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setDouble(1, courseNo);
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            reviewPoint = rset.getInt(1);
         } 
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      return reviewPoint;
   }

   public int videoCount(Connection conn, int courseNo) {
      int videoCount = 0;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query = "select count(LECTURE_ORIGINAL_FILENAME) from lecture " + 
            "join course using (course_name) " + 
            "where course_no = ?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, courseNo);
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            videoCount = rset.getInt(1);
         } 
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      return videoCount;
   }

   public int fileCount(Connection conn, int courseNo) {
      int fileCount = 0;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query = "select count(ATTACHMENT_OFILENAME) from lecture " + 
            "join course using (course_name) " + 
            "where course_no = ?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, courseNo);
         
         rset = pstmt.executeQuery();
         
         if(rset.next()) {
            fileCount = rset.getInt(1);
         } 
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      return fileCount;
   }

   
   
   public ArrayList<Section> sectionView(Connection conn, int courseNo) {
      ArrayList<Section> slist = new ArrayList<Section>();
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query = "select * " + 
            "from section " + 
            "where course_no = ?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, courseNo);
         
         rset = pstmt.executeQuery();
         
         while(rset.next()) {
            Section section = new Section();
            section.setSectionNo(rset.getInt("section_no"));
            section.setCourseNo(rset.getInt("course_no"));
            section.setSectionName(rset.getString("section_name"));
            
            slist.add(section);
         } 
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      for(Section s : slist) {
         System.out.println(s.getSectionName());
      }
      return slist;
   }

   public ArrayList<Lecture> lectureView(Connection conn, int courseNo) {
      ArrayList<Lecture> llist = new ArrayList<Lecture>();
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query = "select * from lecture join course using (course_name) where course_no = ?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, courseNo);
         
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
            
            llist.add(lecture);
         } 
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      return llist;
   }

   public ArrayList<Teacher> teacherView(Connection conn, int courseNo) {
      ArrayList<Teacher> tlist = new ArrayList<Teacher>();
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String query = "select * from teacher join course using (teacher_no) where course_no = ?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, courseNo);
         
         rset = pstmt.executeQuery();
         
         while(rset.next()) {
            Teacher teacher = new Teacher();
            
            teacher.setTeacherNo(rset.getInt("teacher_no"));
            teacher.setUserNo(rset.getInt("user_no"));
            teacher.setTeacherName(rset.getString("teacher_name"));
            teacher.setTeacherCareer(rset.getString("teacher_career"));
            teacher.setTeacherIntro(rset.getString("teacher_intro"));
            teacher.setTeacherOimageName(rset.getString("teacher_oimage_name"));
            teacher.setTeacherRimageName(rset.getString("teacher_rimage_name"));
            teacher.setTeacherAccountnumber(rset.getInt("teacher_account_number"));
            
            tlist.add(teacher);
         } 
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      return tlist;
   }

   public ArrayList<Category> getAllCategoryList(Connection conn) {
      ArrayList<Category> clist = new ArrayList<Category>();
      Statement stmt = null;
      ResultSet rset = null;
      String query = "SELECT * FROM CATEGORY";
      try {
         stmt = conn.createStatement();
         rset = stmt.executeQuery(query);
         while(rset.next()) {
            Category c = new Category();
            c.setCategoryNo(rset.getInt("category_no"));
            c.setCategoryName(rset.getString("category_name"));
            c.setCategoryUpper(rset.getInt("category_upper"));
            clist.add(c);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(stmt);
      }
      return clist;
   }
   
   public ArrayList<Review> reviewView(Connection conn, int courseNo) {
		ArrayList<Review> rlist = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from review join talmove_user using (user_no) where course_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, courseNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Review r = new Review();
				
				r.setReviewNo(rset.getInt("review_no"));
				r.setCourseNo(rset.getInt("course_no"));
				r.setUserNo(rset.getInt("user_no"));
				r.setRating(rset.getInt("rating"));
				r.setReviewContent(rset.getString("review_content"));
				r.setReviewDate(rset.getDate("review_date"));
				r.setModifiedReviewDate(rset.getDate("modified_review_date"));
				r.setReviewUserName(rset.getString("user_name"));
				
				rlist.add(r);
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return rlist;
	}

	public ArrayList<Course> starCourse(Connection conn, String category) {
		ArrayList<Course> flist = new ArrayList<Course>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, COURSE_NO, TEACHER_NO, CATEGORY_NO, COURSE_NAME, " + 
				"THUMBNAIL_OFILENAME, THUMBNAIL_RFILENAME, DESCRIPTION, OPEN_YN, PRICE, PURCHASE_COUNT, teacher_name " + 
				"from(select * from course join category using (category_no) " + 
				"join teacher using (teacher_no) " + 
				"where category_name like ? order by PURCHASE_COUNT desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, category);
			pstmt.setInt(2, 1);
			pstmt.setInt(3, 4);
			
			rset = pstmt.executeQuery();
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
				course.setTeacherName(rset.getString("teacher_name"));
				
				flist.add(course);
			} 
		}catch(Exception e) {
				e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return flist;
	}


	public ArrayList<Course> UppercourseListView(Connection conn, int currentPage, int limit, String category) {
		ArrayList<Course> list = new ArrayList<Course>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * " + 
				"from course " + 
				"join category using (category_no) " +
				"join teacher using (teacher_no) " +
				"where category_upper = 1";
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
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
				course.setTeacherName(rset.getString("teacher_name"));
				course.setCategoryUpper(rset.getInt("category_upper"));
				
				list.add(course);
			} 
		}catch(Exception e) {
				e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}


	public int getUppderListCount(Connection conn) {
		int listCount = 0;
	      Statement stmt = null;
	      ResultSet rset = null;
	      
	      String query = "select count(*) from course " + 
	      		"join category using (category_no) where category_upper = 1";
	      
	      try {
	    	  stmt = conn.createStatement();
	    	  rset = stmt.executeQuery(query);
	    			  
	         
	         if(rset.next()) {
	            listCount = rset.getInt(1);
	         } 
	      } catch(Exception e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(stmt);
	      }
	      return listCount;
	}


	public ArrayList<Course> UpperstarCourse(Connection conn) {
		ArrayList<Course> flist = new ArrayList<Course>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, COURSE_NO, TEACHER_NO, CATEGORY_NO, COURSE_NAME, " + 
				"THUMBNAIL_OFILENAME, THUMBNAIL_RFILENAME, DESCRIPTION, OPEN_YN, PRICE, PURCHASE_COUNT, teacher_name " + 
				"from(select * from course join category using (category_no) " + 
				"join teacher using (teacher_no) " + 
				"where category_upper = 1 order by PURCHASE_COUNT desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, 4);
			
			rset = pstmt.executeQuery();
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
				course.setTeacherName(rset.getString("teacher_name"));
				
				flist.add(course);
			} 
		}catch(Exception e) {
				e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return flist;
	}


	public ArrayList<Course> ProUppercourseListView(Connection conn, int currentPage, int limit, String category) {
ArrayList<Course> list = new ArrayList<Course>();
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * " + 
				"from course " + 
				"join category using (category_no) " +
				"join teacher using (teacher_no) " +
				"where category_upper = 2";
		
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
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
				course.setTeacherName(rset.getString("teacher_name"));
				course.setCategoryUpper(rset.getInt("category_upper"));
				
				list.add(course);
			} 
		}catch(Exception e) {
				e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return list;
	}


	public int getProUpperListCount(Connection conn) {
		int listCount = 0;
	      Statement stmt = null;
	      ResultSet rset = null;
	      
	      String query = "select count(*) from course " + 
	      		"join category using (category_no) where category_upper = 2";
	      
	      try {
	    	  stmt = conn.createStatement();
	    	  rset = stmt.executeQuery(query);
	    			  
	         
	         if(rset.next()) {
	            listCount = rset.getInt(1);
	         } 
	      } catch(Exception e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(stmt);
	      }
	      return listCount;
	}


	public ArrayList<Course> ProUpperstarCourse(Connection conn) {
ArrayList<Course> flist = new ArrayList<Course>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from(select rownum rnum, COURSE_NO, TEACHER_NO, CATEGORY_NO, COURSE_NAME, " + 
				"THUMBNAIL_OFILENAME, THUMBNAIL_RFILENAME, DESCRIPTION, OPEN_YN, PRICE, PURCHASE_COUNT, teacher_name " + 
				"from(select * from course join category using (category_no) " + 
				"join teacher using (teacher_no) " + 
				"where category_upper = 2 order by PURCHASE_COUNT desc)) " + 
				"where rnum >= ? and rnum <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, 4);
			
			rset = pstmt.executeQuery();
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
				course.setTeacherName(rset.getString("teacher_name"));
				
				flist.add(course);
			} 
		}catch(Exception e) {
				e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return flist;
	}


	public String videoPlay(Connection conn, int courseNo) {
		String videoSrc = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String query = "select * from (select rownum rnum, lecture_original_filename, "
	      		+ "course_no from lecture join course using (course_name)) " + 
	      		"where course_no = ? and rnum = 1;";
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, courseNo);
	         
	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	            videoSrc = rset.getString("lecture_original_filename");
	         } 
	      } catch(Exception e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      System.out.println(videoSrc);
	      return videoSrc;
	}
}
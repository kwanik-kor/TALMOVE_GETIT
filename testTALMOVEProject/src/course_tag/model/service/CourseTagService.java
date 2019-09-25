package course_tag.model.service;

import static common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;

import course_tag.model.dao.CourseTagDao;
import course_tag.model.vo.CourseTag;

public class CourseTagService {
	private CourseTagDao ctDao = new CourseTagDao();

	public ArrayList<CourseTag> getCourseTagList(int teacherNo) {
		Connection conn = getConnection();
		ArrayList<CourseTag> ctList = ctDao.getCourseTagList(conn, teacherNo);
		close(conn);
		return ctList;
	}
}

package tag.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import tag.model.dao.TagDao;
import tag.model.vo.Tag;

public class TagService {
	private TagDao tDao = new TagDao();
	
	public ArrayList<Tag> exixtingCheck(Tag tag){
		return null;}
	
	public ArrayList<Tag> tagSave(Tag tag){
		return null;}
	
	public ArrayList<Tag> TagRestoreProcess(Tag tag){
		return null;}

	public int insertTag(String[] tagList) {
		Connection conn = getConnection();
		int result = tDao.insertTag(conn, tagList);
		if(result > 0) {
			commit(conn);
		}else{
			rollback(conn);
		}
		
		return result;
	}

	public int insertTagCourse(int courseNo, String[] tagList) {
		Connection conn = getConnection();
		int result = tDao.insertTagCourse(conn, courseNo, tagList);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public ArrayList<Tag> getTagListByTNo(int teacherNo) {
		Connection conn = getConnection();
		ArrayList<Tag> result = tDao.getTagListByTNo(conn, teacherNo);
		close(conn);
		return result;
	}


}

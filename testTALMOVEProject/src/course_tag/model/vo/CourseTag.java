package course_tag.model.vo;

import java.io.Serializable;

public class CourseTag implements Serializable{
	private static final long serialVersionUID = 2100L;
	private int courseNo;
	private int tagId;
	
	public CourseTag() {}
	public CourseTag(int courseNo, int tagId) {
		super();
		this.courseNo = courseNo;
		this.tagId = tagId;
	}
	public int getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	@Override
	public String toString() {
		return "CourseTag [courseNo=" + courseNo + ", tagId=" + tagId + "]";
	}
	
}

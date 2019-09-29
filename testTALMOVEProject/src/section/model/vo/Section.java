package section.model.vo;

import java.io.Serializable;

public class Section implements Serializable{
	private static final long serialVersionUID = 2000L;
	
	private int sectionNo;
	private int courseNo;
	private String sectionName;
	
	public Section(){}

	@Override
	public String toString() {
		return "Section [sectionNo=" + sectionNo + ", courseNo=" + courseNo + ", sectionName=" + sectionName + "]";
	}

	public Section(int sectionNo, int courseNo, String sectionName) {
		super();
		this.sectionNo = sectionNo;
		this.courseNo = courseNo;
		this.sectionName = sectionName;
	}

	public int getSectionNo() {
		return sectionNo;
	}

	public void setSectionNo(int sectionNo) {
		this.sectionNo = sectionNo;
	}

	public int getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	
}

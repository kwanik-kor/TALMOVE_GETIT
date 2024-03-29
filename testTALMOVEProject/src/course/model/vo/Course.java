package course.model.vo;

import java.io.Serializable;

public class Course implements Serializable{
	private static final long serialVersionUID = 1200L; 
	private int courseNo;
	private int teacherNo;
	private int categoryNo;
	private String courseName;
	private String thumbnailOfileName;
	private String thumbnailRfileName;
	private String  description;
	private String openYN; //공개 비공개
	private int price;
	private int purchaseCount;
	private String teacherName;
	private int categoryUpper;
	private String lectureOriginalFilename;
	
	public Course() {}
	
	
	public Course(int courseNo, int teacherNo, int categoryNo, String courseName, String thumbnailOfileName,
			String thumbnailRfileName, String description, String openYN, int price, int purchaseCount,
			String teacherName, int categoryUpper, String lectureOriginalFilename) {
		super();
		this.courseNo = courseNo;
		this.teacherNo = teacherNo;
		this.categoryNo = categoryNo;
		this.courseName = courseName;
		this.thumbnailOfileName = thumbnailOfileName;
		this.thumbnailRfileName = thumbnailRfileName;
		this.description = description;
		this.openYN = openYN;
		this.price = price;
		this.purchaseCount = purchaseCount;
		this.teacherName = teacherName;
		this.categoryUpper = categoryUpper;
		this.lectureOriginalFilename = lectureOriginalFilename;
	}


	public Course(int courseNo, int teacherNo, int categoryNo, String courseName, String thumbnailOfileName,
			String thumbnailRfileName, String description, String openYN, int price, int purchaseCount) {
		super();
		this.courseNo = courseNo;
		this.teacherNo = teacherNo;
		this.categoryNo = categoryNo;
		this.courseName = courseName;
		this.thumbnailOfileName = thumbnailOfileName;
		this.thumbnailRfileName = thumbnailRfileName;
		this.description = description;
		this.openYN = openYN;
		this.price = price;
		this.purchaseCount = purchaseCount;
	}
	
	public Course(String thumbnailOfileName, String thumbnailRfileNameint, int courseNo, String courseName, int price) {
		super();
		this.thumbnailOfileName = thumbnailOfileName;
		this.thumbnailRfileName = thumbnailRfileNameint;
		this.courseNo = courseNo; 
		this.courseName = courseName;
		this.price = price;
	}

	public Course(int courseNo, int teacherNo, int categoryNo, String courseName, String thumbnailOfileName,
			String thumbnailRfileName, String description, String openYN, int price, int purchaseCount,
			String teacherName) {
		super();
		this.courseNo = courseNo;
		this.teacherNo = teacherNo;
		this.categoryNo = categoryNo;
		this.courseName = courseName;
		this.thumbnailOfileName = thumbnailOfileName;
		this.thumbnailRfileName = thumbnailRfileName;
		this.description = description;
		this.openYN = openYN;
		this.price = price;
		this.purchaseCount = purchaseCount;
		this.teacherName = teacherName;
	}
	
	public Course(int courseNo, int teacherNo, int categoryNo, String courseName, String thumbnailOfileName,
			String thumbnailRfileName, String description, String openYN, int price, int purchaseCount,
			String teacherName, int categoryUpper) {
		super();
		this.courseNo = courseNo;
		this.teacherNo = teacherNo;
		this.categoryNo = categoryNo;
		this.courseName = courseName;
		this.thumbnailOfileName = thumbnailOfileName;
		this.thumbnailRfileName = thumbnailRfileName;
		this.description = description;
		this.openYN = openYN;
		this.price = price;
		this.purchaseCount = purchaseCount;
		this.teacherName = teacherName;
		this.categoryUpper = categoryUpper;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getCourseNo() {
		return courseNo;
	}
	public int getTeacherNo() {
		return teacherNo;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getThumbnailOfileName() {
		return thumbnailOfileName;
	}
	public String getThumbnailRfileName() {
		return thumbnailRfileName;
	}
	public String getDescription() {
		return description;
	}
	public String getOpenYN() {
		return openYN;
	}
	public int getPrice() {
		return price;
	}
	public int getPurchaseCount() {
		return purchaseCount;
	}
	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}
	public void setTeacherNo(int teacherNo) {
		this.teacherNo = teacherNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setThumbnailOfileName(String thumbnailOfileName) {
		this.thumbnailOfileName = thumbnailOfileName;
	}
	public void setThumbnailRfileName(String thumbnailRfileName) {
		this.thumbnailRfileName = thumbnailRfileName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setOpenYN(String openYN) {
		this.openYN = openYN;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setPurchaseCount(int purchaseCount) {
		this.purchaseCount = purchaseCount;
	}
	
	
	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	
	
	public int getCategoryUpper() {
		return categoryUpper;
	}

	public void setCategoryUpper(int categoryUpper) {
		this.categoryUpper = categoryUpper;
	}
	
	

	public String getLectureOriginalFilename() {
		return lectureOriginalFilename;
	}


	public void setLectureOriginalFilename(String lectureOriginalFilename) {
		this.lectureOriginalFilename = lectureOriginalFilename;
	}


	@Override
	public String toString() {
		return "Course [courseNo=" + courseNo + ", teacherNo=" + teacherNo + ", categoryNo=" + categoryNo
				+ ", courseName=" + courseName + ", thumbnailOfileName=" + thumbnailOfileName + ", thumbnailRfileName="
				+ thumbnailRfileName + ", description=" + description + ", openYN=" + openYN + ", price=" + price
				+ ", purchaseCount=" + purchaseCount + "]";
	}
	
	@Override
	public int hashCode() {
		return (this.courseNo + this.courseName.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Course) {
			Course temp = (Course)obj;
			if(this.courseNo == temp.courseNo && this.courseName.equals(temp.courseName)) {
				return true;
			}
		}
		return false;
	}
	
	
	
}

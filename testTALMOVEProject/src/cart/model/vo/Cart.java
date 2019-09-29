package cart.model.vo;

public class Cart implements java.io.Serializable{
	private static final long serialVersionUID = 1002L;
	
	
	private int cartNo;
	private int userNo;
	private int courseNo;
	private String teacherName;
	private String courseName;
	private String thumbnailOfileName;
	private String thumbnailRfileName;
	private int price;
	private int totalPrice = 0;
	
	
	public Cart() {}


	public Cart(int cartNo, int userNo, int courseNo, String teacherName, String courseName, String thumbnailOfileName,
			String thumbnailRfileName, int price, int totalPrice) {
		super();
		this.cartNo = cartNo;
		this.userNo = userNo;
		this.courseNo = courseNo;
		this.teacherName = teacherName;
		this.courseName = courseName;
		this.thumbnailOfileName = thumbnailOfileName;
		this.thumbnailRfileName = thumbnailRfileName;
		this.price = price;
		this.totalPrice = totalPrice;
	}


	public int getCartNo() {
		return cartNo;
	}


	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public int getCourseNo() {
		return courseNo;
	}


	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getThumbnailOfileName() {
		return thumbnailOfileName;
	}


	public void setThumbnailOfileName(String thumbnailOfileName) {
		this.thumbnailOfileName = thumbnailOfileName;
	}


	public String getThumbnailRfileName() {
		return thumbnailRfileName;
	}


	public void setThumbnailRfileName(String thumbnailRfileName) {
		this.thumbnailRfileName = thumbnailRfileName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	


	@Override
	public String toString() {
		return "Cart [cartNo=" + cartNo + ", userNo=" + userNo + ", courseNo=" + courseNo + ", teacherName="
				+ teacherName + ", courseName=" + courseName + ", thumbnailOfileName=" + thumbnailOfileName
				+ ", thumbnailRfileName=" + thumbnailRfileName + ", price=" + price + ", totalPrice=" + totalPrice
				+ "]";
	}



	
	
	
}
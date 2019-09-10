package cart.model.vo;

public class Cart {

	private int cartNo;
	private int userNo;
	private int CourseNo;
	private String CourseName;
	private String thumbnailOfileName;
	private String thumbnailRfileName;
	private int price;
	
	public Cart(int cartNo, int userNo, int courseNo, String courseName, String thumbnailOfileName,
			String thumbnailRfileName, int price) {
		super();
		this.cartNo = cartNo;
		this.userNo = userNo;
		CourseNo = courseNo;
		CourseName = courseName;
		this.thumbnailOfileName = thumbnailOfileName;
		this.thumbnailRfileName = thumbnailRfileName;
		this.price = price;
	}
	
	public int getCartNo() {
		return cartNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public int getCourseNo() {
		return CourseNo;
	}
	public String getCourseName() {
		return CourseName;
	}
	public String getThumbnailOfileName() {
		return thumbnailOfileName;
	}
	public String getThumbnailRfileName() {
		return thumbnailRfileName;
	}
	public int getPrice() {
		return price;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public void setCourseNo(int courseNo) {
		CourseNo = courseNo;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public void setThumbnailOfileName(String thumbnailOfileName) {
		this.thumbnailOfileName = thumbnailOfileName;
	}
	public void setThumbnailRfileName(String thumbnailRfileName) {
		this.thumbnailRfileName = thumbnailRfileName;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [cartNo=" + cartNo + ", userNo=" + userNo + ", CourseNo=" + CourseNo + ", CourseName=" + CourseName
				+ ", thumbnailOfileName=" + thumbnailOfileName + ", thumbnailRfileName=" + thumbnailRfileName
				+ ", price=" + price + "]";
	}
	
	
	
	
	
}

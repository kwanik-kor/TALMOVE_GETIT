package category.model.vo;

import java.io.Serializable;

public class Category implements Serializable{
	private static final long serialVersionUID = 1600L; 
	
	private int categoryNo;
	private String categoryName;
	private int categoryUpper;
	
	public Category() {}
	public Category(int categoryNo, String categoryName, int categoryUpper) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.categoryUpper = categoryUpper;
	}

	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getCategoryUpper() {
		return categoryUpper;
	}
	public void setCategoryUpper(int categoryUpper) {
		this.categoryUpper = categoryUpper;
	}
	@Override
	public String toString() {
		return "Category [categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", categoryUpper="
				+ categoryUpper + "]";
	}

}

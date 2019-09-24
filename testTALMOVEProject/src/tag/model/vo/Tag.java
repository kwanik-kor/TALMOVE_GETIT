package tag.model.vo;

import java.io.Serializable;

public class Tag implements Serializable{
	private static final long serialVersionUID = 2000L; 
	
	private int tagId;
	private String tagName;
	
	public Tag() {}

	public Tag(int tagId, String tagName) {
		super();
		this.tagId = tagId;
		this.tagName = tagName;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", tagName=" + tagName + "]";
	}
	
	
}

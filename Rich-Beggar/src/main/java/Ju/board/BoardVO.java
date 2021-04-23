package Ju.board;

import java.util.Date;

public class BoardVO {
	private int contentID;
	private String Title;
	private String userID;
	private Date date;
	private String content;
	private int Available;
	private int Flag;

	public int getContentID() {
		return contentID;
	}

	public void setContentID(int contentID) {
		this.contentID = contentID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAvailable() {
		return Available;
	}

	public void setAvailable(int available) {
		Available = available;
	}

	public int getFlag() {
		return Flag;
	}

	public void setFlag(int flag) {
		Flag = flag;
	}
}

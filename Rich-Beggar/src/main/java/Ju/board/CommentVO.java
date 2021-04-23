package Ju.board;

import java.util.Date;

public class CommentVO {
	private int pid;
	private String code;
	private String comment;
	private Date date;
	private String userID;
	private String delFlag;

	public CommentVO() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public CommentVO(int pid, String code, String comment, Date date, String useID, String delFlag) {
		this.pid = pid;
		this.code = code;
		this.comment = comment;
		this.date = date;
		this.userID = useID;
		this.delFlag = delFlag;
	}

	public CommentVO(String id, String comment, String code) {
		this.userID = id;
		this.comment = comment;
		this.code = code;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String useID) {
		this.userID = useID;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}

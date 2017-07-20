package kdata.project.dto;

import java.util.Date;

public class BoardDTO {
	private int comment_num;
	private String id;
	private String content;
	private Date write_date;
	private int num;
	
	
	public BoardDTO(int comment_num, String id, String content, Date write_date, int num) {
		super();
		this.comment_num = comment_num;
		this.id = id;
		this.content = content;
		this.write_date = write_date;
		this.num = num;
	}
	public BoardDTO(String id, String content, int num) {
		super();
		this.id = id;
		this.content = content;
		this.num = num;
	}
	@Override
	public String toString() {
		return "BoardDTO [comment_num=" + comment_num + ", id=" + id + ", content=" + content + ", write_date="
				+ write_date + ", num=" + num + "]";
	}
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	
	
}

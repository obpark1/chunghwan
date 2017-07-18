package kdata.project.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable{
	private String id;
	private String pw;
	private String name;
	private String Profile;
	private Date reg_date;
	
	public UserDTO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public UserDTO(String id) {
		super();
		this.id = id;
	}

	public UserDTO(String id, String pw, String name, String Profile, Date reg_date) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.Profile = Profile;
		this.reg_date = reg_date;
	}

	public String getProfile() {
		return Profile;
	}

	public void setProfile(String Profile) {
		this.Profile = Profile;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public UserDTO(String id, String name, String Profile, Date reg_date) {
		super();
		this.id = id;
		this.name = name;
		this.Profile = Profile;
		this.reg_date = reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	} 
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

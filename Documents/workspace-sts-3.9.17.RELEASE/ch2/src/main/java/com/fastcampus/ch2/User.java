package com.fastcampus.ch2;

import java.sql.Date;
import java.util.Arrays;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	private String id;
	private String pwd;
	private String name;
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
	private String[] hobby;
	private String[] sns;
	public String getId1() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String[] getSns() {
		return sns;
	}
	public void setSns(String[] sns) {
		this.sns = sns;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", name=" + ", email=" + email
				+ ", birth=" + birth + ", hobby="+ Arrays.toString(sns) +", sns="+ Arrays.toString(sns);
	}
	
}

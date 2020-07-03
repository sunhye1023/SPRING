package com.simple.command;

public class QuizVO {

	private String year;
	private String month;
	private String day;
	
	private String id;
	private String pw;
	private String pw_check;
	private String name;
	private String email;
	
	
	public QuizVO() {
	
	}

	public QuizVO(String year, String month, String day, String id, String pw, String pw_check, String name,
			String email) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.id = id;
		this.pw = pw;
		this.pw_check = pw_check;
		this.name = name;
		this.email = email;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
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



	public String getPw_check() {
		return pw_check;
	}



	public void setPw_check(String pw_check) {
		this.pw_check = pw_check;
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
	
	
	
	
}

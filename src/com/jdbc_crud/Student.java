package com.jdbc_crud;

public class Student {
	
	private int rollno;
	private String name;
	private String city;
	private int pincode;
	
	public Student() {
		super();
	}
	
	public Student(int rollno, String name, String city, int pincode) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.city = city;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "[rollno : " + rollno + ", name : " + name + ", city : " + city + ", pincode : " + pincode + "]";
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}

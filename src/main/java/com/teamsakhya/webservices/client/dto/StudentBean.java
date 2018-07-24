package com.teamsakhya.webservices.client.dto;

import javax.ws.rs.FormParam;

public class StudentBean {
	
	@FormParam("regno")
	private int regno;
	
	@FormParam("name")
	private String name;
	
	@FormParam("address")
	private String address;
	
	@FormParam("marks")
	private double marks;
	
	@FormParam("gender")
	private String gender;
	
	
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + regno;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentBean other = (StudentBean) obj;
		if (regno != other.regno)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StudentBean [regno=" + regno + ", name=" + name + ", address=" + address + ", marks=" + marks
				+ ", gender=" + gender + "]";
	}
	
}

package com.xml.mapping.table;

public class Person {
	private int id;
	private String address;
	public Person(int id, String address) {
		super();
		this.id = id;
		this.address = address;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}

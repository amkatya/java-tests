package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String homephone;
	public String mobilephone;
	public String workphone;
	public String email1;
	public String emaill2;
	public String bday;
	public String bmonth;
	public String byear;
	public String secondaryaddress;
	public String secondaryphone;

	public ContactData() {	
	}
	public ContactData(String firstname, String lastname, String address,
			String homephone, String mobilephone, String workphone,
			String email1, String emaill2, String bday, String bmonth,
			String byear, String secondaryaddress, String secondaryphone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.homephone = homephone;
		this.mobilephone = mobilephone;
		this.workphone = workphone;
		this.email1 = email1;
		this.emaill2 = emaill2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.secondaryaddress = secondaryaddress;
		this.secondaryphone = secondaryphone;
	}
}
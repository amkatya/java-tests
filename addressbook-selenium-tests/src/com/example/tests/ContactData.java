package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstname;
	private String lastname;
	private String address;
	private String homephone;
	private String mobilephone;
	private String workphone;
	private String email1;
	private String emaill2;
	private String bday;
	private String bmonth;
	private String byear;
	private String secondaryaddress;
	private String secondaryphone;
	private int i;


	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getAddress() {
		return address;
	}
	public String getHomephone() {
		return homephone;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public String getWorkphone() {
		return workphone;
	}
	public String getEmail1() {
		return email1;
	}
	public String getEmaill2() {
		return emaill2;
	}
	public String getBday() {
		return bday;
	}
	public String getBmonth() {
		return bmonth;
	}
	public String getByear() {
		return byear;
	}
	public String getSecondaryaddress() {
		return secondaryaddress;
	}
	public String getSecondaryphone() {
		return secondaryphone;
	}
	public int getI() {
		return i;
	}
	
	public String randomDay() {
		return bday;
	}
	
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
	
	@Override
	public String toString() {
		return "ContactData [lastname=" + lastname + "]";
	}
	
	//Override
	//ublic String toString() {
	//return "ContactData [firstname=" + firstname + ", lastname=" + lastname
	//		+ ", address=" + address + ", homephone=" + homephone
	//		+ ", mobilephone=" + mobilephone + ", workphone=" + workphone
	//		+ ", email1=" + email1 + ", emaill2=" + emaill2 + ", bday="
	//		+ bday + ", bmonth=" + bmonth + ", byear=" + byear
	//		+ ", secondaryaddress=" + secondaryaddress
	//		+ ", secondaryphone=" + secondaryphone + "]";
	//
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//		result = prime * result
				//+ ((firstname == null) ? 0 : firstname.hashCode());
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
		ContactData other = (ContactData) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}
	
	//@Override
	public int compareTo(ContactData other) {
		return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
	}
	
	public ContactData withFirstname(String firstname) {	
		this.firstname = firstname;
		return this;
	}
	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}
	public ContactData withHomephone(String homephone) {
		this.homephone = homephone;
		return this;
	}
	public ContactData withMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
		return this;
	}
	public ContactData withWorkphone(String workphone) {
		this.workphone = workphone;
		return this;
	}
	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}
	public ContactData withEmail2(String email2) {
		emaill2 = email2;
		return this;
	}
	public ContactData withBday(int i) {
		this.i = 5;
		return this;
	}
	public ContactData withBmonth(String bmonth) {
		this.bmonth = "May";
		return this;
	}
	public ContactData withByear(int i) {
		this.i = 1985;
		return this;
	}
	public ContactData withSecondaryaddress(String secondaryaddress) {
		this.secondaryaddress = secondaryaddress;
		return this;
	}
	public ContactData withSecondaryphone(String secondaryphone) {
		this.secondaryphone = secondaryphone;
		return this;
	}
}
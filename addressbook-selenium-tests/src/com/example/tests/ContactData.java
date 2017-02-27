package com.example.tests;

public class ContactData implements Comparable<ContactData> {
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
	
	
}
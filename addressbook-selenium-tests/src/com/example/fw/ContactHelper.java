package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
	    click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"),contact.firstname);
	    type(By.name("lastname"),contact.lastname);
	    type(By.name("address"),contact.address);
	    type(By.name("home"),contact.homephone);
	    type(By.name("mobile"),contact.mobilephone);
	    type(By.name("work"),contact.workphone);
	    type(By.name("email"),contact.email1);
	    type(By.name("email2"),contact.emaill2);
	    selectByText(By.name("bday"), contact.bday);
	    selectByText(By.name("bmonth"), contact.bmonth);
	    type(By.name("byear"),contact.byear);
	    type(By.name("address2"),contact.secondaryaddress);
	    type(By.name("phone2"),contact.secondaryphone);
	}

	

	public void submitContactCreation() {
		driver.findElement(By.name("submit")).click();
	}

	public void returnToHomePage() {
		driver.findElement(By.linkText("home page")).click();
	}

}

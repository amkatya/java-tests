package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	
	public void submitContactModification() {
		click(By.xpath("(//input[@name='update'])[1]"));		
	}
	
		
	public void editContactById(int id) {
		//add ()
		click(By.xpath("(//img[@alt='Edit'])[" + (id+1) + "]"));
	}

	public void deleteContact(int id) {
		editContactById(id);
		click(By.xpath("(//input[@name='update'])[2]"));
		}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			String title = checkbox.getAttribute("title");
			contact.firstname = title.substring("Select (".length(), title.length() - ")".length());
			contacts.add(contact);
		}
		return contacts;
	}
	
	//img[@alt='Edit']
	//xpath=(//img[@alt='Edit'])[7]
	//img[@alt='Edit[]'][7]
	
	//https://addons.mozilla.org/en-us/firefox/addon/element-locator-for-webdriv/
	//http://learn-automation.com/how-to-write-dynamic-xpath-in-selenium/
	
}

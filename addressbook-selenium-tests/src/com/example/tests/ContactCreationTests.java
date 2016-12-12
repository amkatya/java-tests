
package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++){
			ContactData contact = new ContactData();
			contact.firstname = generatorRandomString();	
		    contact.lastname = generatorRandomString();
		    contact.address = generatorRandomString();
		    contact.homephone = generatorRandomString();
		    contact.mobilephone = generatorRandomString();
		    contact.workphone = generatorRandomString();
		    contact.email1 = "";
		    contact.emaill2 = "";
		    contact.bday = "5";
		    contact.bmonth = "May";
		    contact.byear = "1985";
		    contact.secondaryaddress = generatorRandomString();
		    contact.secondaryphone = generatorRandomString();
		    list.add(new Object[] {contact});
		}
		return list.iterator();
	}
	
	public String generatorRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(10) == 0) {
			return "";
		} else {
			return "contact" + rnd.nextInt();
		}
	}
	
	
	
  @Test (dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	
	  
	app.getNavigationHelper().openMainPage();
	
	// save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    // actions 
	app.getContactHelper().initContactCreation();	
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states  
    //assertEquals(newList.size(), oldList.size() + 1);
    
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }
}
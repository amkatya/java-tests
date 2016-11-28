
package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	
	  
	app.getNavigationHelper().openMainPage();
	// save old state
    List<ContactData> oldList =  app.getContactHelper().getContacts();
    
    // actions 
	app.getContactHelper().initContactCreation();	
	ContactData contact = new ContactData();
    contact.firstname = "firstname";
    contact.lastname = "lastname";
    contact.address = "address";
    contact.homephone = "1234";
    contact.mobilephone = "4567";
    contact.workphone = "4321";
    contact.email1 = "email@mail.com";
    contact.emaill2 = "email2@mail.com";
    contact.bday = "4";
    contact.bmonth = "May";
    contact.byear = "1995";
    contact.secondaryaddress = "secondary address";
    contact.secondaryphone = "secondary phone";
    
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    
    // save new state
    List<ContactData> newList =  app.getContactHelper().getContacts();
    
    // compare states  
    assertEquals(newList.size(), oldList.size() + 1);
    
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
  //@Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", ""));
    //áûëî: app, this, ÏÅÐÅÄ new ContactData
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}

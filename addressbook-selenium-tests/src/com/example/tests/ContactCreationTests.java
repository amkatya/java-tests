
package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	
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
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", ""));
    //app, this, оепед new ContactData
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}

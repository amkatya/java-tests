
package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.navigationHelper.openMainPage();
    app.contactHelper.initContactCreation();
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
    
	app.contactHelper.fillContactForm(app, this, contact);
    app.contactHelper.submitContactCreation();
    app.contactHelper.returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	app.navigationHelper.openMainPage();
    app.contactHelper.initContactCreation();
    app.contactHelper.fillContactForm(app, this, new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", ""));
    app.contactHelper.submitContactCreation();
    app.contactHelper.returnToHomePage();
  }
}

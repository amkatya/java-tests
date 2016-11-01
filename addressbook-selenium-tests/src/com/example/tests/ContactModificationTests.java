package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		//icon "edit" contact
		// не верно app.getContactHelper().editContactByIndex(7);
		ContactData contact = new ContactData();
		contact.firstname = "new firstname";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
	}

}

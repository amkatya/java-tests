package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		//icon "edit" contact
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
	}
}

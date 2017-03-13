package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	
	public void deleteSomeContact() {
		
		app.navigateTo().mainPage();
		
		// save old state
		List<ContactData> oldList =  app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int id = rnd.nextInt(oldList.size()-1);
	    
	    // actions   
		app.getContactHelper().deleteContact(id);
		app.getContactHelper().returnToHomePage();
		
		 // save new state
		List<ContactData> newList =  app.getContactHelper().getContacts();
	    
	    
	    // compare states  
		oldList.remove(id);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
}

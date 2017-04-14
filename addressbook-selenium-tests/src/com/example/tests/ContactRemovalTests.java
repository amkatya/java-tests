package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {

	@Test
	
	public void deleteSomeContact() {
		
		//app.navigateTo().mainPage();
		
		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int id = rnd.nextInt(oldList.size()-1);
	    
	    // actions   
		app.getContactHelper().deleteContact(id);
		
		 // save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
	    
	    // compare states
		assertThat(newList, equalTo(oldList.without(id)));
	}
	//	oldList.remove(id);
	//    Collections.sort(oldList);
	//    Collections.sort(newList);
	//    assertEquals(newList, oldList);
	//}
}

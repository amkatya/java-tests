package com.example.tests;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;


import static com.example.fw.ContactHelper.MODIFICATION;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	
	public void modifySomeContact(ContactData contact) {
		
		
		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int id = rnd.nextInt(oldList.size()-1);
	    
	    // actions 
	    app.getContactHelper().modifyContact(id, contact);
	
		
		// save new state
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
	    // compare states
	    assertThat(newList, equalTo(oldList.without(id).withAdded(contact)));	
	   	}
	
	//    oldList.remove(id);
	//    oldList.add(contact);
	//    Collections.sort(oldList);
	//    Collections.sort(newList);
	//    assertEquals(newList, oldList);
	//}

}

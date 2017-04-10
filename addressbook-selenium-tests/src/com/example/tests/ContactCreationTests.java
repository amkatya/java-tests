
package com.example.tests;

import static com.example.fw.ContactHelper.CREATION;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {
	
	
  @Test (dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	
	  
	//app.navigateTo().mainPage();
	
	// save old state
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
    
    // actions //lesson 4, ~18min
	app.getContactHelper().createContact(contact);
	
    
    // save new state
    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states  
    assertThat(newList, equalTo(oldList.withAdded(contact)));
  }
}
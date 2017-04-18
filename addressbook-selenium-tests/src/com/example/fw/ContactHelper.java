package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {

	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cachedContacts;	
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null){
			rebuildCache();
		}
		return cachedContacts;
	}
	//lesson 3 - 12min; lesson 4 - 
	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String firstname = title.substring("Select (".length(), title.length() - ")".length());
			cachedContacts.add(new ContactData().withFirstname(firstname)); 
		}
	}
	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		initContactCreation();
		fillContactForm(contact, CREATION);
		submitContactCreation();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper modifyContact(int id, ContactData contact) {
		manager.navigateTo().mainPage();
		editContactById(id);
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper deleteContact(int id) {
		manager.navigateTo().mainPage();
		submitContactDeletion(id);
		returnToHomePage();
		rebuildCache();
		return this;
		}


	//-------------------------------------------------------------------------------------
	
	public ContactHelper initContactCreation() {
	    click(By.linkText("add new"));
	    return this;
	}

	//lesson 4, ~18min
	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"),contact.getFirstname());
	    type(By.name("lastname"),contact.getLastname());
	    type(By.name("address"),contact.getAddress());
	    type(By.name("home"),contact.getHomephone());
	    type(By.name("mobile"),contact.getMobilephone());
	    type(By.name("work"),contact.getWorkphone());
	    type(By.name("email"),contact.getEmail1());
	    type(By.name("email2"),contact.getEmaill2());
	    selectByText(By.name("bday"), contact.getBday());
	    selectByText(By.name("bmonth"), contact.getBmonth());
	    type(By.name("byear"),contact.getByear());
	    if (formType == CREATION){
	    	//selectByText(By.name("new_group")), "group 1");
	    } else {
	    	if (driver.findElements(By.name("new_group")).size() !=0) {
	    		throw new Error("Group selector exists in contact modification form");
	    	}
	    }
	    type(By.name("address2"),contact.getSecondaryaddress());
	    type(By.name("phone2"),contact.getSecondaryphone());
	    return this;
	}

	public ContactHelper submitContactCreation() {
		driver.findElement(By.name("submit")).click();
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToHomePage() {
		driver.findElement(By.linkText("home page")).click();
		return this;
	}
	
	public ContactHelper submitContactModification() {
		click(By.xpath("(//input[@name='update'])[1]"));
		cachedContacts = null;
		return this;
	}
	public ContactHelper submitContactDeletion(int id) {
		editContactById(id);
		click(By.xpath("(//input[@name='update'])[2]"));
		cachedContacts = null;
		return this;
	}
		
	public ContactHelper editContactById(int id) {
		//add ()
		click(By.xpath("(//img[@alt='Edit'])[" + (id+1) + "]"));
		return this;
	}


	//-----------------------------------------------------------------------------------------------------------------


	
	
	

	
	
	//----------------------------
	
	//public List<ContactData> getContacts() {
	//	List<ContactData> contacts = new ArrayList<ContactData>();
	//	List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
	//	for (WebElement checkbox : checkboxes) {
	//		ContactData contact = new ContactData();
	//		String title = checkbox.getAttribute("title");
	//		contact.firstname = title.substring("Select (".length(), title.length() - ")".length());
	//		contacts.add(contact);
	//	}
	//	return contacts;
	//}
	
}

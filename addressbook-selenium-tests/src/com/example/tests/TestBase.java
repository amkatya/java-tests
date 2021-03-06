package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;
	private String name;

		@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	}
		
		@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}
		
		@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i =0; i < 5; i++){
			GroupData group = new GroupData()
			.withName(generateRandomString())
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
			list.add(new Object[]{group});
			}
			return list.iterator();
		}		


	public String generateRandomString() {
		Random rnd = new Random();
		if(rnd.nextInt(3) == 0){
			return "";
		} else {
			return "test" + rnd.nextInt();
			}	
		}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++){
			ContactData contact = new ContactData()
			.withFirstname(generatorRandomString())
			.withLastname(generatorRandomString())
			.withAddress(generatorRandomString())
			.withHomephone(generatorRandomString())
			.withMobilephone(generatorRandomString())
			.withWorkphone(generatorRandomString())
			.withEmail1(generatorRandomString())
			.withEmail2(generatorRandomString())
			.withBday(generateRandomNumber())
			.withBmonth(generateRandomBmonth()))
			.withByear(generateRandomNumber())
			.withSecondaryaddress(generatorRandomString())
			.withSecondaryphone(generatorRandomString());
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	//@DataProvider
	//public Iterator<Object[]> randomValidContactGenerator() {
	//	List<Object[]> list = new ArrayList<Object[]>();
	//	for (int i = 0; i < 5; i++){
	//		ContactData contact = new ContactData();
	//		contact.firstname = generatorRandomString();	
	//		contact.lastname = generatorRandomString();
	//		contact.address = generatorRandomString();
	//		contact.homephone = generatorRandomString();
	//		contact.mobilephone = generatorRandomString();
	//		contact.workphone = generatorRandomString();
	//		contact.email1 = "";
	//		contact.emaill2 = "";
	//		contact.bday = "5";
	//		contact.bmonth = "May";
	//		contact.byear = "1985";
	//		contact.secondaryaddress = generatorRandomString();
	//		contact.secondaryphone = generatorRandomString();
	//		list.add(new Object[]{contact});
	//	}
	//	return list.iterator();
	//}



	private int generateRandomNumber() {
		Random rnd = new Random();
		
		return 0;
	}

	public String generatorRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(10) == 0) {
			return "";
		} else {
			return "contact" + rnd.nextInt();
		}
	}
	}

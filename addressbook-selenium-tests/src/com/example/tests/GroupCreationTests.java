package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.fw.GroupHelper;

public class GroupCreationTests extends TestBase {
	
	
	
	@Test(dataProvider = "randomValidGroupGenerator")
  	public void testGroupCreationWithValidData(GroupData group) throws Exception {
		
	
	app.navigateTo().mainPage();
    app.navigateTo().groupsPage();
    
    // save old state
    GroupHelper groupHelper = app.getGroupHelper();
	List<GroupData> oldList = groupHelper.getGroups();
    
    //// actions    
    //groupHelper.initGroupCreation();
	//groupHelper.fillGroupForm(group);
    //groupHelper.submitGroupCreation();
    //groupHelper.returnToGroupsPage();
    //
	
    // actions //lesson4 ~13min
    app.getGroupHelper()
    .initGroupCreation()
	.fillGroupForm(group)
    .submitGroupCreation()
    .returnToGroupsPage();
    
    // save new state
    List<GroupData> newList = groupHelper.getGroups();
    
    // compare states  
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
}

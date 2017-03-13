package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.fw.GroupHelper;

public class GroupCreationTests extends TestBase {
	
	
	
	
	@Test(dataProvider = "randomValidGroupGenerator")
  	public void testGroupCreationWithValidData(GroupData group) throws Exception {
    
    // save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
	
    // actions //lesson4: ~13min, ~28min
    app.getGroupHelper().createGroup(group);
    
    
    // save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    // compare states  
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
}

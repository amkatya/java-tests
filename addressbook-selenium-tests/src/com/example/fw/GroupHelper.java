package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	//public void initGroupCreation() {
	//	click(By.name("new"));
	//}
	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	//public void fillGroupForm(GroupData group) {
	//    type(By.name("group_name"), group.getName());
	//    type(By.name("group_header"), group.getHeader());
	//    type(By.name("group_footer"), group.getFooter());
	//}
	public GroupHelper fillGroupForm(GroupData group) {
	    type(By.name("group_name"), group.getName());
	    type(By.name("group_header"), group.getHeader());
	    type(By.name("group_footer"), group.getFooter());
		return this;
		
	}

	//public void submitGroupCreation() {
	//	click(By.name("submit"));
	//}
	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		return this;
		
	}

	//public void deleteGroup(int index) {
	//	selectGroupByIndex(index);
	//	click(By.name("delete"));
	//}
	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
		return this;
		
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}

	//public void initGroupModification(int index) {
	//	selectGroupByIndex(index);
	//	click(By.name("edit"));
	//}
	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	//public void submitGroupModification() {
	//	click(By.name("update"));		
	//}
	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		return this;
	}
	
	public void returntoGroupPage() {
	    click(By.linkText("group page"));
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			group.name = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(group);
		}
		return groups;
	}
	//lesson4:
	//public List<GroupData> getGroups() {
	//	List<GroupData> groups = new ArrayList<GroupData>();
	//	List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
	//	for (WebElement checkbox : checkboxes) {
	//		String title = checkbox.getAttribute("title");
	//		String name = title.substring("Select (".length(), title.length() - ")".length());
	//		GroupData group = new GroupData().withName(name);
	//		groups.add(group); CLICK ON "group" > CTRL+1 > Inline local variable
	//	}
	//	return groups;
	//}
	

}

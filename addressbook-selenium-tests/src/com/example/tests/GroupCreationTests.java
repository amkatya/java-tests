package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.openMainPage();
    app.gotoGroupsPage();
    app.initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name 1";
    group.header = "header 1";
    group.footer = "footer 1";
	app.fillGroupForm(this, group);
    app.submitGroupCreation();
    app.gotoGroupsPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.openMainPage();
    app.gotoGroupsPage();
    app.initGroupCreation();
    app.fillGroupForm(this, new GroupData("", "", ""));
    app.submitGroupCreation();
    app.gotoGroupsPage();
  }
}
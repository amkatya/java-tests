package com.example.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public abstract class HelperBase {
	
	protected ApplicationManager manager;
	protected WebDriver driver;
	public boolean acceptNextAlert = true;
	

	public HelperBase(ApplicationManager manager){
		this.manager = manager;
		this.driver = manager.driver;
	}
	
	public boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	}
	
	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      //String alertText = alert.getText();
	      //����� ������ ��� String alertText = alert.getText()
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alert.getText();
	      //� �����: return alert.getText();
	      //� ����: return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	 }
}

package com.w2a.testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.Testbase;

public class BankManagerLogintest extends Testbase {
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		log.debug("Inside login test");
		driver.findElement(By.cssSelector(OR.getProperty("bml"))).click();
		
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))),"login not successful");
		Thread.sleep(3000);
		
		log.debug("Login Successfully Executed");
	}

}

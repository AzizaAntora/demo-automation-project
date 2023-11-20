package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.CommonDataSetup;
import dataProvider.DataProviderTest;

@Test(groups="regression")
public class SignupTest extends CommonDataSetup {
	@Test(priority=6, description="Click 'Register / Login' button")
	public void clickRegisterLoginButtonTest () {
		driver.findElement(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u")).click();
		Assert.assertTrue(true);
	}
	
	@Test(priority=7, description="Fill all details in Sign up and create account", dataProvider="signup", dataProviderClass=DataProviderTest.class)
	public void signUpTest (String first_name, String last_name, String email) {
		driver.findElement(By.name("name")).sendKeys(first_name + " " + last_name);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"))
				.sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
		Assert.assertTrue(true);
	}
	
	@Test(priority=8, description="Fill all account information", dataProvider="account", dataProviderClass=DataProviderTest.class)
	public void fillUpAccountInformationTest (String password, String days, String months, String years, String first_name, String last_name, String company, String address1, String address2, String country, String state, String city, String zipcode, String mobile_number) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Enter Account Information')]")));
		
		// Account Information
		driver.findElement(By.id("id_gender2")).click();
		driver.findElement(By.id("password")).sendKeys(password);
		
		Select day = new Select(driver.findElement(By.id("days")));
		day.selectByValue(days);
		Select month = new Select(driver.findElement(By.id("months")));
		month.selectByValue(months);
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByValue(years);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newsletter")));
		WebElement checkbox = driver.findElement(By.id("newsletter"));
		checkbox.click();
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"optin\"]"));
		checkbox1.click();
		
		// Address Information
		driver.findElement(By.id("first_name")).sendKeys(first_name);
		driver.findElement(By.id("last_name")).sendKeys(last_name);
		driver.findElement(By.id("company")).sendKeys(company);
		driver.findElement(By.id("address1")).sendKeys(address1);
		driver.findElement(By.id("address2")).sendKeys(address2);
		
		Select countryEl = new Select(driver.findElement(By.id("country")));
		countryEl.selectByValue(country);
		
		driver.findElement(By.id("state")).sendKeys(state);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("zipcode")).sendKeys(zipcode);
		driver.findElement(By.id("mobile_number")).sendKeys(mobile_number);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
		
		Assert.assertTrue(true);
	}
	
	@Test(priority=9, description="Verify 'ACCOUNT CREATED!' and click 'Continue' button")
	public void verifyAccountCreatedTest () {
		String expectedTitle = "Automation Exercise - Account Created";
		String title = driver.getTitle();
		
		Assert.assertEquals(title, expectedTitle);
		
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
	}
	
	@Test(priority=10, description="Verify ' Logged in as username' at top", dataProvider="signup", dataProviderClass=DataProviderTest.class)
	public void verifyLoggedInUserTest (String first_name, String last_name, String email) {
		String username = first_name +" "+ last_name;
		WebElement loggedInUser = driver.findElement(By.xpath("//*[text()='"+username+"']"));
		Assert.assertEquals(loggedInUser.getText(), username);
	}
	
	@Test(priority=11, description="Click 'Cart' button and 'Proceed To Checkout' button")
	public void clickCartAndProceedToCheckoutButtonTest () {
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();
		Assert.assertTrue(true);
	}
}

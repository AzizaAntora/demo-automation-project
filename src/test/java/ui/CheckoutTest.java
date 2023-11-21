package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.CommonDataSetup;
import dataProvider.DataProviderTest;

@Test(groups="regression")
public class CheckoutTest extends CommonDataSetup {

	
	@Test(priority=12, description="Verify Address Details and Review Your Order", dataProvider="account", dataProviderClass=DataProviderTest.class)
	public void verifyAddressReviewOrderTest (String password, String days, String months, String years, String first_name, String last_name, String company, String address1, String address2, String country, String state, String city, String zipcode, String mobile_number) {
		// Wait for Address Details page 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cart_items\"]/div/div[2]/h2")));
		
		// Verify Delivery Address
		String addressFullName = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[2]")).getText();
		String testFullName = "Mrs. " + first_name + " " + last_name;		
		Assert.assertEquals(addressFullName, testFullName);
		
		String addressCityStatePostCode = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[6]")).getText();
		String testCityStatePostCode = city + " " + state + " " + zipcode;
		Assert.assertEquals(addressCityStatePostCode, testCityStatePostCode);
		
		String addressCountry = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[7]")).getText();
		String testCountry = country;
		Assert.assertEquals(addressCountry, testCountry);
		
		String addressMobile = driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[8]")).getText();
		String testMobile = mobile_number;
		Assert.assertEquals(addressMobile, testMobile);
		
		// Verify Product 1,2 added in the Order
		boolean product1 = driver.findElement(By.xpath("//*[@id=\"product-1\"]")).isDisplayed();
		if (!product1) Assert.assertTrue(false);
		boolean product2 = driver.findElement(By.xpath("//*[@id=\"product-2\"]")).isDisplayed();
		if (!product2) Assert.assertTrue(false);
		
	}
	
	@Test(priority=13, description=" Enter description in comment text area and click 'Place Order'")
	public void placeOrderTest () {
		driver.findElement(By.name("message")).sendKeys("Test message");
		driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a")).click();
		Assert.assertTrue(true);
	}
	
	@Test(priority=14, description="Enter payment details: Name on Card, Card Number, CVC, Expiration date", dataProvider="payment", dataProviderClass=DataProviderTest.class)
	public void signUpTest (String name, String card_number, String cvc, String expiry_month, String expiry_year) {
		driver.findElement(By.name("name_on_card")).sendKeys(name);
		driver.findElement(By.name("card_number")).sendKeys(card_number);
		driver.findElement(By.name("cvc")).sendKeys(cvc);
		driver.findElement(By.name("expiry_month")).sendKeys(expiry_month);
		driver.findElement(By.name("expiry_year")).sendKeys(expiry_year);
		
		driver.findElement(By.id("submit")).click();
		Assert.assertTrue(true);
	}
	
	@Test(priority=15, description="Verify 'Verify the success message 'Your order has been placed successfully!'")
	public void verifyOrderPlacedTest () {
		String successMessage = "Congratulations! Your order has been confirmed!";
		WebElement successMessageEl = driver.findElement(By.xpath("//*[text()='"+successMessage+"']"));
		Assert.assertEquals(successMessageEl.getText(), successMessage);
		
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
	}
}

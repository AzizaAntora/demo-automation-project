package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.CommonDataSetup;
import dataProvider.DataProviderTest;

@Test(groups="regression")
public class CheckoutTest extends CommonDataSetup {

	
	@Test(priority=12, description="Verify Address Details and Review Your Order")
	public void verifyAddressReviewOrderTest () {
		// TODO 
		Assert.assertTrue(true);
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

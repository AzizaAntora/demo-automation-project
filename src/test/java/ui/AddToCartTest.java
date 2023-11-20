package ui;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.CommonDataSetup;

@Test(groups="regression")
public class AddToCartTest extends CommonDataSetup {
	
	@Test(priority=2, description="Add products to cart")
	public void addProductsToCartTest () {
		int productIds[] = {1, 2};
		for(int i=0;i<productIds.length;i++) {
			// Click add to cart
			driver.findElement(By.xpath("//a[@data-product-id='" + productIds[i] + "']")).click();
			
			// Click Continue Shopping
			driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button")).click();  
		}
		
		Assert.assertTrue(true);
	}
	
	@Test(priority=3, description="Click 'Cart' button")
	public void clickCartButtonTest () {
		// Click add to cart
		driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
		Assert.assertTrue(true);
	}
	
	@Test(priority=4, description="Verify that cart page is displayed")
	public void verifyCartPageTest () {
		String expectedTitle = "Automation Exercise - Checkout";
		String title = driver.getTitle();
		
		Assert.assertEquals(title, expectedTitle);
	}
	
	@Test(priority=5, description="Click Proceed To Checkout")
	public void clickProceedToCheckoutTest () {
		// Click add to cart
		driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();
		Assert.assertTrue(true);
	}
	
}

package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import common.CommonDataSetup;

@Test(groups="regression")
public class HomePageTest extends CommonDataSetup {
	
	@Test(priority=1, description="Verify that home page is visible successfully")
	public void verifyHomepageTest () {
		String expectedTitle = "Automation Exercise";
		String title = driver.getTitle();
		
		Assert.assertEquals(title, expectedTitle);
	}
}

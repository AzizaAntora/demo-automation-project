package ui;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dataProvider.ConfigFileReader;
import dataProvider.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAutomation {
	WebDriver driver;
	ConfigFileReader configFileReader;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		ConfigFileReader configFileReader= new ConfigFileReader();
		TestData testData = new TestData();
		

		String email = String.format("%s@%s", getUniqueId(), "gmail.com");
		
		String url = configFileReader.getApplicationUrl();
		System.out.println("url: " + url);
	
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		

		System.out.println(driver.getTitle());

		String expectedTitle = "Automation Exercise";
		String title = driver.getTitle();
		if (title.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Title Matched");
		} else {
			System.out.println("Not a match");
		}

		driver.findElement(By.xpath("/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a"))
				.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button")).click();

		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")).click();

		System.out.println(driver.getTitle());

		String expectedTitle1 = "Automation Exercise - Checkout";
		String title1 = driver.getTitle();
		if (title1.equalsIgnoreCase(expectedTitle1)) {
			System.out.println("Title Matched");
		} else {
			System.out.println("Not a match");
		}

		driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u")).click();

		driver.findElement(By.name("name")).sendKeys(testData.name);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"))
				.sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();

		driver.findElement(By.id("id_gender2")).click();
		driver.findElement(By.id("password")).sendKeys(testData.password);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Select day = new Select(driver.findElement(By.id("days")));
		day.selectByValue(testData.days);
		Select month = new Select(driver.findElement(By.id("months")));
		month.selectByValue(testData.months);
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByValue(testData.years);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement checkbox = driver.findElement(By.id("newsletter"));
		checkbox.click();
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"optin\"]"));
		checkbox1.click();

		driver.findElement(By.id("first_name")).sendKeys(testData.first_name);
		driver.findElement(By.id("last_name")).sendKeys(testData.last_name);
		driver.findElement(By.id("company")).sendKeys(testData.company);
		driver.findElement(By.id("address1")).sendKeys(testData.address1);
		driver.findElement(By.id("address2")).sendKeys(testData.address2);

		//driver.findElement(By.id("country")).click();
		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByValue(testData.country);
		
		driver.findElement(By.id("state")).sendKeys(testData.state);
		driver.findElement(By.id("city")).sendKeys(testData.city);
		driver.findElement(By.id("zipcode")).sendKeys(testData.zipcode);
		driver.findElement(By.id("mobile_number")).sendKeys(testData.mobile_number);

		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
		
		
		System.out.println(driver.getTitle());

		String expectedTitle2 = "Automation Exercise - Account Created";
		String title2 = driver.getTitle();
		if (title2.equalsIgnoreCase(expectedTitle2)) {
			System.out.println("Title Matched");
		} else {
			System.out.println("Not a match");
		}
		
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement loggedInUser = driver.findElement(By.xpath("//*[text()='"+testData.username+"']"));
		
		if (loggedInUser.getText().equalsIgnoreCase(testData.username)){
			System.out.println("Logged in User Matched");
		} else {
			System.out.println("Logged in User Not Matched");
		}
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();
		
		
		
		
		driver.findElement(By.name("message")).sendKeys(testData.message);
		driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a")).click();
		
		
		
		driver.findElement(By.name("name_on_card")).sendKeys(testData.name);
		driver.findElement(By.name("card_number")).sendKeys(testData.card_number);
		driver.findElement(By.name("cvc")).sendKeys(testData.cvc);
		driver.findElement(By.name("expiry_month")).sendKeys(testData.expiry_month);
		driver.findElement(By.name("expiry_year")).sendKeys(testData.expiry_year);
		
		driver.findElement(By.id("submit")).click();
		
		
		WebElement successMessage = driver.findElement(By.xpath("//*[text()='Congratulations! Your order has been confirmed!']"));
		
		if (successMessage.getText().equalsIgnoreCase("Congratulations! Your order has been confirmed!")){
			System.out.println("Order has been placed successfully");
		} else {
			System.out.println("Unable to place order");
		}
		

		driver.close();
		driver.quit();

	}

	public static String getUniqueId() {
        return String.format("%s_%s", UUID.randomUUID().toString().substring(0, 5), System.currentTimeMillis() / 1000);
    }
}

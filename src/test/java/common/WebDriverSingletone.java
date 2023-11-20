package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverSingletone {
	public static WebDriver driver;
	protected static ConfigFileReader configFileReader;

   public static WebDriver getInstance() {
     if (driver == null) {
    	 configFileReader= new ConfigFileReader();
 		String url = configFileReader.getApplicationUrl();
 		
 		WebDriverManager.chromedriver().setup();
 		driver = new ChromeDriver();
 		driver.get(url);
 		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
     }
     
     return driver;
   }
}

package dataProvider;

import java.util.UUID;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
	
	@DataProvider(name="signup")
	public Object[][] datasetSignUp()
	{
		return new Object[][]
				{
					{"Test", "User", String.format("testuser%s@%s", getUniqueId(), "gmail.com")}
				};
	}
	
	@DataProvider(name="account")
	public Object[][] datasetAccountInfo()
	{
		return new Object[][]
				{
					{"abcd1234", "3", "11", "1990", "Test", "User", "Google", "Toronto", "Road 11", "Canada", "Toronto", "New City", "1200", "02135489"}
				};
	}
	
	@DataProvider(name="payment")
	public Object[][] datasetPayment()
	{
		return new Object[][]
				{
					{"Test User", "0000000000000000", "1234", "01", "2026"}
				};
	}
	
	public static String getUniqueId() {
        return String.format("%s_%s", UUID.randomUUID().toString().substring(0, 5), System.currentTimeMillis() / 1000);
    }
}

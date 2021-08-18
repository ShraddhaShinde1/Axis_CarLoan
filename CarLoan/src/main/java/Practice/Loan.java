package Practice;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class Loan {
	
	public static WebDriver driver = null;
	
	
	
	@And("^I navigate to Axis Bank website$")	
	public WebDriver NavigateURL() throws InterruptedException

	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\YUVARAJ\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		ChromeOptions options  = new ChromeOptions();
	    
	    options.addArguments("--disable-notifications");

		 
		 driver= new ChromeDriver(options);
		driver.get("https://www.axisbank.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//WebElement closepop = driver.findElement(By.xpath("//*[@id=\'screen_takeover\']/div/span"));
		if (driver.findElement(By.xpath("//*[@id=\'screen_takeover\']/div/span")).isEnabled())
		{
			driver.findElement(By.xpath("//*[@id=\'screen_takeover\']/div/span")).click();
		}
		
		return driver;

	}

    
}

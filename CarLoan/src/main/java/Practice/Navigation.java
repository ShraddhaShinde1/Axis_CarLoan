package Practice;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class Navigation extends Loan{
	
	Loan l = new Loan();
	public WebDriver driver;

	
	 
    @And("^I click on the Apply Now link$")
   
   public WebDriver ApplyNow() throws InterruptedException 
   
   {
		Thread.sleep(3000);
		
		driver=l.NavigateURL(); 
		//driver.close();
		driver.findElement(By.linkText("Apply Now")).click();
		String URL=driver.getCurrentUrl();
		System.out.println(URL);
		return driver;
		
   }
	
	

}

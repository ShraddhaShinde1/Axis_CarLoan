package Practice;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class Demo {
	

	public static WebDriver driver;
	//@Test(priority=1)
	
	@Given("^that I am a new user to Axis Bank$")
	public void New_User()
	{
		System.out.println("that I am a new user to Axis Bank");
	}
	@And("^I navigate to Axis Bank website$")	
	public void NavigateURL() throws InterruptedException
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

		
	}
	
	//@Test(priority=2)
	@And("^I click on the Apply Now link$")
	 public void ApplyNow() throws InterruptedException 
	   
	   {
			Thread.sleep(3000);
			driver.findElement(By.linkText("Apply Now")).click();
			//String URL=driver.getCurrentUrl();
			//System.out.println(URL);
			
			
	   }
	//@Test(priority=3)
	@And("^I select the Car loan option$")
public void CarLoan() throws InterruptedException
	
	{
		Thread.sleep(3000);
		
		
		driver.findElement(By.linkText("Car Loans")).click();
		
		}

	
	 //@Test(priority=4)
	@And("^I navigate to the Car Laon application page$")
		public void ValidationURL()
		{
			//String URL = d.getCurrentUrl();
			Boolean verifyTitle= driver.getCurrentUrl().contains("carloan");
			//System.out.print(verifyTitle);
			Assert.assertTrue(verifyTitle, "Verified");
		}

	 // @Test(priority=5)
	@And("^I enter all the required details$")
		public void FillCarLoanDeatils() throws InterruptedException, IOException
		{
			Thread.sleep(3000);
			WebElement Exist_Cus= driver.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlexistingcust"));
			Select dropdown = new Select(Exist_Cus);
			dropdown.selectByIndex(2);
			//dropdown.selectByValue("No");
			Thread.sleep(3000);
			driver.findElement(By.id("ContentPlaceHolder1_Genesys1_txtName")).sendKeys("Yuvraj Terse");
			driver.findElement(By.id("ContentPlaceHolder1_Genesys1_txtMobile")).sendKeys("9825871585");
			driver.findElement(By.id("ContentPlaceHolder1_Genesys1_txtEmail")).sendKeys("yuvraj.terse@gmail.com");
			
			Select dropdownState = new Select(driver.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlState")));
			dropdownState.selectByValue("Maharashtra");
			
			Thread.sleep(3000);
			Select dropdownCity = new Select(driver.findElement(By.xpath("//div[@id='ContentPlaceHolder1_Genesys1_upCarlOan']/div[2]/div[3]/select")));
			//dropdownCity.selectByValue("Mumbai");
			dropdownCity.selectByVisibleText("Ahmednagar");
			
			Select dropdownEmpType = new Select(driver.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlempType")));
			//dropdownEmpType.selectByValue("Salaried");
			dropdownEmpType.selectByIndex(2);
			
			Thread.sleep(5000);
			Select dropdownSalRange = new Select(driver.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlSalary")));
			dropdownSalRange.selectByValue("LessThan");
			
			Thread.sleep(5000);
			Select dropdownExistLoan = new Select(driver.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlextingcarLoan")));
			dropdownExistLoan.selectByValue("Yes");
			
			driver.findElement(By.id("ContentPlaceHolder1_Genesys1_txtLoanamtrequired")).sendKeys("200000");
			
			driver.findElement(By.id("ContentPlaceHolder1_Genesys1_chkDisclaimer1")).click();
			
			/*String captcha= d.findElement(By.id("ContentPlaceHolder1_Genesys1_imgCaptcha")).getAttribute("src");
			System.out.println(captcha);
			URL url=new URL(captcha);
			Image image= ImageIO.read(url);
			
			 String imageText = new OCR().recognizeCharacters((RenderedImage) image);
			 System.out.println("Text Image : \n"+ imageText);
			*/


}
	 }

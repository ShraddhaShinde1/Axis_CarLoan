package StepDefinition;

import java.io.File;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

@RunWith(Cucumber.class)
public class Final {

	
	public static WebDriver driver;
	@Given("^that I am a new user to Axis Bank$")
	public void that_I_am_a_new_user_to_Axis_Bank() throws Throwable {
		System.out.println("that I am a new user to Axis Bank");
	}

	@And("^I navigate to Axis Bank website$")
	public void i_navigate_to_Axis_Bank_website() throws Throwable {
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

	@And("^I click on the Apply Now link$")
	public void i_click_on_the_Apply_Now_link() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.linkText("Apply Now")).click();
		
	    
	}

	@And("^I select the Car loan option$")
	public void i_select_the_Car_loan_option() throws Throwable {
        Thread.sleep(2000);			
		driver.findElement(By.linkText("Car Loans")).click();
		
	    
	}

	@And("^I navigate to the Car Laon application page$")
	public void i_navigate_to_the_Car_Laon_application_page() throws Throwable {
		Boolean verifyTitle= driver.getCurrentUrl().contains("carloan");
		//System.out.print(verifyTitle);
		Assert.assertTrue(verifyTitle, "Verified");

	}

	@And("^I enter all the required details$")
	public void i_enter_all_the_required_details() throws Throwable {
		
		Thread.sleep(500);
		WebElement Exist_Cus= driver.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlexistingcust"));
		Select dropdown = new Select(Exist_Cus);
		dropdown.selectByIndex(2);
		//dropdown.selectByValue("No");
		Thread.sleep(500);
		driver.findElement(By.id("ContentPlaceHolder1_Genesys1_txtName")).sendKeys("Yuvraj Terse");
		driver.findElement(By.id("ContentPlaceHolder1_Genesys1_txtMobile")).sendKeys("9825871585");
		driver.findElement(By.id("ContentPlaceHolder1_Genesys1_txtEmail")).sendKeys("yuvraj.terse@gmail.com");
		
		Select dropdownState = new Select(driver.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlState")));
		dropdownState.selectByValue("Maharashtra");
		
		Thread.sleep(500);
		Select dropdownCity = new Select(driver.findElement(By.xpath("//div[@id='ContentPlaceHolder1_Genesys1_upCarlOan']/div[2]/div[3]/select")));
		//dropdownCity.selectByValue("Mumbai");
		dropdownCity.selectByVisibleText("Ahmednagar");
		
		Select dropdownEmpType = new Select(driver.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlempType")));
		//dropdownEmpType.selectByValue("Salaried");
		dropdownEmpType.selectByIndex(2);
		
		Thread.sleep(500);
		Select dropdownSalRange = new Select(driver.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlSalary")));
		dropdownSalRange.selectByValue("LessThan");
		
		Thread.sleep(500);
		Select dropdownExistLoan = new Select(driver.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlextingcarLoan")));
		dropdownExistLoan.selectByValue("Yes");
		
		Thread.sleep(500);
		driver.findElement(By.id("ContentPlaceHolder1_Genesys1_txtLoanamtrequired")).sendKeys("200000");
		
		driver.findElement(By.id("ContentPlaceHolder1_Genesys1_btnrefresh")).click();
		
		WebElement captcha = driver.findElement(By.id("ContentPlaceHolder1_Genesys1_imgCaptcha"));
		File src =captcha.getScreenshotAs(OutputType.FILE);
		
		String path = "C:\\Users\\YUVARAJ\\eclipse-workspace_main\\CarLoan\\CatchaImages\\capcha.png";
		FileHandler.copy(src, new File(path));
		
		//Thread.sleep(2000);
		ITesseract image= new Tesseract();
		String src1 = image.doOCR(new File(path));
		System.out.println(src1);
		driver.findElement(By.id("ContentPlaceHolder1_Genesys1_txtCaptcha")).sendKeys(src1);
		
		driver.findElement(By.id("ContentPlaceHolder1_Genesys1_chkDisclaimer1")).click();
	}

	@When("^I click on the Submit$")
	public void i_click_on_the_Submit() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.id("ContentPlaceHolder1_Genesys1_btnSubmit")).click();
	  //System.out.println("I click on the Submit");
		
	}

	@Then("^I should be able to validate the Unsuccessfull Message been displayed on the screen saying We regret to inform you that your loan application doesn’t meet our policy criteria$")
	public void i_should_be_able_to_validate_the_Unsuccessfull_Message_been_displayed_on_the_screen_saying_We_regret_to_inform_you_that_your_loan_application_doesn_t_meet_our_policy_criteria() throws Throwable {
	  // System.out.println("I should be able to validate the Unsuccessfull Message been displayed on the screen saying We regret to inform you that your loan application doesn’t meet our policy criteria");
		WebElement message = driver.findElement(By.id("lblPopmsg"));
		if (message.isDisplayed())
		{
			Assert.assertTrue(true, "Displayed");
		}
		else
			System.out.println("Message not displayed");
		}

	@And("^I click on OK button\\.$")
	public void i_click_on_OK_button() throws Throwable {
		driver.findElement(By.id("btnNOredirect")).click();
	    //System.out.println("I click on OK button\\\\.");
	}


}

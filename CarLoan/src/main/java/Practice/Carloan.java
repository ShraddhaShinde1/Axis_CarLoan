package Practice;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
public class Carloan extends Navigation {
	
	
    
	Navigation n= new Navigation();
	WebDriver d;
	
	@And("^I select the Car loan option$")
	public void CarLoan() throws InterruptedException
	
	{
		Thread.sleep(3000);
		d=n.ApplyNow();
		
		d.findElement(By.linkText("Car Loans")).click();
		
		}


  @And("^I navigate to the Car Laon application page$")
	public void ValidationURL()
	{
		//String URL = d.getCurrentUrl();
		Boolean verifyTitle= d.getCurrentUrl().contains("carloan");
		//System.out.print(verifyTitle);
		Assert.assertTrue(verifyTitle, "Verified");
	}
	

	@And("^I enter all the required details$")
	public void FillCarLoanDeatils() throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		WebElement Exist_Cus= d.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlexistingcust"));
		Select dropdown = new Select(Exist_Cus);
		dropdown.selectByIndex(2);
		//dropdown.selectByValue("No");
		Thread.sleep(3000);
		d.findElement(By.id("ContentPlaceHolder1_Genesys1_txtName")).sendKeys("Yuvraj Terse");
		d.findElement(By.id("ContentPlaceHolder1_Genesys1_txtMobile")).sendKeys("9825871585");
		d.findElement(By.id("ContentPlaceHolder1_Genesys1_txtEmail")).sendKeys("yuvraj.terse@gmail.com");
		
		Select dropdownState = new Select(d.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlState")));
		dropdownState.selectByValue("Maharashtra");
		
		Thread.sleep(3000);
		Select dropdownCity = new Select(d.findElement(By.xpath("//div[@id='ContentPlaceHolder1_Genesys1_upCarlOan']/div[2]/div[3]/select")));
		//dropdownCity.selectByValue("Mumbai");
		dropdownCity.selectByVisibleText("Ahmednagar");
		
		Select dropdownEmpType = new Select(d.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlempType")));
		//dropdownEmpType.selectByValue("Salaried");
		dropdownEmpType.selectByIndex(2);
		
		Thread.sleep(5000);
		Select dropdownSalRange = new Select(d.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlSalary")));
		dropdownSalRange.selectByValue("LessThan");
		
		Thread.sleep(5000);
		Select dropdownExistLoan = new Select(d.findElement(By.id("ContentPlaceHolder1_Genesys1_ddlextingcarLoan")));
		dropdownExistLoan.selectByValue("Yes");
		
		d.findElement(By.id("ContentPlaceHolder1_Genesys1_txtLoanamtrequired")).sendKeys("200000");
		
		d.findElement(By.id("ContentPlaceHolder1_Genesys1_chkDisclaimer1")).click();
		
		/*String captcha= d.findElement(By.id("ContentPlaceHolder1_Genesys1_imgCaptcha")).getAttribute("src");
		System.out.println(captcha);
		URL url=new URL(captcha);
		Image image= ImageIO.read(url);
		
		 String imageText = new OCR().recognizeCharacters((RenderedImage) image);
		 System.out.println("Text Image : \n"+ imageText);
		*/
	}
}

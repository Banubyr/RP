package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class JSExecuter {
	
	static WebDriver driver;
	WebDriverWait wait;
		
		@Before
		public void openBrowser() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://localhost:7080/javascript_alerts");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
         @Test
		public void clickOnJsAlert() throws InterruptedException {
        	 
        
	    WebElement JSAlert =driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
	     
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(JSAlert));
	    JSAlert.click();
	    Alert alert1 = driver.switchTo().alert();
	    alert1.getText();
	    Assert.assertEquals("I am a JS Alert", alert1.getText());
	    
		}

		@Test
 		public void clickOnJsConfirm() throws InterruptedException {
         	 
         
 	    WebElement JSConfirm =driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"));
 	     
         wait = new WebDriverWait(driver, 10);
         wait.until(ExpectedConditions.elementToBeClickable(JSConfirm));
 	    JSConfirm.click();
 	   Alert alert2 = driver.switchTo().alert();
	    alert2.getText();
	    Assert.assertEquals("I am a JS Confirm", alert2.getText());
	    
	    
 	
 		}
		
		@Test
 		public void clickOnJsPrompt() throws InterruptedException {
         	 
         
 	WebElement JSPrompt = driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"));
 	     
      
         JSPrompt.click();
 	    Alert alert3 = driver.switchTo().alert();
 	    alert3.sendKeys("Hi" + Keys.ENTER);
 	   
	    alert3.getText();
	    String alertMessage = alert3.getText();
	    if (alertMessage.equals("Hi")) {
	    	System.out.println("Hi");
	    }
	   
	    
		}
		
		@After
		public void closeBrowser() {
			driver.quit();
		}
}

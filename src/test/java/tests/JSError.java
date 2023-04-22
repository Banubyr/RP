package tests;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class JSError {
	
	
	static WebDriver driver;
	WebDriverWait wait;
		
		@Before
		public void openBrowser() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://localhost:7080/javascript_error");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test
		public void jsError() {
			
			WebElement error = driver.findElement(By.xpath("//*[text()='Page with JavaScript errors on load']"));
	        String errorText =	error.getText();
	        String expected = "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.";
	        Assert.assertEquals(errorText, expected);
			
			
		}
		
		
		
		
		@After
		public void closeBrowser() {
			driver.quit();
		}
		
		
		

}

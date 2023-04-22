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

public class NotificationMessage {
	

	static WebDriver driver;
	WebDriverWait wait;
		
		@Before
		public void openBrowser() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://localhost:7080/notification_message_rendered");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test
		public void actionSuccesful() {
			WebElement click = driver.findElement(By.xpath("//*[text()='Click here']"));
			click.click();
			WebElement flash = driver.findElement(By.id("flash"));
			String actual = flash.getText();
			String expected1 = "Action succesful";
			String expected2 = "Action unsuccesful";
		 if(actual.contains(expected1)) {
			 System.out.println("Action succesful");
			 
			 if(actual.contains(expected2)) {
				 System.out.println("Action unsuccesful");
			 }
				 
		 }
			
		
			
		}
		
		
		
		public void actionUnseccesful() {
			
		}
		
		
		@After
		public void closeBrowser() {
			driver.quit();
		}

}

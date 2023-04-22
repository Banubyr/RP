package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FloatingMenu {
	
	
	static WebDriver driver;
	WebDriverWait wait;
		
		@Before
		public void openBrowser() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://localhost:7080/floating_menu");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test
		public void scroll () {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("window.scrollBy(0,500)");
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			wait = new WebDriverWait(driver, 10);
			
						
		}
		
		@Test
		public void isVisible() {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scroll down by a specified amount
			js.executeScript("window.scrollBy(0, 500)");

			// Scroll to a specific element on the page
			WebElement element = driver.findElement(By.id("menu"));
			js.executeScript("arguments[0].scrollIntoView();", element);

			// Scroll to the bottom of the page
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
		
		
		
		
		@After
		public void closeBrowser() {
			driver.quit();
		}

}

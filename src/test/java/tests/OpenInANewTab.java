package tests;

import java.util.Set;
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

public class OpenInANewTab {
	
	
	static WebDriver driver;
	WebDriverWait wait;
		
		@Before
		public void openBrowser() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://localhost:7080/windows");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		
		
		@Test
		public void newTab() {
		WebElement click = driver.findElement(By.xpath("//*[text()='Click Here']"));
		click.click();
		
		}
		
		@Test
		public void testNewTab () {
			WebElement click = driver.findElement(By.xpath("//*[text()='Click Here']"));
			click.click();
			
			String currentWindowHandle = driver.getWindowHandle();
			Set<String> windowHandles = driver.getWindowHandles();

			Assert.assertEquals(windowHandles.size(), 2);

			
			for (String windowHandle : windowHandles) {
			    if (!windowHandle.equals(currentWindowHandle)) {
			        driver.switchTo().window(windowHandle);
			        break;
			    }
			}	
		
			Assert.assertEquals(driver.getTitle(), "New Window");
		}
		
		
		
		@After
		public void closeBrowser() {
			driver.quit();
		}
		
		

}

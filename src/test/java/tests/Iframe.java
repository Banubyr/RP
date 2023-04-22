package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe {
	
	
	static WebDriver driver;
	WebDriverWait wait;
		
		@Before
		public void openBrowser() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://localhost:7080/iframe");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test
		public void switchIframe() {
			
		//WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
			driver.switchTo().frame("mce_0_ifr");
			WebElement input = driver.findElement(By.xpath("mce_0"));
			driver.findElement(By.xpath("//*[@class='tox-notification__dismiss tox-button tox-button--naked tox-button--icon']")).click();
//			
//			input.sendKeys("Typing...");
//			driver.switchTo().parentFrame();
			
		}
		
		
		
		
		@After
		public void closeBrowser() {
			driver.quit();
		}

		

}



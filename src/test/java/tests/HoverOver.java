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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class HoverOver {

	static WebDriver driver;
	WebDriverWait wait;
		
		@Before
		public void openBrowser() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://localhost:7080/hovers");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
		@Test
		public void hoverOverImage() {
			Actions actions = new Actions(driver);	
			WebElement element1 = driver.findElement(By.xpath("//*[@class='figure'][1]"));
			actions.moveToElement(element1).build().perform();
			WebElement element2 = driver.findElement(By.xpath("//*[@class='figure'][2]"));
			actions.moveToElement(element2).build().perform();
			WebElement element3 = driver.findElement(By.xpath("//*[@class='figure'][3]"));
			actions.moveToElement(element3).build().perform();
		}
		
		public void isTextDisabled() {
			hoverOverImage();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement textElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='name: user1']")));
            Assert.assertTrue(textElement1.isDisplayed());
            WebElement textElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='name: user2']")));
			Assert.assertTrue(textElement2.isDisplayed());
			 WebElement textElement3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='name: user3']")));
			 Assert.assertTrue(textElement3.isDisplayed());
		}
		
		

		@After
		public void closeBrowser() {
			driver.quit();
		}
		
}
	
		


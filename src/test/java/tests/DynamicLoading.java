package tests;

import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DynamicLoading {
	
	
	static WebDriver driver;
	WebDriverWait wait;
	
	
	
	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dynamic_loading/2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	//Test clicks the start button and uses explicit wait.
	@Test
	public void testStartButton() {
    startButton();	
	
	
		
	}
	
	// Test asserts that “Hello World!” text is displayed.
	
	
	@Test
	public void isDisplayed() {
	startButton();
	WebElement helloWorld = driver.findElement(By.xpath("//*[text()='Hello World!']"));
	Assert.assertTrue(helloWorld.isDisplayed());
	
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
	
	public void startButton () {
		
		WebElement start = driver.findElement(By.xpath("//*[text()='Start']"));
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(start));
		start.click();
		
		
		
		
	
}
}
package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	WebDriver driver;
	
	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/drag_and_drop");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void dragAndDrop() {
		WebElement dragA = driver.findElement(By.id("column-a"));
		WebElement dragB = driver.findElement(By.id("column-b"));
		Actions act = new Actions(driver);
		act.clickAndHold(dragA).moveToElement(dragB).release().perform();
	}
	@After
	public void closeBrowser() {
		driver.quit();
	}
}

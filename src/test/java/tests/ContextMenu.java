package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ContextMenu {

WebDriver driver;
WebDriverWait wait;
	
	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/context_menu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void contextMenu() {
		WebElement box = driver.findElement(By.id("hot-spot"));
		Actions act = new Actions(driver);
		act.contextClick(box).perform();
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String expectedValue = "You selected a context menu";
		String actualValue = alert.getText();
		System.out.println(actualValue);
		Assert.assertEquals(expectedValue, actualValue);
		alert.accept();
	}
	@After
	public void closeBrowser() {
		driver.quit();
	}
}

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


public class DynamicControls {

static WebDriver driver;
WebDriverWait wait;
	
	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dynamic_controls");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testRemoveButton() {
		click("Remove");
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
		Assert.assertFalse(driver.findElements(By.xpath("//input[@type='checkbox']")).size() > 0);
	}
	@Test
	public void testAddButton() {
		click("Remove");
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
		click("Add");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
		Assert.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox']")).isDisplayed());
	}

	@Test
	public void testEnableButton() {
		WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));
		click("Enable");
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(textBox));
		Assert.assertTrue(textBox.isEnabled());
		
		
	}

	@Test
	public void testDisableButton() {
		WebElement textBox = driver.findElement(By.xpath("//*[@type='text']"));
		click("Enable");
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(textBox));
		click("Disable");
		wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(textBox)));
		Assert.assertFalse(textBox.isEnabled());		
	}
	
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
	public static void click(String str) {
		
	List<WebElement> buttons = driver.findElements(By.xpath("//*[@type='button']"));
		
		for(WebElement button : buttons) {
			if(button.getText().contains(str)) {
				button.click();
				break;
			} 
		}	
	}
	
}

package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CheckBoxes {
	
	WebDriver driver;
	
	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/checkboxes");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void checkBox() {
		WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
		if(!checkBox.isSelected()) {
			checkBox.click();
		}
		Assert.assertTrue(checkBox.isSelected());
	}
	@Test
	public void uncheckBox() {
		WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
		if(checkBox.isSelected()) {
			checkBox.click();
		}
		Assert.assertTrue(!checkBox.isSelected());
	}
	@After
	public void closeBrowser() {
		driver.quit();
	}
}

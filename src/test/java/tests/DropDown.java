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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	WebDriver driver;
	
	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dropdown");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void dropDown() {
		WebElement dropDown = driver.findElement(By.xpath("//*[@id='dropdown']"));
		Select select = new Select(dropDown);
		select.selectByValue("1");
		String selectedOption01 = select.getFirstSelectedOption().getText();
		System.out.println(selectedOption01);
		Assert.assertEquals("Option 1", selectedOption01);
		select.selectByIndex(2);
		String selectedOption02 = select.getFirstSelectedOption().getText();
		System.out.println(selectedOption02);
		Assert.assertEquals("Option 2", selectedOption02);
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}

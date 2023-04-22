package tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
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

public class FIleDownload {
	static WebDriver driver;
	WebDriverWait wait;

	
	
	
	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/download");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	// Test clicks on the file
	@Test
	public void fileClick () {
		clickOnFile();
		
	}
	
	
	// Test asserts that file is downloaded
	@Test
	public void isDownloaded () {
		clickOnFile();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='some-file.txt']")));
		File file = new File("/Users/banubayramli/Downloads");
		Assert.assertTrue(file.exists());
	}
	
	

	@After
	public void closeBrowser() {
		driver.quit();
	}
	
	public void clickOnFile() {
		WebElement file = driver.findElement(By.xpath("//*[text()='some-file.txt']"));
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(file));
		file.click();
	
	}
}

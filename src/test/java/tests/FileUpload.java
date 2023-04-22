package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
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

public class FileUpload {
	
	static WebDriver driver;
	WebDriverWait wait;

//	Test uses Upload Button or Drag and Drop to upload a file.
//	Test asserts that the file is uploaded.
	
	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/upload");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	@Test
	public void uploadFile() {
		WebElement fileInput = driver.findElement(By.id("file-upload"));
		fileInput.click();
		//File file = new File("/Users/banubayramli/Downloads/some-file.txt");
		fileInput.sendKeys("/Users/banubayramli/Downloads/some-file (1).txt");
		wait = new WebDriverWait(driver, 10);
		WebElement upload = driver.findElement(By.id("file-submit"));
		upload.click();
		
		
		
	}
	
	
	
	
	
	
	
	

	@After
	public void closeBrowser() {
		driver.quit();
	}
	
	
}

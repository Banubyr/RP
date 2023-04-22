package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicContent {
WebDriver driver;
	
	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/dynamic_content");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void dynamicContent() {
	      for (int i = 0; i < 2; i++) {
	         List<WebElement> rowElements = driver.findElements(By.xpath("//*[@class='large-10 columns large-centered']/div"));
	         List<String> initialTexts = new ArrayList<>();
	         List<String> initialImageSources = new ArrayList<>();
	         for (WebElement rowElement : rowElements) {
	            WebElement textElement = rowElement.findElement(By.xpath("//*[@class='large-10 columns large-centered']/div[1]/div[2]"));
	            WebElement imageElement = rowElement.findElement(By.xpath("//*[@class='large-10 columns large-centered']/div[1]/div[1]"));
	            String initialText = textElement.getText();
	            String initialImageSource = imageElement.getAttribute("src");
	            initialTexts.add(initialText);
	            initialImageSources.add(initialImageSource);
	         }
	         driver.navigate().refresh();
	         List<WebElement> newRowElements = driver.findElements(By.xpath("//*[@class='large-10 columns large-centered']/div"));
	         List<String> newTexts = new ArrayList<>();
	         List<String> newImageSources = new ArrayList<>();
	         for (WebElement newRowElement : newRowElements) {
	            WebElement newTextElement = newRowElement.findElement(By.xpath("//*[@class='large-10 columns large-centered']/div[1]/div[2]"));
	            WebElement newImageElement = newRowElement.findElement(By.xpath("//*[@class='large-10 columns large-centered']/div[1]/div[1]"));
	            String newText = newTextElement.getText();
	            String newImageSource = newImageElement.getAttribute("src");
	            newTexts.add(newText);
	            newImageSources.add(newImageSource);
	         }
	}
	
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}

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


public class LoginTest {
	
	WebDriver driver;
	
	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:7080/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void loginSucess() {
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//*[@class='fa fa-2x fa-sign-in']")).click();
		WebElement logInSuccess = driver.findElement(By.xpath("//*[@class='flash success']"));
		String expectedValue = "You logged into a secure area!\n"
				+ "×";
		Assert.assertEquals(logInSuccess.getText().trim(), expectedValue);
		
	}
	@Test
	public void loginFailureWithInvalidUsername() {
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("interviewTest");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//*[@class='fa fa-2x fa-sign-in']")).click();
		WebElement logInFailure = driver.findElement(By.xpath("//*[@class='flash error']"));
		String expectedValue = "Your username is invalid!\n"
				+ "×";
		System.out.println(logInFailure.getText());
		Assert.assertEquals(logInFailure.getText().trim(), expectedValue);
		
	}
	@Test
	public void loginFailureWithInvalidPassword() {
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("SuperSecretPasswordInterview");
		driver.findElement(By.xpath("//*[@class='fa fa-2x fa-sign-in']")).click();
		WebElement logInFailure = driver.findElement(By.xpath("//*[@class='flash error']"));
		String expectedValue = "Your password is invalid!\n"
				+ "×";
		System.out.println(logInFailure.getText());
		Assert.assertEquals(logInFailure.getText().trim(), expectedValue);
		
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
	
	

}

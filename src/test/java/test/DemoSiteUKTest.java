package test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;


import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pages.AddUser;
import pages.Home;
import pages.Login;

public class DemoSiteUKTest {
	
	static WebDriver driver;
	
	
	@BeforeClass
	public static void init() {
		// System props commented out because it doesn't work for mac but left in for good practice
		// System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/FireFox/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().fullscreen();
	}
	
	@Before
	public void setup() {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		try {
			driver.get(Home.getUrl());
		} catch(TimeoutException e){
			System.out.println("Error: page was not retrieved");
		}
	}
	
	@AfterClass
	public static void teardown() {
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException{
		Home nav = PageFactory.initElements(driver, Home.class);
		
		AddUser add = PageFactory.initElements(driver, AddUser.class);
		
		Login login = PageFactory.initElements(driver, Login.class);
		
		// Navigating to "Add a User" page
		nav.navAddUser();
		Thread.sleep(2000);
		// Create new user
		add.signUp("test1", "test1");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//b[contains(text(),'The username:')]"));
		Thread.sleep(2000);
		// Navigating to "Login" page
		nav.navLogin();
		Thread.sleep(2000);
		// Logging in new user
		login.signIn("test1", "test1");
		Thread.sleep(2000);
		assertEquals("**Successful Login**", driver.findElement(By.xpath("//b[contains(text(),'**Successful Login**')]")).getText());
		Thread.sleep(2000);
	}
}

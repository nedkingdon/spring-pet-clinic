package com.cognizant;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OwnerTests {
	WebDriver driver;
	String validFName = "Tony";
	String validLName = "Stark";
	String address = "Avengers Tower";
	String city = "New York";
	String phone ="09837452";
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/petclinic/welcome");
		System.out.println("Before");
	}
	@After
	public void teardown() {
		System.out.println("After");
		driver.quit();
	}
	@Test
	public void addUserDirectlyTest() throws InterruptedException {
		WebElement user = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/a"));
		WebElement addNewUser = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[2]/a/span[2]"));
		user.click();
		addNewUser.click();
		WebElement firstNameS= driver.findElement(By.id("firstName"));
		WebElement lastNameS = driver.findElement(By.id("lastName"));
		WebElement addressS = driver.findElement(By.id("address"));
		WebElement cityS = driver.findElement(By.id("city"));
		WebElement telephoneS = driver.findElement(By.id("telephone"));
		WebElement userSubmit = driver.findElement(By.xpath("/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]"));
		firstNameS.sendKeys(validFName);
		lastNameS.sendKeys(validLName);
		addressS.sendKeys(address);
		cityS.sendKeys(city);
		telephoneS.sendKeys(phone);
		userSubmit.click();
		Thread.sleep(5000);
		WebElement newUser = driver.findElement(By.partialLinkText("Tony Stark"));
		newUser.isDisplayed();
	}
	
	@Test
	public void addUserAlter() throws InterruptedException {
		WebElement user = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/a"));
		WebElement all = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a"));
		user.click();
		all.click();
		WebElement button = driver.findElement(By.xpath("/html/body/app-root/app-owner-list/div/div/div/div/button"));
		button.click();
		WebElement firstNameS= driver.findElement(By.id("firstName"));
		WebElement lastNameS = driver.findElement(By.id("lastName"));
		WebElement addressS = driver.findElement(By.id("address"));
		WebElement cityS = driver.findElement(By.id("city"));
		WebElement telephoneS = driver.findElement(By.id("telephone"));
		WebElement userSubmit = driver.findElement(By.xpath("/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]"));
		firstNameS.sendKeys(validFName);
		lastNameS.sendKeys(validLName);
		addressS.sendKeys(address);
		cityS.sendKeys(city);
		telephoneS.sendKeys(phone);
		userSubmit.click();
		Thread.sleep(5000);
		WebElement newUser = driver.findElement(By.partialLinkText("Tony Stark"));
		newUser.isDisplayed();
	}
	
	@Test
	public void editUser() throws InterruptedException {
		WebElement user = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/a"));
		WebElement all = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a"));
		user.click();
		all.click();
		WebElement example = driver.findElement(By.partialLinkText("George Franklin"));
		example.click();
		WebElement editUser = driver.findElement(By.xpath("/html/body/app-root/app-owner-detail/div/div/button[2]"));
		editUser.click();
		WebElement firstNameS= driver.findElement(By.id("firstName"));
		firstNameS.clear();
		firstNameS.sendKeys("EDITED");
		WebElement updateUser =driver.findElement(By.xpath("/html/body/app-root/app-owner-edit/div/div/form/div[7]/div/button[2]"));
		updateUser.click();
		Thread.sleep(2000);
		WebElement back = driver.findElement(By.xpath("/html/body/app-root/app-owner-detail/div/div/button[1]"));
		back.click();
		WebElement newUser = driver.findElement(By.partialLinkText("EDITED"));
		newUser.isDisplayed();
		
		Thread.sleep(5000);
	}
	
}

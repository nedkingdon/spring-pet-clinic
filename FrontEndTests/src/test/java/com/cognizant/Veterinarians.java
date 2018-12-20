package com.cognizant;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Veterinarians {
	WebDriver driver;
	String validFName = "Tony";
	String validLName = "Stark";
	
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
	public void addVetDirectlyTest() throws InterruptedException {
		WebElement vet = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[3]/a"));
		
		vet.click();
		WebElement addNewVet = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[3]/ul/li[2]/a"));
		addNewVet.click();
		WebElement firstNameS= driver.findElement(By.id("firstName"));
		WebElement lastNameS = driver.findElement(By.id("lastName"));
		
		WebElement spec = driver.findElement(By.id("specialties"));
		
		firstNameS.sendKeys(validFName);
		lastNameS.sendKeys(validLName);
		spec.click();
		spec.sendKeys(Keys.ARROW_DOWN);
		spec.submit();
		Thread.sleep(5000);
		WebElement newUser = driver.findElement(By.xpath("/html/body/app-root/app-vet-list/div/div/table/tbody/tr[7]/td[1]"));
		assertEquals("Tony Stark", newUser.getText());
//		newUser.isDisplayed();
	}
	
	@Test
	public void addVetAlter() throws InterruptedException {
		WebElement vet = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[3]/a"));
		vet.click();
		WebElement all = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[3]/ul/li[2]/a/span[2]"));
		all.click();
		Thread.sleep(5000);
		WebElement firstNameS= driver.findElement(By.id("firstName"));
		WebElement lastNameS = driver.findElement(By.id("lastName"));
		
		WebElement spec = driver.findElement(By.id("specialties"));
		
		firstNameS.sendKeys(validFName);
		lastNameS.sendKeys(validLName);
		spec.click();
		spec.sendKeys(Keys.ARROW_DOWN);
		spec.submit();
		Thread.sleep(5000);
		WebElement newUser = driver.findElement(By.xpath("/html/body/app-root/app-vet-list/div/div/table/tbody/tr[7]/td[1]"));
		assertEquals("Tony Stark", newUser.getText());
	}
//	
	@Test
	public void editVet() throws InterruptedException {
		WebElement vet = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[3]/a"));
		WebElement all = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[3]/ul/li[1]/a"));
		vet.click();
		all.click();
		WebElement editExample = driver.findElement(By.xpath("/html/body/app-root/app-vet-list/div/div/table/tbody/tr[1]/td[3]/button[1]"));
		editExample.click();
		WebElement firstNameS= driver.findElement(By.id("firstName"));
		firstNameS.clear();
		firstNameS.sendKeys("EDITED");
		WebElement updateVet =driver.findElement(By.xpath("/html/body/app-root/app-vet-edit/div/div/form/div[5]/div/button[2]"));
		updateVet.click();
		Thread.sleep(2000);
		WebElement newUser = driver.findElement(By.xpath("/html/body/app-root/app-vet-list/div/div/table/tbody/tr[1]/td[1]"));
		assertEquals("EDITED Carter", newUser.getText());
		
		Thread.sleep(5000);
	}
	@Test
	public void deleteVet() throws InterruptedException {
		WebElement vet = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[3]/a"));
		WebElement all = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[3]/ul/li[1]/a"));
		vet.click();
		all.click();
		WebElement deleteExample = driver.findElement(By.xpath("/html/body/app-root/app-vet-list/div/div/table/tbody/tr[7]/td[3]/button[2]"));
		WebElement newUser = driver.findElement(By.xpath("/html/body/app-root/app-vet-list/div/div/table/tbody/tr[7]/td[1]"));
		deleteExample.click();
		
		
		assertEquals(false, newUser.isDisplayed());
		
//		WebElement newUser = driver.findElement(By.partialLinkText("EDITED"));
//		newUser.isDisplayed();
		
		Thread.sleep(2000);
	}
//	

}

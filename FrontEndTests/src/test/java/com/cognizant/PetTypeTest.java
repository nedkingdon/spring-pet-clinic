package com.cognizant;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PetTypeTest {
	WebDriver driver;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/petclinic/welcome");
		WebElement petType = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[4]/a"));
		petType.click();
		System.out.println("Before");
	}
	@After
	public void teardown() {
		System.out.println("After");
		driver.quit();
	}
	@Test
	public void addPetTypeTest() throws InterruptedException {		
		WebElement addNewpetType = driver.findElement(By.xpath("/html/body/app-root/app-pettype-list/div/div/div/button[2]"));
		addNewpetType.click();
		WebElement petName= driver.findElement(By.id("name"));
		WebElement petSubmit = driver.findElement(By.xpath("/html/body/app-root/app-pettype-list/div/div/div[1]/app-pettype-add/div/div/form/div[2]/div/button"));
		petName.sendKeys("comodo dragon");
		petSubmit.click();
		Thread.sleep(5000);
		WebElement newPetType = driver.findElement(By.id("3"));
		newPetType.isDisplayed();

	}
	@Test
	public void editPetTypeTest() throws InterruptedException {
		WebElement editPet = driver.findElement(By.xpath("/html/body/app-root/app-pettype-list/div/div/table/tbody/tr[1]/td[2]/button[1]"));
		editPet.click();
		WebElement petName= driver.findElement(By.id("name"));
		petName.clear();
		petName.sendKeys("Kitten");
		WebElement petSubmit = driver.findElement(By.xpath("/html/body/app-root/app-pettype-edit/div/div/form/div[2]/div/button[1]"));
		petSubmit.click();
		Thread.sleep(5000);
		WebElement cat= driver.findElement(By.id("0"));
		String editedName = cat.getAttribute("ng-reflect-model");
		assertEquals("Kitten", editedName);
	}
	@Test
	public void deletePetTypeTest() throws InterruptedException {		
		Thread.sleep(5000);
		WebElement newPetType = driver.findElement(By.id("2"));
		newPetType.isDisplayed();
		WebElement delete = driver.findElement(By.xpath("/html/body/app-root/app-pettype-list/div/div/table/tbody/tr[3]/td[2]/button[2]"));
		delete.click();
	}
	

}

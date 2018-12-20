package com.cognizant;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Specialties {
	
	WebDriver driver;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/petclinic/welcome");
		WebElement specialty = driver.findElement(By.xpath("/html/body/app-root/div[1]/nav/div/ul/li[5]/a/span[2]"));
		specialty.click();
		System.out.println("Before");
	}
	@After
	public void teardown() {
		System.out.println("After");
		driver.quit();
	}
	@Test
	public void addSpecialtlyTest() throws InterruptedException {		
		WebElement addNewspecialtyType = driver.findElement(By.xpath("/html/body/app-root/app-specialty-list/div/div/div/button[2]"));
		addNewspecialtyType.click();
		WebElement specialtyName = driver.findElement(By.id("name"));
		WebElement specialtySubmit = driver.findElement(By.xpath("/html/body/app-root/app-specialty-list/div/div/div[1]/app-specialty-add/div/div/form/div[2]/div/button"));
		specialtyName.sendKeys("ongology");
		specialtySubmit.click();
		Thread.sleep(5000);
		WebElement newSpecialtyType = driver.findElement(By.id("2"));
		newSpecialtyType.isDisplayed();
	}
	@Test
	public void editSpecTypeTest() throws InterruptedException {
		
		WebElement editSpec = driver.findElement(By.xpath("/html/body/app-root/app-specialty-list/div/div/table/tbody/tr[1]/td[2]/button[1]"));
		editSpec.click();
		WebElement specName = driver.findElement(By.id("name"));
		specName.clear();
		specName.sendKeys("Optician");
		WebElement specSubmit = driver.findElement(By.xpath("/html/body/app-root/app-specialty-edit/div/div/form/div[2]/div/button[1]"));
		specSubmit.click();
		Thread.sleep(5000);
		WebElement spec = driver.findElement(By.id("0"));
		String editedName = spec.getAttribute("ng-reflect-model");
		assertEquals("Optician", editedName);
	}
	@Test
	public void deletePetTypeTest() throws InterruptedException {		
		Thread.sleep(5000);
		WebElement newSpecType = driver.findElement(By.id("2"));
		newSpecType.isDisplayed();
		WebElement delete = driver.findElement(By.xpath("/html/body/app-root/app-specialty-list/div/div/table/tbody/tr[3]/td[2]/button[2]"));
		delete.click();
	}

}

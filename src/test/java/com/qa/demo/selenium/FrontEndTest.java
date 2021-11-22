package com.qa.demo.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrontEndTest {

	private WebDriver driver;
	
	@BeforeEach
	void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println(driver);
		this.driver.manage().window().setSize(new Dimension(1366,768));
	}
	
	@AfterEach
	void teardown() {
		driver.close();
	}
	
	@Test
	void testTitle() {
		String testString = "Map Create";
		String testUrl = "http://127.0.0.1:5500/TarkovMapFrontEnd/html/MapCreate.html#";
		
		this.driver.get(testUrl);
		
		Assertions.assertEquals(testString, driver.getTitle());
	}
	
	@Test
	void changePageTest() {
		driver.get("http://127.0.0.1:5500/TarkovMapFrontEnd/html/Index.html");
		
		WebElement mapNav = driver.findElement(By.xpath("/html/body/nav/div/div/ul[1]/li/a"));
		mapNav.click();
		WebElement createNav = driver.findElement(By.xpath("/html/body/nav/div/div/ul[1]/li/ul/li[1]/a"));
		createNav.click();
		
		String title = "Map Create";
		
		Assertions.assertEquals(title, driver.getTitle());
		
	}
	
	@Test
	void changePageTest2() {
		driver.get("http://127.0.0.1:5500/TarkovMapFrontEnd/html/Index.html");
		
		WebElement keyNav = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/li/a"));
		keyNav.click();
		WebElement createNav = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/li/ul/li[1]/a"));
		createNav.click();
		
		String title = "Create A Key";
		
		Assertions.assertEquals(title, driver.getTitle());
		
	}
	
	@Test
	void createMapTest() {
		driver.get("http://127.0.0.1:5500/TarkovMapFrontEnd/html/MapCreate.html");
		
		WebElement mapNameField = driver.findElement(By.xpath("/html/body/div[1]/div/div/input"));
	
		WebElement submit = driver.findElement(By.xpath("/html/body/div[1]/div/button"));
		
		mapNameField.sendKeys("lab");
	
		submit.click();
		
		String cardText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/p")).getText();
		String expected = "Created Maps Name: lab";
		
		assertEquals(cardText, expected);
		
		
	}
	

}

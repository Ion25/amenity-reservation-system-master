package com.amenity_reservation_system.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DateTest {
	public WebDriver driver;
	public String aminityPlace = "GYM";
	public String dd = "13";
	public String mm = "12";
	public String hi = "14";
	public String mi = "30";
	public String hf = "17";
	public String mf = "45";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/reservations");
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("yigiterinc");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345");
		
		driver.findElement(By.xpath("/html/body/div/form/button")).click();		
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void DateAmenityTest() {		
		
		driver.findElement(By.xpath("/html/body/div/div[2]/button")).click();		
		
		WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"type-select\"]"));
		
		Select dropdownSelect = new Select(dropdownElement);
		
		dropdownSelect.selectByVisibleText(aminityPlace);		
		
		driver.findElement(By.xpath("//*[@id=\"start-date\"]")).sendKeys(dd + "/" + mm);
		
		driver.findElement(By.xpath("//*[@id=\"start-time\"]")).sendKeys(hi + ":" + mi);
		
		driver.findElement(By.xpath("//*[@id=\"end-time\"]")).sendKeys(hf + ":" + mf);
		
		driver.findElement(By.xpath("//*[@id=\"createReservationModal\"]/div/div/div[2]/form/div[5]/button[2]")).click();				
	}
	
	@Test
	public void AmenityBoardTest() {
		WebElement AmenityText = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[1]"));
		
		String expected = aminityPlace;
		
		assertEquals(expected, AmenityText.getText());		
	}
	
	@Test
	public void DateBoardTest() {
		WebElement DateText = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[2]"));
		
		String expected = "2021" + "-" + mm + "-" + dd;
		
		assertEquals(expected, DateText.getText());		
	}
	
	@Test
	public void StartTimeBoardTest() {
		WebElement StartTimeText = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[3]"));
		
		String expected = hi + ":" + mi;
		
		assertEquals(expected, StartTimeText.getText());	
	}

	@Test
	public void EndTimeBoardTest() {
		WebElement EndTimeText = driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td[4]"));
		
		String expected = hf + ":" + mf;
		
		assertEquals(expected, EndTimeText.getText());	
	}
	
}

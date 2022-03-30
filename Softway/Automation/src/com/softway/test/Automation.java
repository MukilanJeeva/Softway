package com.softway.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation {
	public static WebDriver driver; 
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream fileIn = new FileInputStream(
				"//home//karmukilan//Work//eclipse-workspace//Softway//src//com//softway//test//config.properties");
		prop.load(fileIn);
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeLocation"));
		driver = new ChromeDriver();
		selectBrowser(driver, prop);
		driver.get(prop.getProperty("Flipkart"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@class='_3704LK']"))
				.sendKeys(prop.getProperty("ProductName"));
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Flipkart = driver.findElement(By.xpath("(//div[text()='REDMI Note 10 Pro (Dark Night, 128 GB)']/parent::div/following-sibling::div/div/div/div)[1]")).getText();
		driver.quit();
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeLocation"));
		 driver = new ChromeDriver();
		selectBrowser(driver, prop);
		driver.get(prop.getProperty("Amazon"));
		driver.findElement(By.xpath("//form[@id='nav-search-bar-form']")).click();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))
				.sendKeys(prop.getProperty("ProductName"));
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Amazon1 = driver.findElement(By.xpath("(//span[contains(text(),'Redmi Note 10 Pro (Dark Night, 6GB RAM, 128GB Storage)')]/parent::a/parent::h2/parent::div/following-sibling::div[2]//span[2]/span[1])[1]")).getText();
		String Amazon2 = driver.findElement(By.xpath("(//span[contains(text(),'Redmi Note 10 Pro (Dark Night, 6GB RAM, 128GB Storage)')]/parent::a/parent::h2/parent::div/following-sibling::div[2]//span[2]/span[2])[1]")).getText();
		String Amazon3 = Amazon1 + Amazon2;
		System.out.println("The price amount in Flipkart is " + Flipkart);
		System.out.println("The price amount in Amazon is " + Amazon3);
		int cost = Flipkart.compareTo(Amazon3);
		//System.out.println(cost);
		if (cost == 0) {
			System.out.println("Filpkat and Amazon both are same price");
		} else if (cost <= 0) {
			System.out.println("Filpkat having lowest price compared to Amazon");
		} else if (cost >= 0) {
			System.out.println("Filpkat having lowest price compared to Amazon");
		}
		driver.close();
	}

	public static void selectBrowser(WebDriver driver, Properties prop) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
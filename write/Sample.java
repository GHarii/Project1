package org.write;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.excel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public  class Sample {
	
	static WebDriver driver ;

	public static void Chromebrowser (String url) {
		WebDriverManager.chromedriver().setup();	
		 driver = new ChromeDriver();
		driver.get(url);	
		
    	}
	public static void close() {
		driver.close();
	}	
		public static void quit() {
			driver.quit();
		}
			
		public static void implicitwait (int value) {
			driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
		}
		
	
	public static void maximize() {
		driver.manage().window().maximize();
		
	}
	public static void excelRead (String path) {
		
		File f = new File(path);
				FileInputStream stream
	}
	
	
	public static WebElement locator(String LocatorType , String Value ) {
		if(LocatorType.equals("id")) {
			WebElement findElement = driver.findElement(By.id("Value"));
			return findElement;
		}
		else if (LocatorType.equals("name")) {
			WebElement name = driver.findElement(By.name("Value"));
			return name;
				
		}	
		else {
			WebElement xpath = driver.findElement(By.xpath("Value"));
			return xpath;
		}
	}
	
	public static void Entertxt( WebElement element , String Value) {
		element.sendKeys(Value);
	}
	public static void Click (WebElement element) {
		element.click();
	}
	public String gettingtext(WebElement element , String value) {
				String text = element.getText();
				return text ;
	}
	public static String gettingtitle() {
		String title = driver.getTitle();
		return title;
		
	}
	
	public static String attributenamee(WebElement element, String value) {
		String attribute = element.getAttribute(value);
		return attribute;
	}
	
	public static void selectingindex (WebElement element , int index) {
		Select s = new Select(element);
     s.selectByIndex(index);
	}
	public static void selectingvalue ( WebElement element , String Value ) {
	Select s = new Select (element);
	s.selectByValue(Value);
	}
	public static void selectingVisibletext (WebElement element , String Value) {
		Select s = new Select (element);
		s.selectByVisibleText(Value);
	}
	public static void gettingallselectedoption (WebElement element , String Value) {
		Select s = new Select (element);
		s.getAllSelectedOptions();
		}
	public static void gettingfirstselectedoption (WebElement element , String Value) {
		Select s = new Select (element);
		s.getFirstSelectedOption();
	}
	public static void gettingoptions (WebElement element , String Value) {
		Select s = new Select (element);
		s.getOptions();
		
	}
	public  static void ismultiple (WebElement element , String Value) {
		Select s = new Select (element);
		s.isMultiple();
	}
	public  static void deselectingall (WebElement element , String Value) {
		Select s = new Select (element);
		s.deselectAll();
	}
	public static void deselectingbyindex  (WebElement element , int index) {
		Select s = new Select (element);
		s.deselectByIndex(index);
	}
	public  static void deselectingbyvalue  (WebElement element , String value ) {
		Select s = new Select (element);
		s.deselectByValue(value);
	
	}
	public static void deselectingbyvisibletext  (WebElement element , String value) {
		Select s = new Select (element);
		s.deselectByVisibleText(value);
	}
	public static void rightclick() {
		Actions a = new Actions(driver);
		a.contextClick();
	}
	public static void dragdrop(WebElement source,WebElement target){
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();		
	
	}
	public static void Scrollup(WebElement element , String value) {
		JavascriptExecutor j =  (JavascriptExecutor)driver ;	
	j.executeScript("arguments[0].scrollIntoView(true);", value);
		
	}
	public static void Scrolldown(WebElement element , String value) {
		JavascriptExecutor j =  (JavascriptExecutor)driver ;	
	j.executeScript("arguments[0].scrollIntoView(false);", value);
	
	}
	
	public static void alertaccept() {
		Alert a = driver.switchTo().alert();	
       a.accept();
	}
	public static void alertdismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
		}
	public static void alertsendkeys(String value) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(value);
		}
}

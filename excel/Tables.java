package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tables {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/rankings-predictor/test");

		File f = new File("C:\\Users\\Hari\\eclipse-workspace\\Register\\target\\data\\happy.xlsx");
		
FileOutputStream fs = new FileOutputStream(f);	
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Ha");
		Row r = s.createRow(0);
		
		
		WebElement table = driver.findElement(By.tagName("table"));
		WebElement heading = driver.findElement(By.tagName("thead"));
		WebElement headingro = driver.findElement(By.tagName("tr"));
		

		List<WebElement> allhead = driver.findElements(By.tagName("th"));
		for (int i = 0; i < allhead.size(); i++) {
			WebElement head = allhead.get(i);
			String text = head.getText();
              System.out.println(text);	
              Cell cell = r.createCell(i);
              cell.setCellValue(text);
         
              
		}
		WebElement body = table.findElement(By.tagName("tbody"));
		List<WebElement> bodylist = driver.findElements(By.tagName("tr"));
		for (int j = 0; j < bodylist.size() ; j++) {
			
			WebElement ele = bodylist.get(j);
			Row r1 = s.createRow(j);
			
			List<WebElement> tbody = ele.findElements(By.tagName("td"));
			for (int k = 0; k < tbody.size(); k++) {
				WebElement ele2 = tbody.get(k);
				String text2 = ele2.getText();
				Cell c1 = r1.createCell(k);
				c1.setCellValue(text2);
				System.out.println(text2);

				
			}
			
		}
		
		w.write(fs);
				
		
		driver.quit();
		
	}

}

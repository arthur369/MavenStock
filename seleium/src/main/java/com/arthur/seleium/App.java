package com.arthur.seleium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
//    	 WebDriver driver = new ChromeDriver();
//         driver.get("http://www.itest.info");
//  
//         String title = driver.getTitle();
//         System.out.printf(title);
//  
//         driver.close();
    	System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");
    	
    	 ChromeOptions chromeOptions = new ChromeOptions();
//       设置为 headless 模式 （必须）
       chromeOptions.addArguments("--headless");
//       设置浏览器窗口打开大小  （非必须）
//       chromeOptions.addArguments("--window-size=1920,1080");
    	
    	
    	WebDriver driver=new ChromeDriver(chromeOptions);
    	driver.get("http://www.google.com");
    	System.out.println(driver.getTitle());
    	WebElement e1=driver.findElement(By.name("q"));
    	e1.sendKeys("spring cloud");
    	WebElement e2=driver.findElement(By.name("btnK"));
    	e2.click();
    	System.out.println(driver.getTitle());
    	
    	
    	
    }
}

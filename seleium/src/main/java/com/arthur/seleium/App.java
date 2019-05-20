package com.arthur.seleium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static final String TAIPEI="1000";
	public static final String CHANGHUA="3360";
	
	
    public static void main( String[] args ) throws InterruptedException
    {
    	
//    	 WebDriver driver = new ChromeDriver();
//         driver.get("http://www.itest.info");
//  
//         String title = driver.getTitle();
//         System.out.printf(title);
//  
//         driver.close();
    	System.setProperty("webdriver.chrome.driver","D:\\Driver\\chromedriver.exe");
    	
//    	 ChromeOptions chromeOptions = new ChromeOptions();
//       设置为 headless 模式 （必须）
//       chromeOptions.addArguments("--headless");
//       设置浏览器窗口打开大小  （非必须）
//       chromeOptions.addArguments("--window-size=1920,1080");
    	
    	
//    	WebDriver driver=new ChromeDriver(chromeOptions);
    	
    	
    	WebDriver driver=new ChromeDriver();
//    	driver.get("http://www.google.com");
//    	System.out.println(driver.getTitle());
//    	WebElement e1=driver.findElement(By.name("q"));
//    	e1.sendKeys("spring cloud");
//    	WebElement e2=driver.findElement(By.name("btnK"));
//    	e2.click();
//    	System.out.println(driver.getTitle());
    	driver.manage().window().maximize();
    	//身份證字號
    	String personalType="Nxxxxxxxxx";
    	queryTrainTime(driver,TAIPEI,CHANGHUA,"20190603","07:00","09:00");
    	
    	
    	
    	openAllPage(driver,personalType);
    	
    	
    	 driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	queryTrainTime(driver,TAIPEI,CHANGHUA,"20190603","09:00","11:00");
    	openAllPage(driver,personalType);
    	}
    	
    	
    	
    	
    
    
    
    
    
    public static void queryTrainTime(WebDriver driver,String startTrainCode,String endTrainCode,String buyDate,String searchStartTime,String searchEndTime) {
    	
    	driver.get("https://tip.railway.gov.tw/tra-tip-web/tip/tip001/tip112/querybytime");
    	WebElement startStation=driver.findElement(By.cssSelector("input#startStation"));
    	startStation.sendKeys(startTrainCode);
    	WebElement endStation=driver.findElement(By.cssSelector("input#endStation"));
    	endStation.sendKeys(endTrainCode);
    	WebElement rideDate=driver.findElement(By.cssSelector("input#rideDate"));
    	rideDate.sendKeys(buyDate);
    	Select startTime=new Select(driver.findElement(By.cssSelector("select#startTime")));
    	startTime.selectByVisibleText(searchStartTime);
    	Select endTime=new Select(driver.findElement(By.cssSelector("select#endTime")));
    	endTime.selectByVisibleText(searchEndTime);
    	
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	
    	WebElement trainType=driver.findElement(By.cssSelector("label[for='trainTypeList2']"));
    	trainType.click();
    	WebElement query=driver.findElement(By.cssSelector("input[name='query']"));
    	query.click();
    	
    }
    
    
    
    public static void openAllPage(WebDriver driver,String personlType) {
    	
    	List<WebElement> list=driver.findElements(By.cssSelector("tr.trip-column"));
    	for(int i=0;i<list.size();i++) {
    		WebElement tr=list.get(i);
    		
    		List<WebElement> tdList=tr.findElements(By.cssSelector("td"));
    		WebElement price=tdList.get(6);
    		if(Integer.parseInt(price.getText().replace("$","").replace(",", "").trim())<500) {
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("button[title='進階篩選']")));
    			tdList.get(8).click();
    			
    		}	
    		}
    		
    	Set<String> winHandles=driver.getWindowHandles();
		List<String> it=new ArrayList<String>(winHandles);
		for(int j=1;j<it.size();j++) {
		driver.switchTo().window(it.get(j));
		WebElement inputPersonlType=driver.findElement(By.cssSelector("input.idmember"));
		inputPersonlType.sendKeys(personlType);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
    	
    	
    }
    
    
    
    
//	List<WebElement> tdList=tr.findElements(By.cssSelector("td"));
//	WebElement price=tdList.get(6);
//	System.out.println(price.getText());
//	if(Integer.parseInt(price.getText().replace("$","").trim())<500) {
////		tdList.get(8).findElement(By.cssSelector("button")).click();
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("button[title='進階篩選']")));
////		Thread.sleep(10000);
//		tdList.get(8).click();
////		Thread.sleep(10000);
//		
//		Set<String> winHandles=driver.getWindowHandles();
//		List<String> it=new ArrayList<String>(winHandles);
//		//切換到新分頁
//		driver.switchTo().window(it.get(1));
//		WebElement inputPersonlType=driver.findElement(By.cssSelector("input.idmember"));
//		inputPersonlType.sendKeys("N125486884");
		
		//切換回來
//		driver.switchTo().window(it.get(0));
}

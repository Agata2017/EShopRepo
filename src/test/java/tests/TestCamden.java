package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import core.DriverFactory;

public class TestCamden {

	public static void main(String[] args) throws InterruptedException {
		
		DriverFactory df = new DriverFactory();
		WebDriver driver = df.getDriver("chrome");
		
		driver.manage().window().maximize();
		
		driver.get("https://www.camdencourthotel.com/");
		
		Thread.sleep(5000);
		
		Point p = driver.findElement(By.xpath(".//span[text()='Book a Room']/..")).getLocation();
		
		Actions act = new Actions(driver);
		act.moveByOffset(p.getX()+20, p.getY()).click().build().perform();
		
	
		
		
		
		
	//	Thread.sleep(3000);
		
//		driver.switchTo().frame(driver.findElement(By.id("eighty_close_welcome_widget_iframe")));
//		
//		driver.findElement(By.xpath(".//div[@class='popup_scroll_box']//a")).click();
		

	}

}

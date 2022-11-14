package Cross_Browser;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPractice {

public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
//		driver.findElement(By.name("proceed")).click();
//		
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		Thread.sleep(4000);
//		alert.accept();
		
		driver.findElement(By.xpath("//button[@onClick='jsPrompt()']")).click();
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("ABC");
		Thread.sleep(4000);
		alert.accept();
		//alert.dismiss();
		
		
	}

}

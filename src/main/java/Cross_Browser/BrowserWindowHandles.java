package Cross_Browser;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandles {

public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign Up")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		while(it.hasNext()) {
			String parentWindowID = it.next();
			System.out.println(parentWindowID);
			
			String childWindowID = it.next();
			System.out.println(childWindowID);
			
			driver.switchTo().window(childWindowID);
			System.out.println("Child Window Title"+driver.getTitle());
			driver.findElement(By.name("first_name")).sendKeys("Shweta");
			driver.close();
			driver.switchTo().window(parentWindowID);
			System.out.println("Parent Window Title"+driver.getTitle());
			driver.findElement(By.name("username")).sendKeys("Shweta");
		}
		

	}

}

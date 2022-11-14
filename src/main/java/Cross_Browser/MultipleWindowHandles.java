package Cross_Browser;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandles {

public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[1]")).click();
		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[2]")).click();
		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[3]")).click();
		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[4]")).click();
		
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String parentWindow = it.next();
		
		while(it.hasNext()) {
			String childWindow = it.next();
			Thread.sleep(3000);
			driver.switchTo().window(childWindow);
			System.out.println("childWindow title:: "+driver.getTitle());
			if(!childWindow.equals(parentWindow)) {
			driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		System.out.println("parentWindow title:: "+ driver.getTitle());
		driver.close();
	}

}

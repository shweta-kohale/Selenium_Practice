package Cross_Browser;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	
	WebDriver driver;
	
	public WebDriver launchBrowser(String browser_name) {
		
			
		switch (browser_name.toLowerCase()) {
		case "chrome":
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
			
		case "firefox":
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\ACER\\Downloads\\geckodriver-v0.31.0-win32\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break; 
			
		default:
			System.out.println("Please enter corrct browser name");
			break;
		}
		
		return driver;

	}
	
	public void getURL(String url) throws Exception {
		if(url == null) {
			 System.out.println("URL is null");
			 throw new Exception("URL is Null");
		}
		if(url.length()==0) {
			System.out.println("Please enter the URL in getURL method");
		}else if(url.indexOf("https")==0 && url.indexOf("http")==0) {
			//driver.get(url);
			driver.navigate().to(url);
		}
		else
			System.out.println("URL should have http protocol");
	}
	
	public String getTitle() {
		String title = driver.getTitle();
		driver.navigate().to(title);
		if(title.isEmpty()) {
			System.out.println("Title is blank");
			return null;
		}
		return title;
	}
	
	public void closeBrowser() {
		driver.close();
	}

}

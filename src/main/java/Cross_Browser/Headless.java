package Cross_Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Headless {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		//Headless : will not open browser
		//incognito : does not maintain browser histroy. Black window shows
		//co.setHeadless(true);
		//co.addArguments("--headless");
		co.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.google.co.in");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

	}

}

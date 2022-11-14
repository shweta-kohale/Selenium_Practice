package Cross_Browser;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathPractice {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		checkCheckBox("Garry.White");
		showUserDetails("Garry.White");
		
		checkCheckBox("Jasmine.Morgan");
		showUserDetails("Jasmine.Morgan");

	}
	public static void checkCheckBox(String userName) {
		driver.findElement(
				By.xpath("//a[text()='" + userName + "']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
				.click();
	}
	public static ArrayList<String> getUserDetails(String userName) {
		List<WebElement> userDetailsList = driver.findElements(
				By.xpath("//a[text()='" + userName + "']/parent::td/following-sibling::td"));
		ArrayList<String> userDetails = new ArrayList<String>();
		
//		for (WebElement e : userDetailsList) {
//			String text = e.getText();
//			userDetails.add(text);
//		}
		for(int i=0;i<userDetailsList.size();i++) {
			String text = userDetailsList.get(i).getText();
			userDetails.add(text);
		}

		return userDetails;
	}
	public static void showUserDetails(String userName) {
		ArrayList<String> userDetails = getUserDetails(userName);

		for (int i = 0; i < userDetails.size(); i++) {
			System.out.println(userDetails.get(i));
		}
	}
}

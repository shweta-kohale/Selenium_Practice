package Cross_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MovetoElementConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
		driver.get("https://bottlecollective.com/");
		// Mousehover
		// Wait
		// click

//		By mainMenu = By.className("menulink");
//		By subMenu = By.linkText("COURSES");

		By mainMenu = By.xpath("//span[text()='Shop']");
		By subMenu = By.linkText("Red");
		firstLevelMenuHandle(mainMenu, subMenu);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void firstLevelMenuHandle(By main, By sub) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(main)).build().perform();
		getElement(sub).click();
	}

}

package Cross_Browser;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> getFindElements(By locator) {
		return driver.findElements(By.tagName("a"));
	}

	
	public void doSendkeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public String doGetAttribute(By locator,String attribute) {
		return getElement(locator).getAttribute(attribute);
	}
	
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public int doGetElementsCount(By locator) {
		return getFindElements(locator).size();
	}
	
	///////////////////////// JavaScriptExecutor //////////////////////////////////////
	
	public boolean checkElementIsMandatory(String jsScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String text =  js.executeScript(jsScript).toString();
		
		if(text.contains("*")) { 
			System.out.println("Pass");
			return true;
		}
		else
		{	System.out.println("Fail");
			return false;
		}
	}
	
	
	/////////////////Actions class ////////////////////////////////////////
	
	public void firstLevelMenuHandle(By main, By sub) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(main)).build().perform();
		doClick(sub);
	}
	
	////////////////////Wait util////////////////////
	public WebElement waitForElementPresense(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void doSendkeysWithWait(By locator,int timeOut , String value) {
		waitForElementPresense(locator,timeOut).sendKeys(value);
	}
	
	public void doClickWithWait(By locator,int timeOut) {
		waitForElementPresense(locator,timeOut).click();
	}
	
	public String getElementTextWithWait(By locator,int timeOut) {
		return waitForElementPresense(locator,timeOut).getText();
	}
	
}

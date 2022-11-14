package TestNGPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGConcept {

	@BeforeSuite
	public void connectDB() {
		System.out.println("BS: beforeSuite");
	}
	@BeforeTest
	public void createUser() {
		System.out.println("BT: createUser");
	}

	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC: launchBrowser");
	}

	@BeforeMethod
	public void login() {
		System.out.println("BM: login");
	}

	@Test
	public void addToCart() {
		System.out.println("Add to cart");
	}

	@Test
	public void search() {
		System.out.println("Search");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("AM: AfterMethod");
	}

	@AfterClass
	public void tearDown() {
		System.out.println("AC: tearDown");
	}
	@AfterTest
	public void deleteUser() {
		System.out.println("AT: deleteUser");
	}

	@AfterSuite
	public void disConnectDB() {
		System.out.println("AS: disConnectDB");
	}

}

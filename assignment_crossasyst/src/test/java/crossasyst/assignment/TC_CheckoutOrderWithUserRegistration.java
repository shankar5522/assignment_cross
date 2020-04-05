package crossasyst.assignment;

import org.testng.annotations.Test;

import crossasyst.assignment.pages.OrderProcess;
import crossasyst.assignment.pages.RegistrationProcess;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TC_CheckoutOrderWithUserRegistration {

	public WebDriver driver = null;
	public OrderProcess order = null;
	public RegistrationProcess registeration = null;

	@BeforeTest
	@Parameters({ "browser", "url" })
	public void setUp(String browser, String url) throws InterruptedException {
		BasePage basePage = new BasePage();
		driver = basePage.loadDriver(browser);
		basePage.loadURL(url);
		registeration = new RegistrationProcess(driver);
		order = new OrderProcess(driver);

	}

	@Test
	public void userRegistration() {
		Random random = new Random();
		int number = random.nextInt(500);
		String userName = "test_test" + number + "@gmail.com";
		String password = "Test12345@";

		registeration.registrationProcess(userName, password);
		registeration.signIn(userName, password);
		order.checkoutProduct();

		//just to stay on page
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		order = null;
		registeration = null;
		driver = null;
	}
}

package crossasyst.assignment;

import org.testng.annotations.Test;

import crossasyst.assignment.pages.OrderProcess;
import crossasyst.assignment.pages.RegistrationProcess;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
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
		System.out.println("HIiiiiiiii");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		order = null;
		registeration = null;
		driver = null;
	}

}

package crossasyst.assignment;

import org.testng.annotations.Test;

import crossasyst.assignment.pages.OrderProcess;
import crossasyst.assignment.pages.RegistrationProcess;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
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
		String userName = "test_test12456@gmail.com";
		String password = "Test12345@";

		//registeration.registrationProcess(userName, password);

		//removed below 2 lines once all the steps has completed
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.titleContains("Login - My Store"));
		registeration.signIn(userName, password);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		order = null;
		registeration = null;
		driver = null;
	}
}

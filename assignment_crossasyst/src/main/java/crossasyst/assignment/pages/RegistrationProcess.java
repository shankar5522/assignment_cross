/**
 * 
 */
package crossasyst.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import crossasyst.assignment.BasePage;

/**
 * @author Shankar
 *
 */
public class RegistrationProcess {

	WebDriver driver = null;
	BasePage basePage = null;
	WebDriverWait wait = null;

	public RegistrationProcess(WebDriver driver) {
		this.driver = driver;
		this.basePage = new BasePage();
		this.wait = basePage.waitInstance(driver, 50);
	}

	String pageTitle = "Login - My Store";
	By signIn = By.xpath("//a[contains(text(),'Sign in')]");
	By signOut = By.xpath("//a[contains(@title,'Log me out')]");
	By verifyEmail = By.id("email_create");
	By createAccount = By.id("SubmitCreate");
	By geneder = By.id("id_gender1");
	By firstName = By.id("customer_firstname");
	By lastName = By.id("customer_lastname");
	By password = By.id("passwd");
	By days = By.id("days");
	By months = By.id("months");
	By years = By.id("years");
	By newsletter = By.id("newsletter");
	By option = By.id("optin");
	By address_firstName = By.id("firstname");
	By address_lastName = By.id("lastname");
	By company = By.id("company");
	By address = By.id("address1");
	By city = By.id("city");
	By state = By.id("id_state");
	By postalCode = By.id("postcode");
	By mobileNumber = By.id("phone_mobile");
	By submitAccount = By.id("submitAccount");
	By userName = By.id("email");
	By submitLogin = By.id("SubmitLogin");

	public void registrationProcess(String userName, String password) {
		driver.findElement(signIn).click();
		wait.until(ExpectedConditions.titleContains(pageTitle));

		//Enter Email addree and Click on create acccount
		driver.findElement(verifyEmail).sendKeys(userName);
		driver.findElement(createAccount).click();
		wait.until(ExpectedConditions.titleContains(pageTitle));

		//fill the form and submit the details
		wait.until(ExpectedConditions.presenceOfElementLocated(geneder));
		driver.findElement(geneder).click();
		driver.findElement(firstName).sendKeys("Test");
		driver.findElement(lastName).sendKeys("Test");
		driver.findElement(this.password).sendKeys(password);

		new Select(driver.findElement(days)).selectByValue("4");
		new Select(driver.findElement(months)).selectByValue("6");
		new Select(driver.findElement(years)).selectByValue("2014");

		driver.findElement(newsletter).click();
		driver.findElement(option).click();

		//ADDRESS
		driver.findElement(address_firstName).sendKeys("Test");
		driver.findElement(address_lastName).sendKeys("Test");
		driver.findElement(company).sendKeys("Test");
		driver.findElement(address).sendKeys("Test");
		driver.findElement(city).sendKeys("Test");
		new Select(driver.findElement(state)).selectByVisibleText("California");
		driver.findElement(postalCode).sendKeys("00000");

		driver.findElement(mobileNumber).sendKeys("1234567890");
		driver.findElement(submitAccount).click();
		wait.until(ExpectedConditions.titleContains("My account - My Store"));

		//Clik on Signoff button
		signOff();
	}

	public void signOff() {
		driver.findElement(signOut).click();
		wait.until(ExpectedConditions.titleContains(pageTitle));
	}

	public void signIn(String userName, String password) {
		driver.findElement(this.userName).sendKeys(userName);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(submitLogin).click();
		wait.until(ExpectedConditions.titleContains("My account - My Store"));
	}

}

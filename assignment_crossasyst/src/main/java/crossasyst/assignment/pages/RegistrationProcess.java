/**
 * 
 */
package crossasyst.assignment.pages;

import org.openqa.selenium.WebDriver;

import crossasyst.assignment.BasePage;

/**
 * @author Shankar
 *
 */
public class RegistrationProcess {

	WebDriver driver = null;
	BasePage basePage = null;

	public RegistrationProcess(WebDriver driver) {
		this.driver = driver;
		this.basePage = new BasePage();
	}

}

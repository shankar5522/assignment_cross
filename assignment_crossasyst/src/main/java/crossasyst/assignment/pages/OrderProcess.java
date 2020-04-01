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
public class OrderProcess {

	WebDriver driver = null;
	BasePage basePage = null;

	public OrderProcess(WebDriver driver) {
		this.driver = driver;
		this.basePage = new BasePage();
	}
}

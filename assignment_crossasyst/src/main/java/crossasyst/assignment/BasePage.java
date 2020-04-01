/**
 * 
 */
package crossasyst.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Shankar
 *
 */
public class BasePage {

	public WebDriver driver = null;

	public void loadURL(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		WebDriverWait wait = waitInstance(driver, 55);
		wait.until(ExpectedConditions.titleContains("My Store"));

	}

	public WebDriver loadDriver(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Opps! Issue while loading the Browser");
		}
		return driver;
	}

	public WebDriverWait waitInstance(WebDriver driver, long timeOutInSeconds) {
		WebDriverWait wait = null;
		wait = new WebDriverWait(driver, timeOutInSeconds);
		return wait;
	}
}
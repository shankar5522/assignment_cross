/**
 * 
 */
package crossasyst.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import crossasyst.assignment.BasePage;

/**
 * @author Shankar
 *
 */
public class OrderProcess {

	WebDriver driver = null;
	BasePage basePage = null;
	WebDriverWait wait = null;
	Actions actions = null;

	public OrderProcess(WebDriver driver) {
		this.driver = driver;
		this.basePage = new BasePage();
		this.wait = basePage.waitInstance(driver, 50);
		actions = new Actions(driver);
	}

	String getTotalProductAmt = null, getShippingCharges = null, getTax = null, getInvoiceAmt = null;
	By women = By.linkText("Women");
	By quickView = By.xpath("//span[text()='Quick view']");
	By selectProduct = By
			.xpath("//ul[contains(@class,'product_list')]/descendant::img[@alt='Faded Short Sleeve T-shirts']");
	By frameId = By.xpath("//iframe[contains(@id,'fancybox-frame')]");
	By quatity = By.id("quantity_wanted");
	By addToCart = By.name("Submit");
	By proceedToCheckout = By.xpath("//span[contains(text(),'Proceed to checkout')]");

	By totalProductAmount = By.id("total_product");
	By shippingCharges = By.id("total_shipping");
	By tax = By.id("total_tax");
	By invoiceAmount = By.id("total_price");
	By checkout_proceed = By
			.xpath("//p[contains(@class,'cart_navigation')]/descendant::span[contains(text(),'Proceed to checkout')]");
	By termsConditionsCheckout = By.id("cgv");
	By paymentMethodByWire = By.xpath("//a[@title='Pay by bank wire']");
	By orderConfirmation = By.xpath("//span[contains(text(),'I confirm my order')]");

	public void checkoutProduct() {
		driver.findElement(women).click();
		wait.until(ExpectedConditions.titleContains("Women - My Store"));

		actions.moveToElement(driver.findElement(selectProduct)).build().perform();
		driver.findElement(quickView).click();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		driver.findElement(quatity).clear();
		driver.findElement(quatity).sendKeys("2");
		driver.findElement(addToCart).click();

		//switch back to default driver i.e main driver
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(proceedToCheckout)));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(proceedToCheckout).click();

		//sum the price
		actions.moveToElement(driver.findElement(totalProductAmount)).build().perform();
		//wait.until(ExpectedConditions.elementToBeClickable(checkout_proceed));
		getTotalProductAmt = driver.findElement(totalProductAmount).getText();
		getShippingCharges = driver.findElement(shippingCharges).getText();
		getTax = driver.findElement(tax).getText();
		getInvoiceAmt = driver.findElement(invoiceAmount).getText();

		System.out.println(getTotalProductAmt);
		System.out.println(getShippingCharges);
		System.out.println(getTax);
		System.out.println(getInvoiceAmt);
		System.out.println("-----AMOUNT VERIFICATION-------------");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(checkout_proceed).click();
		System.out.println("Order Processing");

		//address Checkout
		actions.moveToElement(driver.findElement(checkout_proceed)).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(checkout_proceed));
		driver.findElement(checkout_proceed).click();
		System.out.println("Address Checked");

		//Terms and condition
		actions.moveToElement(driver.findElement(termsConditionsCheckout)).build().perform();
		driver.findElement(termsConditionsCheckout).click();
		driver.findElement(checkout_proceed).click();
		System.out.println("Terms & Condition Checked");

		//payment method
		actions.moveToElement(driver.findElement(paymentMethodByWire)).build().perform();
		driver.findElement(paymentMethodByWire).click();
		System.out.println("Payment Method Checked");

		//payment confirmation
		actions.moveToElement(driver.findElement(orderConfirmation)).build().perform();
		driver.findElement(orderConfirmation).click();
		System.out.println("Your Order has placed and same can be tracked under order History");
	}
}

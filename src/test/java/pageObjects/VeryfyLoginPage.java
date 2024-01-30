package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VeryfyLoginPage extends BasePage {

	public VeryfyLoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	private WebElement myAccount;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	private WebElement logout;

	@FindBy(xpath = "//h1[normalize-space()='Account Logout']")
	private WebElement accountLogout;

	public boolean confirmLoginMsg() {

		try {

			boolean message = myAccount.isDisplayed();
			return message;

		} catch (Exception e) {

			e.getMessage();
			return false;
		}
	}

	public void loggedOut() {

		logout.click();
	}

	public String logoutConfMsg() {

		try {
			String msg = accountLogout.getText();
			return msg;

		} catch (Exception e) {

			return e.getMessage();

		}

	}

}

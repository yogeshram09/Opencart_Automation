package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {

	public AccountRegisterPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailId;

	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement passConfirm;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicy;

	@FindBy(css = "input[type='submit']")
	private WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement msgConfirmation;

	public void setFirstName(String fname) {

		firstName.sendKeys(fname);
	}

	public void setLastName(String lname) {

		lastName.sendKeys(lname);
	}

	public void setEmail(String email) {

		emailId.sendKeys(email);
	}

	public void setTelePhone(String phone) {

		telephone.sendKeys(phone);
	}

	public void setPassword(String pass) {

		password.sendKeys(pass);
	}

	public void setConfPass(String cpass) {

		passConfirm.sendKeys(cpass);
	}

	public void tickPrivacyPolicy() {

		// Option 1
		privacyPolicy.click();

		// Option 2
		// Actions act = new Actions(driver);
		// act.moveToElement(privacyPolicy).click().perform();

		// Option 3

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click()", privacyPolicy);
	}

	public void clickContinue() {

		btnContinue.click();

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click()", btnContinue);

	}

	public String confirmationMsg() {

		try {

			return (msgConfirmation.getText());
		}

		catch (Exception e) {
			return (e.getMessage());
		}
	}

}

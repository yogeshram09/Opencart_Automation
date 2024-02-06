package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	private WebElement register;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	private WebElement login;

	@FindBy(css = "input[placeholder='Search']")
	private WebElement searchTextBox;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement searchBtn;

	public void click_myAccount() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(myAccount));
		// acceptCookies.click();
		myAccount.click();
	}

	public void click_register_account() {

		register.click();
	}

	public void click_login_account() {

		login.click();
	}

	public void searchProduct(String productName) {

		searchTextBox.sendKeys(productName);
	}

	public void clickSearchButton() {
		searchBtn.click();
	}

}

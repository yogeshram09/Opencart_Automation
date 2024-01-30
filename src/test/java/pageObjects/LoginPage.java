package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = "#input-email")
	private WebElement email;
	@FindBy(css = "#input-password")
	private WebElement password;
	@FindBy(css = "input[value='Login']")
	private WebElement btnLogin;

	public void setLoginEmail(String em) {
        
		//email.clear();
		email.sendKeys(em);
	}

	public void setLoginPass(String pass) {
        
		//password.clear();
		password.sendKeys(pass);
	}

	public void loginButton() {

		btnLogin.click();
	}

}

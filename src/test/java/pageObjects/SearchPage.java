package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//img[@title='MacBook Pro']")
	private List<WebElement> searchProducts;

	@FindBy(xpath = "//input[@id='input-quantity']")
	private WebElement qty;

	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement confMsg;

	public boolean isProductExist(String productName) {

		boolean flag = false;

		for (WebElement product : searchProducts) {

			if (product.getAttribute("title").equals(productName)) {

				flag = true;
				break;
			}

		}
		return flag;
	}

	public void selectProduct(String productName) {

		for (WebElement product : searchProducts) {

			if (product.getAttribute("title").equals(productName)) {
				product.click();

			}
		}
	}

	public void setQuantity(String quantity) {

		qty.clear();
		qty.sendKeys(quantity);

	}

	public void addToCart() {

		addToCartBtn.click();
	}

	public String confirmMessage() {

		try {

			String message = confMsg.getText();
			
			return message;
		}

		catch (Exception e) {

			return e.getMessage();
		}

	}

}

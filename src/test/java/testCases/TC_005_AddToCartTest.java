package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.HomePage;
import pageObjects.SearchPage;

@Test(groups = { "master" })
public class TC_005_AddToCartTest extends BaseClass {

	public void verifyAddToCart() {

		logger.info("*****  Starting TC_005_AddToCartTest *****");

		try {

			HomePage hm = new HomePage(driver);

			hm.searchProduct("MacBook Pro");
			hm.clickSearchButton();

			SearchPage sp = new SearchPage(driver);

			if (sp.isProductExist("MacBook Pro")) {

				sp.selectProduct("MacBook Pro");
				sp.setQuantity("3");
				sp.addToCart();
			}

			String text = sp.confirmMessage();
			System.out.println("Before split:" + text);

			String expected = text.split("×")[0].trim();
			System.out.println("After split:" + expected);

			Assert.assertEquals(expected, "Success: You have added MacBook Pro to your shopping cart!");

		} catch (Exception e) {

			Assert.fail();

		}

		logger.info("*****  Finished TC_005_AddToCartTest *****");

	}
}

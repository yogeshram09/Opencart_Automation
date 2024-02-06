package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.HomePage;
import pageObjects.SearchPage;

@Test(groups = { "master" })
public class TC_004_SearchProductTest extends BaseClass {

	public void verifyProductSearch() {

		logger.info("*****  Starting TC_004_SearchProductTest *****");

		try {

			HomePage hm = new HomePage(driver);

			hm.searchProduct("MacBook Pro");

			hm.clickSearchButton();

			SearchPage sp = new SearchPage(driver);

			boolean product = sp.isProductExist("MacBook Pro");

			Assert.assertEquals(product, true);

		}

		catch (Exception e) {

			Assert.fail();

		}

		logger.info("*****  Finished TC_004_SearchProductTest *****");
	}

}

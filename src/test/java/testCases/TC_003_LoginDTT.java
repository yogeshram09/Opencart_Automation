package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.VeryfyLoginPage;
import utilities.DataProviders;

public class TC_003_LoginDTT extends BaseClass {

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void verifyLoginDTT(String email, String password, String results) {

		logger.info("******* Starting TC_003_LoginDDT  *******");

		try {

			HomePage hm = new HomePage(driver);

			hm.click_myAccount();
			logger.info("===== Clicked my account link =====");

			hm.click_login_account();
			logger.info("===== Clicked login account =====");

			// Login Account

			// Get data from properties file

			logger.info("===== Entering login details from excel sheet =====");
			LoginPage lg = new LoginPage(driver);
			lg.setLoginEmail(email);
			lg.setLoginPass(password);

			lg.loginButton();
			logger.info("===== Clicked login button =====");

			VeryfyLoginPage vlp = new VeryfyLoginPage(driver);

			boolean msg = vlp.confirmLoginMsg();

			logger.info("===== Starting veryfying login message =====");

			if (results.equalsIgnoreCase("Valid")) {

				if (msg == true) {

					vlp.loggedOut();
					Assert.assertTrue(true);
				}

				else {

					Assert.assertTrue(false);

				}

				if (results.equalsIgnoreCase("Invalid")) {

					if (msg = true) {

						vlp.loggedOut();
						Assert.assertTrue(false);
					}

					else {

						Assert.assertTrue(true);
					}
				}
			}

		} catch (Exception e) {

			Assert.fail();
		}

		logger.info("******* Finished TC_003_LoginDDT  *******");
	}

}

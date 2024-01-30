package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.VeryfyLoginPage;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups = { "sanity", "master" })
	public void loginTest() throws IOException {

		logger.info("******* Starting TC_002_AccountLoginTest  *******");

		try {
			HomePage hm = new HomePage(driver);

			hm.click_myAccount();
			logger.info("===== Clicked my account link =====");

			hm.click_login_account();
			logger.info("===== Clicked login account =====");

			// Login Account

			// Get data from properties file

			logger.info("===== Entering login details =====");
			LoginPage lg = new LoginPage(driver);
			lg.setLoginEmail(prop.getProperty("email"));
			lg.setLoginPass(prop.getProperty("password"));

			lg.loginButton();
			logger.info("===== Clicked login button =====");

			VeryfyLoginPage vlp = new VeryfyLoginPage(driver);

			boolean msg = vlp.confirmLoginMsg();

			logger.info("===== Starting veryfying login message =====");

			if (msg == true) {

				logger.info("==== Congratulations..!! successfully Logged-in ====");
				Assert.assertTrue(true);
			}

			else {

				logger.error("==== Oops error...!! please provide valid credential ====");
				Assert.assertTrue(false);
			}

			logger.info("===== Ended veryfied login message =====");

			vlp.loggedOut();

			logger.info("===== Logged out from the application =====");

			String message = vlp.logoutConfMsg();
			logger.info("===== Verified logged out message =====");

			if (message.equals("Account Logout")) {

				logger.info("==== You are successfully Logged-out ====");
				Assert.assertTrue(true);
			}

			else {
				logger.error("==== Not logged-out...!!  ====");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {

			logger.error("==== Login failed...!! ====");
			Assert.fail();
		}

		logger.info("******* Finished TC_002_AccountLoginTest  *******");

	}

}

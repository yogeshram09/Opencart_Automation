package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups = { "regression", "master" })
	public void register_account() {

		logger.info("*****  Starting TC_001_AccountRegistrationTest *****");

		try {

			HomePage hm = new HomePage(driver);

			hm.click_myAccount();
			logger.info("===== Clicked my account link =====");

			hm.click_register_account();
			logger.info("===== Clicked register account link =====");

			// Register Account

			AccountRegisterPage acReg = new AccountRegisterPage(driver);

			logger.info("==== Entering verify details...!! ====");

			acReg.setFirstName(randomString().toUpperCase());
			acReg.setLastName(randomString().toUpperCase());
			acReg.setEmail(randomString() + "@gmail.com"); // randomly generated the email.
			acReg.setTelePhone(randomNumber());

			String pass = randomAlphaNumeric();
			acReg.setPassword(pass);
			acReg.setConfPass(pass);

			acReg.tickPrivacyPolicy();
			logger.info("===== Clicked privacy policy =====");

			acReg.clickContinue();
			logger.info("===== Clicked continue button =====");

			String actualMsg = acReg.confirmationMsg();
			// System.out.println("Message is: " + actualMsg);
			logger.info("===== Starting verifying confirmation message =====");

			if (actualMsg.equals("Your Account Has Been Created!")) {

				logger.info("==== Test passed..!! ====");
				Assert.assertTrue(true);

			}

			else {

				logger.error("==== Test failed..!! ====");
				Assert.assertTrue(false);

			}

			logger.info("===== Finished verified confirmation message =====");

		}

		catch (Exception e) {
			e.getMessage();

			logger.error("==== Something went wrong ====");

			Assert.fail();
		}

		logger.info("*****  Ending TC_001_AccountRegistrationTest *****");
	}

}

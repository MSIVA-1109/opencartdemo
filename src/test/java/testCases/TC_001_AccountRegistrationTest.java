package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC_001_AccountRegistrationTest extends BaseClass {
@Test(groups= {"regression","master"})
public void verify_account_registration()
{
	 logger.info("Starting TC_001_AccountRegistrationTest");
	 //logger.debug("Application Logs...");
	 try 
	 {
	 HomePage hp=new HomePage(driver);
	 hp.clickMyAccount();
	 logger.info("Clicked My Account");
	 hp.clickRegister();
	 logger.info("Clicked Registration Link");
	 logger.info("Entering Customer Details");
	 AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
	 regpage.setFirstName(randomeString().toUpperCase());
	 regpage.setLastName(randomeString().toUpperCase());
	 regpage.setEmail(randomeString()+"@gmail.com");// randomly generate the email 
	 regpage.setTelephone(randomeNumber()); 
	 String  password=randomAlphaNumeric(); 
	 regpage.setPassword(password);
	 regpage.setConfirmPassword(password);
	 regpage.setPrivacyPolicy();
	 regpage.clickContinue();
	 logger.info("Clicked On Continue");
	 String confmsg=regpage.getConfirmationMsg();
	 logger.info("Validating Expected Message"); 
	 if(confmsg.equals("Your Account Has Been Created!"))
	 {
		 logger.info("Test Passed");
		 Assert.assertTrue(true);
	 }
	 else
	 {
		 logger.error("Failed");
		 Assert.fail();
	 }
	  
	}
	catch(Exception e)
	{
		logger.error("Test Failed");
		Assert.fail();
	}
   logger.info("Finished TC_001_AccountRegistrationTest");
}
}

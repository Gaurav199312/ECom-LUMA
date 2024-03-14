package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.baseTest;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.SignInPage;

public class TC001_testLogin extends baseTest {

  @Test
  public void testLogin() {
	  
	  logger.info("Beginning Login Test");
	  
	  try 
	  {
		  LandingPage lp = new LandingPage(driver);
		  lp.clickSignIn();
		  
		  SignInPage si = new SignInPage(driver) ;
		  si.enterEmail(rb.getString("existing_email"));
		  si.enterPassword(rb.getString("existing_pwd"));
		  si.clickSignIn2();
		  
		  HomePage hp = new HomePage(driver);
		  String message=hp.getMsg();
		  
		  hp.clickDropdown();
		  hp.clickSignOut();
		  Assert.assertEquals(message, "Welcome, Harry Potter!");
	  }
	  catch(Exception e)
	  {
		  logger.error("Test failed");
		  e.printStackTrace();
		  Assert.fail();
	  }
	  finally 
	  {
		  logger.info("Test Execution complete");
	  }
	  }
	  
  }


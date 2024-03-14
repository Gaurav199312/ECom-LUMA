package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.baseTest;
import pageObjects.LandingPage;
import pageObjects.MyAccountPage;
import pageObjects.NewCustomerPage;

public class TC002_createNewUser extends baseTest {
  @Test
  public void createNewUser() {
	  
	  try {
		  LandingPage lp = new LandingPage(driver);
		  lp.clickCreateAccount();
		  
		  NewCustomerPage ncp = new NewCustomerPage(driver);
		  ncp.enterfirstName(randomString());
		  ncp.enterLastName(randomString());
		  ncp.enterEmail(randomEmail());
		  
		  String ran_pwd=randomPwd();
		  ncp.enterPassword(ran_pwd);
		  ncp.confirmPassword(ran_pwd);
		  ncp.createNewAccount();
		  
		  
		  MyAccountPage mp=new MyAccountPage(driver);
		  Thread.sleep(5000);
		  String result=mp.getSuccessMessage();
		  
		  Assert.assertEquals(result, "Thank you for registering with Main Website Store.");
		  
	  }
	  catch(Exception e) {
		  System.out.println(e.getMessage());
		  e.printStackTrace();
		  
		  Assert.fail();
	
	  }
  }
  
}

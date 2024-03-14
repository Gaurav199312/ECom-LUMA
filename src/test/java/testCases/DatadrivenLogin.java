package testCases;

import org.testng.annotations.Test;

import baseTest.baseTest;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.SignInPage;
import utilities.DataProviderUtility;



public class DatadrivenLogin extends baseTest {
	
	
  @Test(dataProvider="LoginData",dataProviderClass=DataProviderUtility.class)
  public void DatadrivenLoginTests(String email, String password) {
	  try {
		  LandingPage lp = new LandingPage(driver);
		  lp.clickSignIn();
		  
		  SignInPage si = new SignInPage(driver) ;
		  si.enterEmail(email);
		  si.enterPassword(password);
		  si.clickSignIn2();
		  
		  HomePage hp = new HomePage(driver);
		  
		  hp.clickDropdown();
		  hp.clickSignOut();
	  }
	  catch(Exception e) {
		  e.printStackTrace();
		  System.out.println(e.getMessage());
	  }
  }
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(linkText = "Sign In")
	WebElement sign_in_btn;	
	
	@FindBy(linkText = "Create an Account")
	WebElement create_account_btn;
	
	public void clickSignIn() {
		sign_in_btn.click();		
	}
	
	public void clickCreateAccount() {
		create_account_btn.click();		
	}
	


}

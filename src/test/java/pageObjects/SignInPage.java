package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "email")
	WebElement email_box;
	
	@FindBy(id = "pass")
	WebElement pwd_box;
	
	@FindBy(id = "send2")
	WebElement signInbtn2;
	
	public void enterEmail(String em) {
		email_box.sendKeys(em);
	}
	
	public void enterPassword(String pw) {
		pwd_box.sendKeys(pw);		
	}
	
	public void clickSignIn2() {
		signInbtn2.click();		
	}
	
	
	
	

}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCustomerPage extends BasePage {

	public NewCustomerPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "firstname")
	WebElement firstNamebox;
	
	@FindBy(id = "lastname")
	WebElement lastNamebox;
	
	@FindBy(id = "email_address")
	WebElement email;
	
	@FindBy(id = "password")
	WebElement pwd;
	
	@FindBy(id = "password-confirmation")
	WebElement confirm_pwd;
	
	@FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	WebElement create_acc_btn;
	
	
	public void enterfirstName(String fname) {
		firstNamebox.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		lastNamebox.sendKeys(lname);		
	}
	
	public void enterEmail(String em) {
		email.sendKeys(em);
	}
	
	public void enterPassword(String pw) {
		pwd.sendKeys(pw);		
	}
	
	public void confirmPassword(String pw2) {
		confirm_pwd.sendKeys(pw2);		
	}
	
	public void createNewAccount() {
		create_acc_btn.click();;		
	}

}

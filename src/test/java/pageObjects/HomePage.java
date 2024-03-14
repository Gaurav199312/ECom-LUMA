package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//span[@class='customer-name']//button[@type='button']")
	WebElement ac_dd;
	
	@FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Harry Potter!']")
	WebElement text;
	
	@FindBy(linkText = "Sign Out")
	WebElement sign_Out;
	
	
	public void clickDropdown() {
		ac_dd.click();		
	}
	
	public void clickSignOut() {
		sign_Out.click();		
	}
	
	public String getMsg() {
		String msg= text.getText();
		return msg;
	}


	
	
	

}

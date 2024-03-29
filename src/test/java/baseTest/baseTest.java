package baseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseTest {
	
	public static WebDriver driver;
	
	public Logger logger;
	public ResourceBundle rb;
	public WebDriverWait w1;
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	
	{
		rb=ResourceBundle.getBundle("config");
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		
		
		logger=LogManager.getLogger(this.getClass());  //logging
		
		if(br.equalsIgnoreCase("chrome")) 
		{
			driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else{
			driver=new ChromeDriver();
		}
		
		
		
				
				
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		
		driver.get(rb.getString("appURL"));
				
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	
	}
	
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return (generatedString);
	}

	public String randomNumber() {
		String generatedNum = RandomStringUtils.randomNumeric(5);
		return (generatedNum);
	}
	
	public String randomEmail() {
		String generatedemail = RandomStringUtils.randomAlphabetic(6)+RandomStringUtils.randomNumeric(3)+"@gmail.com";
		return (generatedemail);
	}
	
	public String randomPwd() {
		String cap=RandomStringUtils.randomAlphabetic(1).toUpperCase();
		String generatedpwd = cap+RandomStringUtils.randomAlphabetic(6)+"@"+RandomStringUtils.randomNumeric(3);
		return (generatedpwd);
	}
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}

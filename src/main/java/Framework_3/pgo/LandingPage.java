package Framework_3.pgo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulsheetyacademy.abstactcomp.abstractcomponents;

public class LandingPage extends abstractcomponents{
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	 
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement userPassword;
	@FindBy(id="login")
	WebElement login;
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;
	public productcatalogue loginApplication(String email,String passwd) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(passwd);
		productcatalogue pg= new productcatalogue(driver);
		login.click();
		return pg;
		
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	public  String ErrorMessageDisplay() {
		waituntilelement(errormessage);
		return errormessage.getText();
	}
}
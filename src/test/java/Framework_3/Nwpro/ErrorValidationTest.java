package Framework_3.Nwpro;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



import Framework_3.pgo.LandingPage;
import Framework_3.pgo.productcatalogue;
import Framework_3.pgo.selectionpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationTest extends BaseTest {
	
	public WebDriver driver;

	@Test(groups= {"ErrorHandling"},retryAnalyzer=reTestA.class)
	public void Standalo() throws IOException, InterruptedException {
		driver=intializeDriver();
		
		 lp= new LandingPage(driver);
			lp.goTo();
		
		// TODO Auto-generated method stub
		String productName="ZARA COAT 3";
	productcatalogue pg=lp.loginApplication("santoshpavan.111@gmail.com","Pavaan@558");
		String ErrorMessages=lp.ErrorMessageDisplay();
		Assert.assertEquals("Incorrect email or password.",ErrorMessages);
		
	    System.out.println(ErrorMessages);

		
		
		
	}
	

		
	}



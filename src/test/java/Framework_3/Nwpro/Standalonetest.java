package Framework_3.Nwpro;

import java.awt.Desktop.Action;
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

import Framework_3.pgo.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalonetest {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		LandingPage lp= new LandingPage(driver);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("userEmail")).sendKeys("santoshpavan.111@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Pavan@558");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

	    List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

	    WebElement prod = products.stream().filter(product->

	product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	    

	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	List<WebElement> cartproducts=driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
	boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase("ZARA COAT 3"));
	Assert.assertTrue(match);
	driver.findElement(By.cssSelector(".totalRow button")).click();
	Actions a = new Actions(driver);

	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	driver.findElement(By.xpath("(//button/span)[2]")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	String ThanksMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	System.out.println(ThanksMessage);
	Assert.assertTrue(ThanksMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	driver.close();


		
		
		
	
	}

}

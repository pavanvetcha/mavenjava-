package Framework_3.Nwpro;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework_3.pgo.Cartpage;
import Framework_3.pgo.LandingPage;
import Framework_3.pgo.OrderPage;
import Framework_3.pgo.productcatalogue;
import Framework_3.pgo.selectionpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalonetest3 extends BaseTest {
	String productName="ZARA COAT 3";
	public WebDriver driver;

	@Test(dataProvider="getDataa")
	public void Standalo(HashMap<String,String> input) throws IOException, InterruptedException {
		driver=intializeDriver();
		
		 lp= new LandingPage(driver);
		lp.goTo();
		productcatalogue pg=lp.loginApplication(input.get("email"),input.get("password"));
		pg.getProducts();
		pg.getProductName(productName);
		pg.Addtocart(productName);
		pg.AddtoCart();

	Cartpage cg=new Cartpage(driver);
	boolean match=cg.cartPagecheck(productName);		
		Assert.assertTrue(match);
		cg.checkedOut();

		selectionpage sg= new selectionpage(driver);
		
		sg.autoSelction("Indonesia");
	
		
	    sg.PaceOrderButton();

		}
//

//	
//	}
//	
//	//	
//
//();
//	String ThanksMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
//	System.out.println(ThanksMessage);
//	Assert.assertTrue(ThanksMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//	driver.close();

	@Test(dependsOnMethods= {"Standalo"})
	public void OrderTest() throws InterruptedException, IOException {
		driver=intializeDriver();
		
		 lp= new LandingPage(driver);
			lp.goTo();
		productcatalogue pg=lp.loginApplication("santoshpavan.111@gmail.com","Pavan@558");
		lp.gotoMyOrders();
		OrderPage o=new OrderPage(driver);

			
			o.OrderPageCheck(productName);
			
	}
		
//		
//		@DataProvider
//		public Object[][] getData() {
//			return new Object[][] {{"santoshpavan.111@gmail.com","Pavan@558"},{"pavanvetcha558@gmail.com","pavanvetcha@558"}};
//		}
	
		@DataProvider
		public Object[][] getDataa() {
		HashMap map=new HashMap<String,String>();
		map.put("email","santoshpavan.111@gmail.com");
		map.put("password","Pavan@558");
		
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("email","pavanvetcha558@gmail.com");
		map1.put("password","Hemanth@4435");

//		public Object[][] getDataa() throws IOException {
//						List<HashMap<String, String>> Data=getDatapro(System.getProperty("user.dir")+"\\src\\test\\java\\rahulsheetyacademy\\data\\purchase.json");
			
			return new Object[][]{ {map},{map1}};
			
		}
		

		
	}

//HashMap<String,String> map=new HashMap<String,String>();
//map.put("email","santoshpavan.111@gmail.com");
//map.put("password","Pavan@558");
//
//HashMap<String,String> map1=new HashMap<String,String>();
//map1.put("email","pavanvetcha558@gmail.com");
//map1.put("password","Hemanth@4435");



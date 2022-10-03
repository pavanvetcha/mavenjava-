package Framework_3.pgo;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulsheetyacademy.abstactcomp.abstractcomponents;

public class productcatalogue extends abstractcomponents{
	WebDriver driver;

	public productcatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	 
	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement invisible;
	@FindBy(css= "[routerlink*='cart']")
	WebElement checkout;
	
	By ProductWait=(By.cssSelector(".mb-3"));
	By Addtocart=(By.cssSelector(".card-body button:last-of-type"));
	By placeordersync=(By.cssSelector("#toast-container"));


	public List<WebElement> getProducts() {
		waituntilelementFound(ProductWait);
		
		return products;
		
	}
	public WebElement getProductName(String productName) {
		WebElement prod=getProducts().stream().filter(product->
		 	product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	
		return prod;
		
	}
	public void Addtocart(String productName) throws InterruptedException {
		WebElement prod=getProducts().stream().filter(product->
	 	product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
	waituntilelementFound(placeordersync);
		
	waituntilnotFound(invisible);
		prod.findElement(Addtocart).click();
		Thread.sleep(3000);
		
		
		
		
		
		
	}
////public void checkedOut() throws InterruptedException {
//		Thread.sleep(3000);
//		checkoutpag.click();
//		Thread.sleep(3000);
//}
		
	
	
	
		
	
}
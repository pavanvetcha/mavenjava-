package Framework_3.pgo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulsheetyacademy.abstactcomp.abstractcomponents;

public class Cartpage extends abstractcomponents{
	WebDriver driver;

	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	@FindBy(css=".totalRow button")
	WebElement checkoutpag;
	

	 
	
	public Boolean cartPagecheck(String productName ) throws InterruptedException {
		Thread.sleep(3000);
		
		Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		System.out.println("iam good to have");
		return match;
	}	
	public void checkedOut() throws InterruptedException {
		Thread.sleep(3000);
		checkoutpag.click();
		Thread.sleep(3000);
}
}
package Framework_3.pgo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulsheetyacademy.abstactcomp.abstractcomponents;

public class OrderPage extends abstractcomponents{
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".tr td:nth-child(3)")
	List<WebElement> orderproducts;
	
	

	 
	
	public boolean OrderPageCheck(String productName ) throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Iam pavan");
		 boolean match=orderproducts.stream().anyMatch(orderproduct->orderproduct.getText().equalsIgnoreCase(productName));
		System.out.println("Iam pavan1");
		return match;
	}	
	
}
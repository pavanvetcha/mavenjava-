package rahulsheetyacademy.abstactcomp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework_3.pgo.OrderPage;

public class abstractcomponents {
	WebDriver driver;
	

	public abstractcomponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartpa;
	@FindBy(css=".btn.btn-custom[routerlink='/dashboard/myorders']")
	WebElement myorders;
	
	public void waituntilelementFound(By findby)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findby));

	}
	public void waituntilelement(WebElement findby)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findby));

	}

	public void waituntilnotFound(WebElement ele) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public void AddtoCart()
	{
		cartpa.click();
	}
	public void gotoMyOrders() throws InterruptedException {
		Thread.sleep(3000);
		myorders.click();
		Thread.sleep(3000);
			
	}
}


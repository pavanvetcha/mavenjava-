package Framework_3.pgo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import rahulsheetyacademy.abstactcomp.abstractcomponents;

public class selectionpage extends abstractcomponents  {
	public WebDriver driver;
	public selectionpage(WebDriver driver) throws InterruptedException {
		super(driver);
		
		this.driver=driver;
		
		
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectcountry;
	@FindBy(css=".ta-results button:last-child")
	WebElement clickable;
	@FindBy(css=".action__submit")
	WebElement placeorder;
	
	By waitforselecting=By.cssSelector(".ta-results");
			public void autoSelction(String countryname)  {
				
				Actions a = new Actions(driver);
				a.sendKeys(selectcountry,countryname).build().perform();
				waituntilelementFound(waitforselecting);
				clickable.click();
				}
			public void PaceOrderButton() {
				placeorder.click();
			}
}

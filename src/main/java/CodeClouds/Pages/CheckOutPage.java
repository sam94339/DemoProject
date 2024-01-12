package CodeClouds.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class CheckOutPage extends AbstractClass {
	
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By dropdownList = By.xpath("//section[@class = 'ta-results list-group ng-star-inserted']");
	By btn = By.xpath("//a[@class = 'btnn action__submit ng-star-inserted']");
	
	@FindBy(xpath = "//div[@class = 'form-group']/input")
	WebElement CountryFld;
	
	@FindBy(xpath = "//button[@class = 'ta-item list-group-item ng-star-inserted'][2]")
	WebElement dropdownOption;
	
	@FindBy(xpath = "//a[@class = 'btnn action__submit ng-star-inserted']")
	WebElement placeorderBtn;
	
	public ThankYouPage checkoutOperation(String country) {
		
		CountryFld.sendKeys(country);
		checkoutPagedropdownList(dropdownList);
		dropdownOption.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		checkoutpagePlaceorderbtn(btn);
		
		placeorderBtn.click();
		
		ThankYouPage thankyoupage = new ThankYouPage(driver);
		return thankyoupage;
		
	}
	

}

package CodeClouds.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class OrderPage extends AbstractClass{
	
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> orderProducts;
	
	public boolean orderproductsvalidation(String product) {
		
		for(int i = 0; i<orderProducts.size(); i++) {
			
			String productName = orderProducts.get(i).getText();
			
			if(productName.equalsIgnoreCase(product)) {
				
				return true;
			}
			
		}
		return false;
		
	}
	
	
}

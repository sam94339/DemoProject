package CodeClouds.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class CartPage extends AbstractClass{
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class = 'cartSection']/h3")
	static
	List<WebElement> CartProducts;
	
	@FindBy(xpath = "//li[@class = 'totalRow']/button")
	WebElement checkoutbtn;

	public static boolean cartproductchecking(String CartPageProduct) {
		
		
		for(int i = 0; i<CartProducts.size(); i++) {
			
			String cartproductname = CartProducts.get(i).getText();
			
			if(cartproductname.equalsIgnoreCase(CartPageProduct)) {
				
				return true;
			}
		}
		return false;
	}
	
	public CheckOutPage proceedtocheckout() {
		
		checkoutbtn.click();
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		return checkoutpage;
	}

}

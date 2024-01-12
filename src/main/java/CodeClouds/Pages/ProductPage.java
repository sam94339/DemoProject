package CodeClouds.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class ProductPage extends AbstractClass{
	
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By productwait = By.xpath("//div[@class = 'card-body']/h5/b");
	By toasmessagewait = By.cssSelector("#toast-container");
	
	@FindBy(xpath = "//div[@class = 'card-body']/h5/b")
	List<WebElement> poductList;
	
	@FindBy(xpath = "//button[@class = 'btn w-10 rounded']")
	List<WebElement> AddtoCartBtn;
	
	@FindBy(css = ".ng-animating")
	WebElement loaderAnimation;

	
	public void productAddToCart(String product) {
		
		productCatalogappear(productwait);
		
		for(int i = 0; i<poductList.size();i++) {
			
			String products = poductList.get(i).getText();
			
			if(products.equalsIgnoreCase(product)) {
				
				AddtoCartBtn.get(i).click();
			}
		}
		
		toastMessagedisappear(toasmessagewait);
		loaderdisappear(loaderAnimation);
		
	}
	
	public CartPage gotoCart() {
		
		CartHeader();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
		
	}
	

}

package Abstract;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CodeClouds.Pages.OrderPage;

public class AbstractClass {
	
	WebDriver driver;
	
	public AbstractClass(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement CartOption;
	
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement headerOrder;
	
	public void productCatalogappear(By Byfound) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Byfound));
	}
	
	public void toastMessagedisappear(By Byfound) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Byfound));
	}
	
	public void loaderdisappear(WebElement loader) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(loader));
	}
	
	public void checkoutPagedropdownList(By Byfound) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Byfound));
	}
	
	public void checkoutpagePlaceorderbtn(By Byfound) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Byfound));
	}
	
	public void CartHeader() {
		
		CartOption.click();
	}
	
	public OrderPage OrderHeader() {
		
		headerOrder.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
		
	}

}

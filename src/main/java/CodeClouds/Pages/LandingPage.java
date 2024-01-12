package CodeClouds.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class LandingPage extends AbstractClass{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="userEmail")
	WebElement email;
	
	@FindBy (id="userPassword")
	WebElement password;
	
	@FindBy (id="login")
	WebElement Loginbtn;
	
	@FindBy(xpath = "//div[contains(text(),'Incorrect email or password.')]")
	WebElement loginValidation;


	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductPage proceedToLogin(String emilID, String pass) {
		
		email.sendKeys(emilID);
		password.sendKeys(pass);
		Loginbtn.click();
		ProductPage productpage = new ProductPage(driver);
		return productpage;
	}
	
	public String loginvalidate() {
		
		String message = loginValidation.getText();
		return message;
	}

}

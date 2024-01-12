package CodeClouds.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstract.AbstractClass;

public class ThankYouPage extends AbstractClass{
	
	WebDriver driver;

	public ThankYouPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[@class='hero-primary']")
	WebElement thankyoumessage;
	
	public String messagetext() {
		
		String message = thankyoumessage.getText();
		return message;
	}

}

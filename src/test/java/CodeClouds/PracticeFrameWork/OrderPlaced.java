package CodeClouds.PracticeFrameWork;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackage.BaseTest;
import CodeClouds.Pages.CartPage;
import CodeClouds.Pages.CheckOutPage;
import CodeClouds.Pages.LandingPage;
import CodeClouds.Pages.OrderPage;
import CodeClouds.Pages.ProductPage;
import CodeClouds.Pages.ThankYouPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderPlaced extends BaseTest{
	
	
	@Test(dataProvider = "dataprovider")
	public void submitOrder(HashMap<String, String> input) throws IOException {
		
		
		ProductPage productpage = landingPage.proceedToLogin(input.get("email"), input.get("password"));
		productpage.productAddToCart(input.get("product"));
		
		CartPage cartpage = productpage.gotoCart();
		
		Assert.assertTrue(CartPage.cartproductchecking(input.get("product")));
		
		CheckOutPage checkoutpage = cartpage.proceedtocheckout();
		
		ThankYouPage thankyoupage = checkoutpage.checkoutOperation("ind");
		
		Assert.assertEquals(thankyoupage.messagetext(), "THANKYOU FOR THE ORDER.");

	}
	
	@Test(dataProvider = "dataprovider", dependsOnMethods = {"submitOrder"})
	public void cartVerify(HashMap<String, String> input1) {
		
		ProductPage productpage = landingPage.proceedToLogin(input1.get("email"), input1.get("password"));
		OrderPage orderpage = productpage.OrderHeader();
		Assert.assertTrue(orderpage.orderproductsvalidation(input1.get("product")));
		
	}
	
	@DataProvider
	public Object[][] dataprovider() throws IOException {
		
		List<HashMap<String, String>> data = dataConvert(System.getProperty("user.dir")+"//src//test//java//dataPackage//OrderData.json");
		
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
	}
	
	
}

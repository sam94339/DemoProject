package CodeClouds.PracticeFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("sam94339@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("123456#Aa");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		List<WebElement> productname = driver.findElements(By.xpath("//div[@class = 'card-body']/h5/b"));
		
		for(int i = 0; i<productname.size();i++) {
			
			String products = productname.get(i).getText();
			
			if(products.equalsIgnoreCase("ZARA COAT 3")) {
				
				driver.findElements(By.xpath("//button[@class = 'btn w-10 rounded']")).get(i).click();
			}
		}
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		Assert.assertTrue(cartproductchecking());
		
		driver.findElement(By.xpath("//li[@class = 'totalRow']/button")).click();
		
		driver.findElement(By.xpath("//div[@class = 'form-group']/input")).sendKeys("ind");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class = 'ta-results list-group ng-star-inserted']")));
		
		driver.findElement(By.xpath("//button[@class = 'ta-item list-group-item ng-star-inserted'][2]")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class = 'btnn action__submit ng-star-inserted']")));
		
		driver.findElement(By.xpath("//a[@class = 'btnn action__submit ng-star-inserted']")).click();
		
		String tnakYouMessage = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		
		Assert.assertEquals(tnakYouMessage, "THANKYOU FOR THE ORDER.");
		
	}
	
	public static boolean cartproductchecking() {
		
		List<WebElement> cartproducts = driver.findElements(By.xpath("//div[@class = 'cartSection']/h3"));
		
		for(int i = 0; i<cartproducts.size(); i++) {
			
			String cartproductname = cartproducts.get(i).getText();
			
			if(cartproductname.equalsIgnoreCase("zara coat 3")) {
				
				return true;
			}
		}
		return false;
	}

}

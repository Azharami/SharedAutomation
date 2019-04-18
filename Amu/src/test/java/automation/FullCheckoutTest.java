package automation;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ami.framework.LocatorObj;
import ami.framework.WrapperMethod;
import ami.framework.configReader;

public class FullCheckoutTest {
	WrapperMethod wm= new WrapperMethod();
	LocatorObj userName = new LocatorObj("email", "Login_id", LocatorObj.ID);
	LocatorObj password = new LocatorObj("passwd", "Login_password", LocatorObj.ID);
	
	@BeforeTest
	//Screenshot name
	
	public void init() {
		String testFolder = this.getClass().getSimpleName();
		//wm.invokeBrowser("chrome", "http://automationpractice.com/index.php");
		
	}
	
	@Test
	public void Checkout() throws InterruptedException {
		// TODO Auto-generated method stu0
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/Ami/Desktop/Automation_Drivers/chromedriver 2");
		driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
	
		WebElement products = driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ul"));
		List<WebElement> productlist = products.findElements(By.tagName("li"));
		System.out.println(productlist.size());
		//Select the product from catgory
		Actions actions = new Actions(driver);
		WebElement hProduct= driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ul/li[1]"));
		actions.moveToElement(hProduct).build().perform();
		
		//Add the item into cart
		WebElement addCart = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]"));
		actions.moveToElement(addCart);
		actions.click().build().perform();
		
		//Proceed to checkout page from cart popup
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement pCheckout = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a.btn.btn-default.button.button-medium"))));
		pCheckout.click();
		
		//Checkout from order detail page
		
		driver.findElement(By.xpath("//*[@id='order-detail-content']/following-sibling::p/a[1]")).click();
		
		//Continue with signing in
		
		
		wm.enterText(userName, "test0554@gmail.com", driver);
		wm.enterText(password, "Ami@2015", driver);
		
		
		driver.findElement(By.id("SubmitLogin")).click();
		driver.findElement(By.name("processAddress")).click();
		
		//Agree policy and Continue from shipping page
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.name("processCarrier")).click();
		
		//Payment selection
		driver.findElement(By.className("bankwire")).click();
		
		//Confirm order
		driver.findElement(By.xpath("//*[@id='cart_navigation']/button")).click();
		
		
		
	}

}

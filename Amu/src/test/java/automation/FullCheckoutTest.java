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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ami.framework.LocatorObj;
import ami.framework.SeleniumActions;
import ami.framework.ConfigReader;

public class FullCheckoutTest extends SeleniumActions {
	

	public WebDriver webDriverfullFlow;
	
	public LocatorObj userName = new LocatorObj("email",LocatorObj.ID);
	public LocatorObj password = new LocatorObj("passwd",LocatorObj.ID);
	public LocatorObj submit = new LocatorObj("SubmitLogin",LocatorObj.ID);
	
	public ConfigReader Config = new ConfigReader();
	
	
	
	
	@BeforeTest
	@Parameters("browser")
	
	
	public void init(String browser) {
		String testFolder = this.getClass().getSimpleName();
		webDriverfullFlow = Config.initDriver(browser);
		openUrl("http://automationpractice.com/index.php",webDriverfullFlow);
		
	}
	
	@Test
	public void Checkout() throws InterruptedException {
		
		// TODO Auto-generated method stu0
		
		
		WebElement products = webDriverfullFlow.findElement(By.xpath("//*[@id='center_column']/div[1]/ul"));
		List<WebElement> productlist = products.findElements(By.tagName("li"));
		System.out.println(productlist.size());
		//Select the product from catgory
		
		Actions actions = new Actions(webDriverfullFlow);
		WebElement hProduct= webDriverfullFlow.findElement(By.xpath("//*[@id='center_column']/div[1]/ul/li[1]"));
		actions.moveToElement(hProduct).build().perform();
		
		//Add the item into cart
		WebElement addCart = webDriverfullFlow.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]"));
		actions.moveToElement(addCart);
		actions.click().build().perform();
		
		//Proceed to checkout page from cart popup
		WebDriverWait wait = new WebDriverWait(webDriverfullFlow,20);
		WebElement pCheckout = wait.until(ExpectedConditions.visibilityOf(webDriverfullFlow.findElement(By.cssSelector("a.btn.btn-default.button.button-medium"))));
		pCheckout.click();
		
		//Checkout from order detail page
		
		webDriverfullFlow.findElement(By.xpath("//*[@id='order-detail-content']/following-sibling::p/a[1]")).click();
		
		//Continue with signing in
		enterText(userName, "test0554@gmail.com",webDriverfullFlow)
			.enterText(password, "Ami@2015",webDriverfullFlow); 
		click(submit,webDriverfullFlow);
		
		webDriverfullFlow.findElement(By.name("processAddress")).click();
		
		//Agree policy and Continue from shipping page
		webDriverfullFlow.findElement(By.id("cgv")).click();
		webDriverfullFlow.findElement(By.name("processCarrier")).click();
		
		//Payment selection
		webDriverfullFlow.findElement(By.className("bankwire")).click();
		
		//Confirm order
		webDriverfullFlow.findElement(By.xpath("//*[@id='cart_navigation']/button")).click();
		
		
		
	}

	@AfterTest
	public void afterTest(){
		closeBrowser(webDriverfullFlow);
	}



}

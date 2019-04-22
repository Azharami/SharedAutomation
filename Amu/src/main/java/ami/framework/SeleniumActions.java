package ami.framework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumActions {
	
	
	int i =0;
	
	public SeleniumActions openUrl(String strUrl,WebDriver webDriver) {
		try {
			webDriver.get(strUrl);
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public SeleniumActions enterText(LocatorObj locator,String text,WebDriver webDriver) {
		try {
			webDriver.findElement(locator.locatorValue).sendKeys(text);
		}catch(WebDriverException ex) {
			System.out.println("Unable to enterText"+ex.getMessage());
		}
		return this;
	}
	
	public SeleniumActions click(LocatorObj locator,WebDriver webDriver) {
		try {
			WebDriverWait wait = new WebDriverWait(webDriver,20);
			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(locator.locatorValue));
			clickableElement.click();
		}catch(WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	public void takesnap(String testFolderName,WebDriver webDriver) throws IOException {
		File src= ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/Ami/git/SharedAutomation/Amu/resourceDirectory/Snap"+i+".jpeg"));
		i++; 
	}
	
	

}

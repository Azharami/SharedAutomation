package ami.framework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class WrapperMethod {
	public WebDriver driver;
	int i =0;
	
	
	public WrapperMethod enterText(LocatorObj locator,String text,WebDriver driver) {
		try {
			driver.findElement(locator.locatorValue).sendKeys(text);
		}catch(WebDriverException ex) {
			System.out.println("Unable to enterText"+ex.getMessage());
		}
		return this;
	}
	
	public void takesnap(String testFolderName) throws IOException {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/Ami/git/SharedAutomation/Amu/resourceDirectory/Snap"+i+".jpeg"));
		i++; 
	}
	
	

}

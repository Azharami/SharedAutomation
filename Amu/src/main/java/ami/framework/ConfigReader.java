package ami.framework;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigReader {
	
	WebDriver webDriver;
	public Properties properties;
	public final String propertyFilePath= "resource/Configuration.properties";
	
	 
	 public ConfigReader(){
	 BufferedReader reader;
	 try {
	 reader = new BufferedReader(new FileReader(propertyFilePath));
	 properties = new Properties();
	 try {
	 properties.load(reader);
	 reader.close();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 } 
	 }
	 
	 	 public String getApplicationUrl() {
		 String url = properties.getProperty("prt_Url");
		 if(url != null) return url;
		 else throw new RuntimeException("url not specified in the Configuration.properties file.");
		 }
	 	 
	 	public String getDriverPath(){
	 		 String driverPath = properties.getProperty("driverPath");
	 		 if(driverPath!= null) return driverPath;
	 		 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
	 		 }

	 		 public String getUserName(){
	 	String userName = properties.getProperty("prt_Uname");
				 if(userName!= null) return userName;
				 else throw new RuntimeException("User name not specified in the Configuration.properties file.");
			 }

	public String getPassword(){
		String userPassword = properties.getProperty("prt_pwd");
		if(userPassword!= null) return userPassword;
		else throw new RuntimeException("User password not specified in the Configuration.properties file.");
	}


	public WebDriver initDriver(String browser) {
		
		
		switch(browser) {
		case "Chrome":
			webDriver = getChromeDriver();
			break;
		case "Firefox":
			webDriver = getFirefoxDriver();
			break;
		default:
			throw new RuntimeException("Unsupported browser"+browser);
		}
		return webDriver;
		
		
	}
	 
	private WebDriver getChromeDriver() {
		
		
		try {
			System.setProperty("webdriver.chrome.driver",getDriverPath());
			webDriver = new ChromeDriver();
		}catch(WebDriverException webdriverException) {
		
			throw new RuntimeException("unable to start chrome driver",webdriverException);
			
		}
		return webDriver;
	}
	private WebDriver getFirefoxDriver() {
		try {
			System.setProperty("webdriver.gecko.driver",properties.getProperty("driverPath"));
			webDriver = new ChromeDriver();
		}catch(WebDriverException webdriverException) {
		
			throw new RuntimeException("unable to start chrome driver",webdriverException);
			
		}
		return webDriver;
	}
	}
	


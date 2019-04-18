package ami.framework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	
	private static Properties properties;
	
	private final String propertypath="/Users/Ami/git/SharedAutomation/Amu/resourceDirectory/ami.properties";
	
	 public configReader(){
		 BufferedReader reader;
		 try {
		 reader = new BufferedReader(new FileReader(propertypath));
		 properties = new Properties();
		 try {
		 properties.load(reader);
		 reader.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Configuration.properties not found at " + propertypath);
		 } 
		 }
	 
	 	 public String getApplicationUrl() {
		 String url = properties.getProperty("prt_Url");
		 if(url != null) return url;
		 else throw new RuntimeException("url not specified in the Configuration.properties file.");
		 }
	 	 
		public static String getDriverPath(){
			String driverPath = properties.getProperty("prt_driverpath");
			if(driverPath!= null) return driverPath;
			else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
		}
	
		
	}
	


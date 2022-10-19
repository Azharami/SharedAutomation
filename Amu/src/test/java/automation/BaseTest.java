package automation;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

	
public class BaseTest {
	
	String path="resource/Snap";
	@BeforeClass
	public void createFolder(String path) {
		
			File testDirectory = new File(path);
			if (!testDirectory.exists()) {
				if (testDirectory.mkdir()) {
					System.out.println("Directory: " + path + " is created!");
				} else {
					System.out.println("Failed to create directory: " + path);
				}
			} else {
				System.out.println("Directory already exists: " + path);
			}
		}
	}



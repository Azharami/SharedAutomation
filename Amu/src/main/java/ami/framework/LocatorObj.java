package ami.framework;

import org.openqa.selenium.By;

public class LocatorObj {
	public String objectValue;
	public String objDescription;
	By locatorValue;
	public static final String ID ="ID";
	public static final String CSS ="CSS";
	public static final String XPATH ="XPATH";
	public static final String LINK_TEXT ="LINKTEXT";
	public static final String PARTIAL_LINK_TEXT ="PARTIALLINKTEXT";
	public static final String CLASS ="CLASS";
	public static final String NAME ="NAME";
	private String strLocatorType;
	
	public LocatorObj(String locator,String LocatorDescription,String locatorType) {
		objectValue=locator;
		this.locatorValue =getLocatorObject(objectValue,locatorType);
		this.objDescription= LocatorDescription;
		strLocatorType = locatorType;
	}
	
	public By getLocatorObject(String locator,String locatorType) {
		switch(locatorType.toUpperCase()) {
		case ID:
			locatorValue = By.id(locator);
			break;
		case CSS:
			locatorValue = By.cssSelector(locator);
			break;
		case XPATH:
			locatorValue = By.xpath(locator);
			break;
		case LINK_TEXT:
			locatorValue = By.linkText(locator);
			break;
		case PARTIAL_LINK_TEXT:
			locatorValue = By.partialLinkText(locator);
			break;
		case CLASS:
			locatorValue = By.className(locator);
			break;
		case NAME:
			locatorValue = By.name(locator);
			break;
		}
		return locatorValue;
	}
	

}

package Keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class Validationkeywords extends GenericKeywords {
	
	public Boolean validateTitle(String expTitle) {
		Assert.assertEquals(getTitle(),expTitle,"Title doesn't match...........");
		return false;
	}

	
	
	public void validateText(String locatorKey,String text) {
		softAssert.assertTrue(getText(locatorKey).contains(text),"Text is not matched");
	}
	
	
	
	public void validateRadioCheckOption(String locatorkey,String text) {
		String status=getElement(locatorkey).findElement(By.xpath("input[@value='"+text+"']")).getAttribute("checked");
	    softAssert.assertEquals(status,"true","selection is not correct"); 
		}
	
	public void validateAttributeValue(String locatorKey,String attribute,String text) {
		softAssert.assertTrue(getAttributeValue(locatorKey,attribute).contains(text),"Text is not matched");
		log(locatorKey+"is having the text"+text);
	}
	
	
	
	



	public void validateSelectedHotels(String columnName,String text) {
	String location="";
	String rooms="";
	String arrivalDate="";
	String departureDate="";
	List<WebElement>  locationList=getElements(location);
	for (int i = 1; i < locationList.size(); i++) {
		
	
	softAssert.assertEquals(locationList.get(i).getAttribute("value"),text,"mismatch found in Select Hotel Data");
	}
	}



	
}

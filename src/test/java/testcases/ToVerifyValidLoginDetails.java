package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Keywords.Applicationkeyword;
//import keywords.ApplicationKeywords;
//import keywords.ApplicationKeywords;
import util.UtilKit;

public class ToVerifyValidLoginDetails extends BaseTest{

	
	

	
	
	@DataProvider
	public Object[][] testData()
	{
		return UtilKit.getData("com.adactin.hotelapp", "TC101");
	}
	
	
	@Test(dataProvider = "testData" )
	public void toVerifyValidLoginDetailsTest(String username,String pwd,String expTitle,String name)
	{
		Applicationkeyword app= new Applicationkeyword();
		
		app.openBrowser("chrome");
		app.navigate("url");
		app.type("username_name", username);
		app.type("password_name", pwd);
		app.click("login_name");
		app.validateTitle(expTitle);
		app.validateAttributeValue("usernameshow_name", "value", name);
		//app.quit();
		
		
	}
		
}	
		
		
		
		
		
		
	
			


	

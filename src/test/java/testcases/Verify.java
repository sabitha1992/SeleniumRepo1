package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Keywords.Applicationkeyword;
import util.UtilKit;

public class Verify extends BaseTest{

	
	@DataProvider
	public Object[][] testData()
	{
		return UtilKit.getData("sheet2", "TC102");
		
	}
	
	@Test(dataProvider = "testData" )
	public void toVerifyTheCheckOutDateFieldTest(String username,String pwd,String location,String hotel,
			String roomNos,String checkin,String checkout,String adults,String child)
	{
		Applicationkeyword app = new Applicationkeyword();
		
		app.openBrowser("chrome");
		app.navigate("url");
		app.type("username_name", username);
		app.type("password_name", pwd);
		app.click("login_name");
		//app.getElements("location_name");
		app.getAttributeValue("location_name", location);
		//app.getElements(hotel);
		app.getElements(roomNos);
		app.getElements(checkin);
		app.getElements(checkout);
		app.type("location_name",location);
		app.type("hotels_name", hotel);
		app.type("roomnos_name", roomNos);
		app.type("datecheckin_name", checkin);//
		
	}
	
	/*//@Test
	public void newTest() {
		
		Applicationkeyword app = new Applicationkeyword();

		app.openBrowser("chrome");
		app.navigate("url");
	}*/
	


	
	
}

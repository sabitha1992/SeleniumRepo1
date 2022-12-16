package testcases;

import org.testng.annotations.Test;

import Base.BaseTest;
import Keywords.Applicationkeyword;

public class ValidateLogin extends BaseTest{

		
	
	@Test()
	public void validateLoginTest() {
		
	Applicationkeyword app =new Applicationkeyword();
	app.openBrowser("chrome");
	app.navigate("url");
	app.type("username_name", "reyaz0617");
	app.type("password_name", "reyaz123");
	app.quit();
		
		
		
		
	}

}

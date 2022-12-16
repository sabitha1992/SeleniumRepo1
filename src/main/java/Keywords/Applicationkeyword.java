package Keywords;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

public class Applicationkeyword extends Validationkeywords{

 
	public  Applicationkeyword() {
		
		try {
			FileInputStream fis1=new FileInputStream(System.getProperty("user.dir")+"\\properties\\config.properties");
			envProp=new Properties();
			envProp.load(fis1);
		} catch ( IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			FileInputStream fis2=new FileInputStream(System.getProperty("user.dir")+"\\\\properties\\locators.properties");
			prop=new Properties();
			prop.load(fis2);
		}catch( IOException e) {
			e.printStackTrace();
		}
		softAssert=new SoftAssert();
	}
	
	public void setReports(ExtentTest test) {
		
		this.test=test;
	}
	
	
	public void defaultLogin() {
		
		navigate(prop.getProperty(getTitle()));
		type("username_name",prop.getProperty("username_name"));
		type("password_name",prop.getProperty("password_name"));
		click("login_name");
		waitForPageTOload();
	}
}
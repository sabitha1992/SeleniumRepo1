package Examples1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginDemoGuru {

	@Test
	
	public void verifylogin(){
		
	WebDriverManager.chromiumdriver().setup();
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://demo.guru99.com/test/guru99home/");
		
	
	
		
		
	}
}

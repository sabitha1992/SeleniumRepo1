package Examples1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demoOpenCart {
	
	@Test

	public void verifylogin(){
		
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10,, null)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demo.opencart.com/index.php");
		
		
		
		WebElement Laptops=driver.findElement(By.linkText("Laptops & Notebooks"));
		Actions action=new Actions(driver);
		action.moveToElement(Laptops).perform();
		
		//click on
		//Thread.sleep(3000);
		driver.findElement(By.linkText("Show All Laptops & Notebooks")).click();
		

		// fetch the elements
		WebElement element = driver.findElement(By.xpath("//img[contains(@alt,'HP LP3065')]//following::div"));
		String price = element.getText();
		
		WebElement element1 = driver.findElement(By.xpath("//img[contains(@alt,'MacBook')]//following::div"));
		String price1 = element1.getText();
		
		WebElement element2 = driver.findElement(By.xpath("//img[contains(@alt,'MacBook Air')]//following::div"));
		String price2 = element2.getText();
		WebElement element3 = driver.findElement(By.xpath("//img[contains(@alt,'MacBook Pro')]//following::div"));
		String price3 = element3.getText();
		
		WebElement element4= driver.findElement(By.xpath("//img[contains(@alt,'Sony VAIO')]//following::div"));
		String price4 = element4.getText();
		
		System.out.println(price +
				price1+
				price2+
				price3+
				price4);
		
		WebElement list= driver.findElement(By.xpath("//a[@class='list-group-item active']"));
		
		System.out.println(list.getText());
		

	}

}

		

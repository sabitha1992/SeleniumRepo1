package Keywords;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
//import com.avenstack.extentreport.ExtentTEST;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericKeywords {
  
	public WebDriver driver;
	public Properties envProp;
	public Properties prop;
	public SoftAssert softAssert ;
	public static ExtentTest test;
	public ITestContext context;
	
	
	
	
	//true -- if element is visible
	//false -- if element is not visible
	public boolean isElementVisible(String locatorKey)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try
		{
		wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
		
	}
		
		
	
	//true -- if element is present
	//false -- if element is not present
	
	public boolean isElementPresent(String locatorKey)
	{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        try
		{
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getLocator(locatorKey)));
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
		
		
		
	
	public List<WebElement> getElements(String locatorKey){
		List<WebElement> elements = driver.findElements(getLocator(locatorKey));
		return elements;
	}
	
	public String getAttributeValue(String locatorKey,String attribute) {
		return getElement(locatorKey).getAttribute(attribute);
		
	}
		
		
	
	
	public WebElement getElement(String locatorKey)
	{
		//presence of element
		
		if(!isElementPresent(locatorKey))
		{
			return null;
		}
		//visbilibity of element
		
		if(!isElementVisible(locatorKey))
		{
			return null;
		}
		WebElement element = driver.findElement(getLocator(locatorKey));
		return element;
		
	}
	
	
	
	public By getLocator(String locatorKey)
	{
		By by=null;
		
		if(locatorKey.endsWith("_id"))
		{
			by=By.id(prop.getProperty(locatorKey));
		}

		else if(locatorKey.endsWith("_name"))
		{
			by=By.name(prop.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_css"))
		{
			by=By.cssSelector(prop.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_xpath"))
		{
			by=By.xpath(prop.getProperty(locatorKey));
		}
		
		return by;
	}
		
	
	
	public void click(String locatorKey)
	{
		getElement(locatorKey).click();
	}
	
	
	
	public void wait(int noOfSeconds)
	{
		try {
			Thread.sleep(noOfSeconds);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	public void clickEnterButton(String locatorKey)
	{
		getElement(locatorKey).sendKeys(Keys.ENTER);
	}

	
	
	
	public String getText(String locatorKey)
	{
		return getElement(locatorKey).getText();
	}
	
		
	
	
	public void selectByVisibleText(String locatorkey,String text) {
			new Select(getElement(locatorkey)).selectByVisibleText(text);
		}
		
	
	
	public void type(String locatorKey,String text) {
		log("Entering text"+text+"in textbox with locatorkey"+locatorKey);
			getElement(locatorKey).sendKeys(text);
		}
		
		
	
	public void takeScreenShot() {
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String screenShotFile = simpleDateFormat.format(new Date());
		    screenShotFile=screenShotFile.replace(":", "-");
		    String screenshotDirPath=System.getProperty("user.dir")+"\\screenshots";
			File screenshotDir=new File(screenshotDirPath);
			screenshotDir.mkdir();
			try
			{
			FileUtils.copyFile(srcFile, new File(screenshotDirPath+"\\"+screenShotFile+".png"));
			}
			catch(Exception e)
			{
			}}
		
		
	
	public void waitForPageTOload() {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			String status=(String) js.executeScript("return document.readystate:");
			int i=1;
			while (i<10) {
				if (status.equals("complete")) {
					break;
				} else {
					wait(2);
				}
				i++;
			}}
		
			
		
		
	
	public void quit() {
	driver.quit();
	}
		
		
		
	
	public String getTitle() {
			return driver.getTitle();
		}
			
		
public void log(String msg) {
	test.log(Status.INFO,msg);
}
 public void openBrowser(String browser) {
	 log("Opening the browser"+ browser);
	 
	 if(browser.equalsIgnoreCase("chrome")) {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	 }
	 
	 else if(browser.equalsIgnoreCase("firefox")) {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	 }
	 else if(browser.equalsIgnoreCase("edge")) {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	 
	 }
	 
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 }
	 
	public void navigate(String url) {
		System.out.println("Navigating to"+url);
		log("Navigating to"+envProp.getProperty(url));
		driver.get(envProp.getProperty(url));
	}
	 
	 public void assertAll() {
		 softAssert.assertAll();
		 
	 }
	 
	 public void clear(String locatorKey) {
	 log("Clearing Text field"+locatorKey);
	 getElement(locatorKey).clear();
	 }
	 public void setTestContext(ITestContext context) {
		 this.context=context;
	 }
	 
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 


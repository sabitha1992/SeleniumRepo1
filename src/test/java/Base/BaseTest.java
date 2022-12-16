package Base;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Driver.DriverScript;
import reports.ExtentManager;

public class BaseTest {



public static DriverScript ds;
public static ExtentReports reports;
public static ExtentTest test;


@BeforeTest(alwaysRun=true)
public void beforeTest(ITestContext context) {
	
	reports=ExtentManager.getReports();
	test=reports.createTest(context.getCurrentXmlTest().getName());
	test.log(Status.INFO,"Starting Test "+context.getCurrentXmlTest().getName());
	
	context.setAttribute("reports", reports);
	context.setAttribute("test", test);
	
	ds=new DriverScript();
	ds.setReports(test);
	//ds.defaultLogin(context);
	ds.setTestContext(context);
	context.setAttribute("driver", ds);
}

@BeforeMethod
public void beforeMethod(ITestContext context) {
	test=(ExtentTest) context.getAttribute("test");
	reports=(ExtentReports)context.getAttribute("reports");
	 ds=(DriverScript)context.getAttribute("driver");
	 
	
}

@AfterMethod(alwaysRun=true)
public void tearDown(ITestContext context)
{
	reports=(ExtentReports)context.getAttribute("driver");
	ds=(DriverScript) context.getAttribute("driver");
	ds.quit();
}

@AfterTest(alwaysRun=true)
public void afterTest(ITestContext context) {
	reports=(ExtentReports)context.getAttribute("driver");
	ds=(DriverScript) context.getAttribute("driver");

	if (reports!=null) {
		reports.flush();
		
	}
	 
}}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	

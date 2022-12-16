package Driver;

import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentTest;

import Keywords.Applicationkeyword;



public class DriverScript {
	
		
		
	public  Applicationkeyword app;
	public ITestContext context;
	public DriverScript()
	{
		app=new Applicationkeyword();
	}
	public void quit() {
		if(app!=null)
			app.quit();
	}
	public void log(String logMessage) {
		app.log(logMessage);
	}
	
	public void setTestContext(ITestContext context) {
		this.context=context;
		app.setTestContext(context);
	}


	public void setReports(ExtentTest test) {
    app.setReports(test);
		
	}

	public void defaultLogin(String browser) {
		app.openBrowser(browser);
		
	}

}
		
	

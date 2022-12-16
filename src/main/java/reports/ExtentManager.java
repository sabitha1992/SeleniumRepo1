package reports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	static ExtentReports reports;
	public static ExtentReports getReports() {
		reports=new ExtentReports();
		String reportsFolderPath=System.getProperty("user.dir")+"\\reports";
		File reportsFolder=new File(reportsFolderPath);
		reportsFolder.mkdir();
		
		
		String pattern="yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat SimpleDateFormat= new SimpleDateFormat(pattern);
		
		String date=SimpleDateFormat.format(new Date());
		date=date.replace(":", "-");
		System.out.println(date);
		
		String reportFilePath=reportsFolderPath+"\\"+date+".html";
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportFilePath);
		
		reporter.config().setDocumentTitle("Adactin Regression Results");
		reporter.config().setReportName("Regression Results");
		reporter.config().setTheme(Theme.DARK);
		reports.attachReporter(reporter);
		
		return reports;
		
	}

}

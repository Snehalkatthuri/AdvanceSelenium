package Generic_Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentImplementatin implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
	test=report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testData = result.getMethod().getMethodName();
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		try {
		     FileUtils.copyFile(src, new File("./Screenshot/"+testData+".png"));
		    }catch(Exception e)
		{
		   e.printStackTrace(); 	
		}
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
	
		Java_Ulitity jlib= new Java_Ulitity();
		int ranNum=jlib.getRandomNum();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReporter/Report.html"+ranNum);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Testing");
		spark.config().setReportName("Snehal");
		
		//System configuration
		report= new ExtentReports();
		
		report.attachReporter(spark);
		report.setSystemInfo("platform", "windows10");
		report.setSystemInfo("executed by", "Snehal");
		report.setSystemInfo("reviewed by", "Sandeep");
		}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
	}

	
	
}

package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**this method provides implementation to ITestListeners interface of testng
 * @author mounika
 */
public class ListenersImplementation implements ITestListener{ //implement only itestlistner 
	//below 8 methods are created after ListenersImplementation implements ITestListener-->then right click on program and click on source then select override/implement methods
	//then check the ITestListener check box and click on ok

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println("# "+methodName+" test script execution started #");
		
		//intimate the Extent report for test execution
		test=report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		//capture the method name
		String methodName=result.getMethod().getMethodName();
		System.out.println("# "+methodName+" test script execution pass #");
		
		//log status as pass in extent report
		
		test.log(Status.PASS, methodName+"Test Script Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//capture the method name
		String methodName=result.getMethod().getMethodName();
		System.out.println("# "+methodName+" test script execution fail #");
		
		//capture exception
		System.out.println(result.getThrowable());
		
		//log the status as fail in extent report 
		test.log(Status.FAIL, methodName+"Test Script FAIL");
		
		//lOG the exception captured to extent report
		test.log(Status.WARNING, result.getThrowable());
		
		//capture the screenshot
		JavaUtility j=new JavaUtility();
		SeleniumUtility s=new SeleniumUtility();
		String screenshotname= methodName+"-"+j.getSystemDate();
		try {           //this try catch block we took from selenium sugegestion because it thrown error for 43 line
			String path=s.captureScreenshot(BaseClass.sdriver, screenshotname);
			
			//attach screenshot to the report
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println("# "+methodName+" test script execution skip #");
		
		//capture exception
				System.out.println(result.getThrowable());
				
				//log the status as SKIP  in extent repport
				test.log(Status.SKIP, methodName+"Test Script SKIP");
				
				//Log the exception captured to extent report
				test.log(Status.WARNING, result.getThrowable());
				
				
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("# TestFailedButWithinSuccessPercentage #");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("# TestFailedWithTimeout #");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("# suite execution started #");
		
		// Basic Configuration of Extent Reports
		ExtentSparkReporter esr= new ExtentSparkReporter(".\\ExtentReports\\Report - "+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Swag Labs Execution report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Automation Execution Report");
		
		//Report generation
		 report =new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("BaseBropwser", "Micorsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo(" Base Env", "Testing");
		report.setSystemInfo("Reporter Name", "mounika");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("# suite execution finished #");
		
		
		//generate extent report
		report.flush();
	}

	
}

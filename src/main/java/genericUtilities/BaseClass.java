package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

/**
 * this method consists of basic configuration annotation
 * @author mounika
 */
public class BaseClass {
	public JavaUtility jUtil=new JavaUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	public FileUtilities fUtil=new FileUtilities();
	
	public WebDriver driver;
	
	public static WebDriver sdriver;// this driver we created for Listeners driver use  for capturing screen shot
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("====data base connectivity successful");
	}
	
	
//	@Parameters("browser")
//	@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String pvalue*/) throws IOException
	{
		String url = fUtil.readDataFromPropertyFile("url");
		
		driver=new ChromeDriver();
		
		//for cross boowser testing  -->runtime polymorphism --i.e driver
//		if(pvalue.equals("edge"))
//		{
//			driver=new EdgeDriver();
//		}
//		else if(pvalue.equals("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}
//		else
//		{
//			driver=new ChromeDriver();
//		}
//		
		
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		driver.get(url);
		
		//for listeners to capture screenshot we need driver
		sdriver=driver;
		
		System.out.println("====browser launch successful");
	}
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String username=fUtil.readDataFromPropertyFile("username");
		String password=fUtil.readDataFromPropertyFile("password");
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(username, password);
		System.out.println("====login to app  successful");
		
	}
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		InventoryPage ip=new InventoryPage(driver);
		ip.logoutOfApp();
		System.out.println("====logout to app  successful");
	}
//	@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("====browser closure successful");
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("====db closure  successful");
	}
	
}

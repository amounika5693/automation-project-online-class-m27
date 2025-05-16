package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.FileUtilities;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class Able_to_see_added_products_in_cart_or_not2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// in this program we use "commonData.properties" file in "src/test/resources" folder 
		//it will take test data from properties file  
		//in automation(advance selenium ) we are using data driven testing concept here

		//create object of utilities
		FileUtilities futil=new FileUtilities();
		JavaUtility jutil=new JavaUtility(); 
		SeleniumUtility sutil =new SeleniumUtility();
		
		
		
		//read data from property file
		
		
	/*	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		

		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");*/ //this code slready written in file utility so im commenting here and using from utility
		
		
		//the above data is used before utilities are created after creating utilities we use below code
		
		
		String username=futil.readDataFromPropertyFile("username");
		String password=futil.readDataFromPropertyFile("password");
		String url=futil.readDataFromPropertyFile("url");

		//read the data from excel file
		
		
		//every time if we do any changes in excel file(desktop) we have to del excel file in eclipse and copy paste the updated file(desktop) into eclipse
		//then we need to update the maven project if we are not getting output(we may get exception as "noSuchElementException")

//		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
//		Workbook wb=WorkbookFactory.create(fise);
//		Sheet sh=wb.getSheet("products");
//		Row rw=sh.getRow(1);
//		Cell cl=rw.getCell(2);
//		String productname=cl.getStringCellValue();//product has to be added to cart -runtime its adding product
		
		
	//reading data from excel after creating utility
		
		String productname=futil.readDataFromExcelFile("products", 1, 2);
		
		
		//launch driver
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		//logging into application
		
//		driver.findElement(By.id("user-name")).sendKeys(username);
//		driver.findElement(By.id("password")).sendKeys(password);
//		driver.findElement(By.id("login-button")).click();
		
		//login using pom class(here we created an object repo-"LoginPage" from there we are retrieving the webelements)
		
		//in object repo of Loginpage we stored webelements(username,password and login button)
		
//		LoginPage lp=new LoginPage(driver);
//		lp.getusernaemedt().sendKeys(username);
//		lp.getpasswordedt().sendKeys(password);
//		lp.getloginbtn().click();
		
		
		//in above we used pom class now we use buisness nibrary
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(username, password); // this will enter un and pwd and click on login (the logic present in objectRpository oackage "LoginPage" class)
		
		//finding product and clicking on product
		
	
		
		WebElement prod =  driver.findElement(By.xpath("//div[.='"+productname+"']"));
		System.out.println(prod.getText());
		
		
		prod.click();

		Thread.sleep(3000);
		
		
		//capture the product
		String screenshotname="prod"+jutil.getSystemDate();
		System.out.println();
		//String path=sutil.captureScreenshot(driver, screenshotname);
	//	System.out.println(path);
		
		
	
		
		
		//adding product to cart
		driver.findElement(By.id("add-to-cart")).click();
		Thread.sleep(3000);
		
		//entering into cart and see product is added
		driver.findElement(By.id("shopping_cart_container")).click();
		
		
		
		//logging out from the application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
	}

}



































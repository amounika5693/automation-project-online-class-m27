package inventoryTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtilities;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;
//@Listeners(genericUtilities.ListenersImplementation.class) //class level we are using listners //otherwise we can use listners in suite level (i implemented in smoke suite xml file-->testng-smokeSuite.xml)
public class AddProductToCartTest extends BaseClass{
	@Test(groups={"smokeSuite","Regression"})
	public  void tc_01_AddProductTocartTest() throws IOException, InterruptedException  {
		
		//read data from excel file
		String productname=fUtil.readDataFromExcelFile("products", 1, 2);
		System.out.println(productname);

		//click on a product 
		InventoryPage ip=new InventoryPage(driver);
		ip.clickOnProduct(driver, productname);
		Thread.sleep(2000);

		//add product to cart
		InventoryItemPage iip=new InventoryItemPage(driver);
		iip.clickOnAddTocartbtn();
		

		//click on cart container
		ip.clickOnCartContainer();

		//validate in cart
		CartPage cp=new CartPage(driver);
		String productInCart = cp.getItemName();
		
		
		//assertion validation
		
		Assert.assertEquals(productInCart,productname);
		
		
//		if(productInCart.equals(productname))
//		{
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("fail");
//		}

		
	}
	@Test(groups={"smokeSuite","Regression"})
	public void sampleTest()
	{
		//Assert.fail();
		System.out.println("sample test");
	}

}

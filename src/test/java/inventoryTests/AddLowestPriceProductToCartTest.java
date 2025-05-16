package inventoryTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtilities;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class AddLowestPriceProductToCartTest extends BaseClass{
	@Test(groups="Regression")
	public  void tc_02_AddLowestProductTocartTest() throws IOException, InterruptedException{
		
		

				


				//read data from excel file
				String sortoption=fUtil.readDataFromExcelFile("products", 4, 2);
				String productname=fUtil.readDataFromExcelFile("products", 4, 3);

				System.out.println(productname);
				

				


				//click on a product 
				InventoryPage ip=new InventoryPage(driver);
				ip.clickOnLowestPriceProduct(driver, sortoption, productname);
				Thread.sleep(2000);

				//add product to cart
				InventoryItemPage iip=new InventoryItemPage(driver);
				iip.clickOnAddTocartbtn();

				//click on cart container
				ip.clickOnCartContainer();

				//validate in cart
				CartPage cp=new CartPage(driver);
				String productInCart = cp.getItemName();
				
				Assert.assertEquals(productInCart, productname);
				
//				if(productInCart.equals(productname))
//				{
//					System.out.println("pass");
//				}
//				else
//				{
//					System.out.println("fail");
//				}

				

	}

}

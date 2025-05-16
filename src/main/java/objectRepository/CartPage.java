package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	//rule 1
			//rule-1(create a seperate pom class for every webpage "(class name should be pagetitle and followed by page)")
			
			
			//rule-2 declaration==>(identify every webelement in page using @findby,@FindBys,@FindAll and make the element as private)
			
			@FindBy(className="inventory_item_name")
			private WebElement cartproductname;
			
			@FindBy(id="remove-sauce-labs-backpack")
			private WebElement cartremovebtn;
			
			@FindBy(id="checkout")
			private WebElement cartcheckoutbtn;
			
			@FindBy(id="continue-shopping")
			private WebElement cartcontinuebtn;
			
			
			
			//rule3-initialization(create a constructor for element initialization using pagefactory class)
			public CartPage(WebDriver driver)//constructor
			{
				PageFactory.initElements(driver,this);//page factory is a class in selenium

			}
			//rule -4 (provide getters to access the webelements out of pom class)



			public WebElement getCartproductname() {
				return cartproductname;
			}



			public WebElement getCartremovebtn() {
				return cartremovebtn;
			}



			public WebElement getCartcheckoutbtn() {
				return cartcheckoutbtn;
			}



			public WebElement getCartcontinuebtn() {
				return cartcontinuebtn;
			}
			
			
			
			//buisness library
			/**
			 * this method will capture the product name and return to caller
			 * @return
			 */
			public String getItemName()
			{
				return cartproductname.getText();
			}
			
			/**
			 * this method will click on remove button
			 */
			public void clickOnRemoveBtn()
			{
				cartremovebtn.click();
			}
			
			
			
			
}

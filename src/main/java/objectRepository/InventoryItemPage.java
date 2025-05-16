package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {

	//rule 1
		//rule-1(create a seperate pom class for every webpage "(class name should be pagetitle and followed by page)")
		
		
		//rule-2 declaration==>(identify every webelement in page using @findby,@FindBys,@FindAll and make the element as private)
		
		@FindBy(id="add-to-cart")
		private WebElement addtocartbtn;
		
		@FindBy(className="//div[@class='inventory_details_price']")
		private WebElement price;
		
		
		//rule3-initialization(create a constructor for element initialization using pagefactory class)
		
		
		public InventoryItemPage(WebDriver driver)//constructor
		{
			PageFactory.initElements(driver,this);//page factory is a class in selenium

		}
		
		//rule -4 (provide getters to access the webelements out of pom class)
		
		public WebElement getAddtocartbtn() {
			return addtocartbtn;
		}


		public WebElement getPrice() {
			return price;
		}


		//buisness library
		
		/** 
		 * this method willclick on add to cart button
		 */
		public void clickOnAddTocartbtn()
		
		{
			addtocartbtn.click();	
		}
		
	
}

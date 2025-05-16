package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;


public class InventoryPage extends SeleniumUtility{

	//rule 1
	//rule-1(create a seperate pom class for every webpage "(class name should be pagetitle and followed by page)")
	
	
	//rule-2 declaration==>(identify every webelement in page using @findby,@FindBys,@FindAll and make the element as private)
	
//	@FindBy(id="item_4_title_link")
//	private WebElement productname;
	
	@FindBy(className="product_sort_container")
	private WebElement sortfilterbtn;
	
	
	
	@FindBy(id="shopping_cart_container")
	private WebElement cartcontainer;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement menubtn;
	

	@FindBy(id="logout_sidebar_link")
	private WebElement logoutlnk;
	
	
	//rule3-initialization(create a constructor for element initialization using pagefactory class)
		public InventoryPage(WebDriver driver)//constructor
		{
			PageFactory.initElements(driver,this);//page factory is a class in selenium

		}

		//rule -4 (provide getters to access the webelements out of pom class)
//		public WebElement getProductname() {
//			return productname;
//		}


		public WebElement getSortfilterbtn() {
			return sortfilterbtn;
		}


		public WebElement getCartcontainer() {
			return cartcontainer;
		}


		public WebElement getMenubtn() {
			return menubtn;
		}


		public WebElement getLogoutlnk() {
			return logoutlnk;
		}
	
		
	//buisness library
		/**
		 * this methos will click any product specified by caller
		 * @param driver
		 * @param productname
		 */
		public void clickOnProduct(WebDriver driver,String productname)
		{
			driver.findElement(By.xpath("//div[.='"+productname+"']")).click();
		}
	
		/**
		 * this method will perform logout operation
		 */
		
	public void logoutOfApp()
	{
		menubtn.click();
		logoutlnk.click();
	}
	
	
	/**
	 * this method will sort for lowest price product and then click on it
	 * @param driver
	 * @param sortoption
	 * @param productname
	 */
	public void clickOnLowestPriceProduct(WebDriver driver, String sortoption, String productname)
	{
	handleDropdown(sortfilterbtn, sortoption);
	
	driver.findElement(By.xpath("//div[.='"+productname+"']")).click();
	}
	
	/**
	 * this method will click on cart container button
	 */
	
	public void clickOnCartContainer()
	{
		cartcontainer.click(); 
	}
	
}

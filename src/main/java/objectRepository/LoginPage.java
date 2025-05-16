package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//rule 1
	//rule-1(create a seperate pom class for every webpage "(class name should be pagetitle and followed by page)") 

	//rule-2 declaration==>(identify every webelement in page using @findby,@FindBys,@FindAll and make the element as private)

	@FindBy(id="user-name")
	private WebElement usernaemedt;

	@FindBy(id="password")
	private  WebElement passwordedt;

	@FindBy(id="login-button")
	private  WebElement loginbtn;



	//rule3-initialization(create a constructor for element initialization using pagefactory class)
	public LoginPage(WebDriver driver)//constructor
	{
		PageFactory.initElements(driver,this);//page factory is a class in selenium

	}

	//rule -4 (provide getters to access the webelements out of pom class)
	public WebElement getusernaemedt() {
		return usernaemedt;
	}

	public WebElement getpasswordedt() {
		return passwordedt;
	}


	public WebElement getloginbtn() {
		return loginbtn;
	}


// rule 5 ==> provide buisness library if required
	
	public void loginToApp(String un,String pwd)
	{
		usernaemedt.sendKeys(un);
		passwordedt.sendKeys(pwd);
		loginbtn.click();
	}

}

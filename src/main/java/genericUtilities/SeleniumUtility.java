package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class consistes of resuabel methods related to selenium tool
 * @author Shiva
 * @param <TakesScreenshot>
 */

public class SeleniumUtility{
	/**
	 * this method will maximize the window
	 * @param driver
	 */

	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * 
	 * this method will minimize window
	 * @param driver
	 */

	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * this method will add 10 sec of implicitly wait

	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}


	/**
	 * this method will wait for 10 sec for particular element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used to click the webelement
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickable(WebDriver driver,WebElement element)	
	{
		driver.findElement((By) element).click();
	}
	/**
	 * this method is used to handle dropdown  using select by index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * this method will handle dropdown by visible tex
	 * @param element
	 * @param text
	 */

	public void handleDropdown(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * this method will handle dropdown by value
	 * @param value
	 * @param element
	 */
	public void handleDropdown(String value,WebElement element)
	{
		Select s=new Select(element)	;
		s.selectByValue(value);
	}
	/**
	 * this method will perform mouse hovering action
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver, WebElement element)
	{

		Actions a=new Actions(driver);
		a.moveToElement(element).perform();

	}
	/**
	 * this method will click the webelement by taking element as an argument in click-method
	 * @param driver
	 * @param element
	 */
	public void clickOfWebelement(WebDriver driver, WebElement element)
	{

		Actions a=new Actions(driver);
		a.click(element).perform();

	}
	/**
	 * this method is used for doubleckicking the webelement
	 * @param driver
	 * @param element
	 */
	public void doubleClickOfWebelement(WebDriver driver, WebElement element)
	{

		Actions a=new Actions(driver);
		a.doubleClick(element).perform();

	}
	/**
	 * this method is used to right click on webelement
	 * @param driver
	 * @param element
	 */
	public void contextClickOfWebelement(WebDriver driver, WebElement element)//means right click
	{

		Actions a=new Actions(driver);
		a.moveToElement(element).contextClick().perform();

	}
	/**
	 * this method is used for clicking and holding on webelement
	 * @param driver
	 * @param element
	 */
	public void clickAndHoldOfWebelement(WebDriver driver, WebElement element)
	{

		Actions a=new Actions(driver);
		a.moveToElement(element).clickAndHold().perform();

	}
	/**
	 * this method is used for releasing the mouse after clicking 
	 * @param driver
	 * @param element
	 */
	public void releaseOfWebelement(WebDriver driver, WebElement element)
	{

		Actions a=new Actions(driver);
		a.release(element).perform();

	}

	/**
	 * this method is used for the dragging and fropping the webelements
	 * @param driver
	 * @param element
	 * @param element2
	 */
	public void dragAndDropOfWebelement(WebDriver driver, WebElement element, WebElement element2)
	{

		Actions a=new Actions(driver);
		a.dragAndDrop(element, element2).perform();

	}

	/**
	 * this method will handle the framen by frameindex
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, int frameIndex)
	{

		driver.switchTo().frame(frameIndex);
	}

	/**
	 * this method will handle the framen by framenameorid
	 * @param driver
	 * @param framenameorid
	 */
	public void handleFrame(WebDriver driver, String framenameorid)
	{

		driver.switchTo().frame(framenameorid);
	}

	/**
	 * this method will handle the framen by frameElement 
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver,WebElement frameElement )
	{

		driver.switchTo().frame(frameElement);
	}

	//alert popups
	/**
	 * this method will accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver )
	{

		driver.switchTo().alert().accept();
	}

	/**
	 * this method will cancel alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}

	/**
	 * this method will accept alert popup
	 * @param driver
	 */
	public void enterAlertText(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}

	public String captureScreenshot(WebDriver driver, String screenshotname) throws IOException

	{

		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\screenshots"+screenshotname+".png");
		FileHandler.copy(src, dst);
		return dst.getAbsolutePath();
	}
}

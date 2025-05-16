package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class To_homepage_from_cart3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/inventory.html");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("item_4_img_link")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("add-to-cart")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("shopping_cart_container")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("inventory_sidebar_link")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
	}

}

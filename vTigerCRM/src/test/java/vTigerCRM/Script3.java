package vTigerCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Script3 {
	//Script3:Login to vtiger application
	//click on products link
	//click on create product lookup image
	//Enter product name
	//click on save Btn
	//verify whether the product is created in product Information page and Logout from the application.
	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		Thread.sleep(3000);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Products")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		String prodname = "Laptop";
		driver.findElement(By.name("productname")).sendKeys(prodname);
		driver.findElement(By.name("button")).click();
		//Verification
		String check = driver.findElement(By.id("dtlview_Product Name")).getText();
		if(check.contains(prodname))
		{
			System.out.print("Product name verified");
		}
		else
		{
			System.out.print("Product name not verified");
		}
		//End Verification
		Thread.sleep(3000);
		WebElement Administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a= new Actions(driver);
		a.moveToElement(Administrator).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}

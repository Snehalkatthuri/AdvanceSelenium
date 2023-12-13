package vTigerCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Script2 {
	//Script2: Login to vtiger application
	//click on Contacts link
	//click on create contact lookup image
	//Enter FirstName and LastName
	//click on save Btn
	//verify whether the Contact is created with firstName and LastName in Contact Information page and Logout from the application.

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
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			String firstname = "Snehal";
			driver.findElement(By.name("firstname")).sendKeys(firstname);
			String lastname = "Vyawahare";
			driver.findElement(By.name("lastname")).sendKeys(lastname);
			driver.findElement(By.xpath("//input[@type='submit'][1]")).click();
			//verification
			String firstnameinfo = driver.findElement(By.id("dtlview_First Name")).getText();
			String lastnameinfo = driver.findElement(By.id("dtlview_Last Name")).getText();
			if(firstnameinfo.contains(firstname))
			{
				System.out.print("FirstName verified");
			}
			else
			{
				System.out.print("FirstName not verified");
			}
			if(lastnameinfo.contains(lastname))
			{
				System.out.println("LastName verified");
			}
			else
			{
				System.out.println("LastName verified");
			}
			//End verification
			Thread.sleep(3000);
			WebElement Administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions a= new Actions(driver);
			a.moveToElement(Administrator).perform();
			driver.findElement(By.linkText("Sign Out")).click();
	}

}

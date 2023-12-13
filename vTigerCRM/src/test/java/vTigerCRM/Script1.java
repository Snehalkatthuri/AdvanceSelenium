package vTigerCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
//Test Case1:Login to vtiger application
		//click on organizations link
		//click on create organization lookup image
		//Enter organisation name
		//click on save Btn
		//verify whether the organization is created in Organization Information page and Logout from the application.
public class Script1 {
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
			driver.findElement(By.linkText("Organizations")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			Thread.sleep(3000);
			String name="qSpider4";
			driver.findElement(By.name("accountname")).sendKeys(name);
			Thread.sleep(3000);
			driver.findElement(By.name("button")).click();
			Thread.sleep(3000);
      			//verification
		String orgname=driver.findElement(By.id("dtlview_Organization Name")).getText();	
			if(orgname.contains(name))
			{
				System.out.print("Organization is created");
			}
			else
			{
				System.out.print("Organization is already created");
			}
			//End Verification
			Thread.sleep(3000);
			WebElement Administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions a= new Actions(driver);
			a.moveToElement(Administrator).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			
			
				
		

	}

}

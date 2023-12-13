package Product;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities.File_Utility;
import POMRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductAndDeleteProduct {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		/*driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();*/
		
		//Using File Utility
		File_Utility flib= new File_Utility();
		String URL=flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PASSWORD = flib.getKeyAndValueData("password");
		//using Pom
		LoginPage login= new LoginPage(driver);
		login.loginToApplication(USERNAME, PASSWORD);
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		//Random approach to avoid Duplicates
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		String Name = "Mobile"+ranNum;
		driver.findElement(By.name("productname")).sendKeys(Name);
		System.out.println(Name);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String prodname = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
       
		if(prodname.contains(Name))
       {
    	   System.out.println("Product is created");
       }
       else
       {
    	   System.out.println("Product is not created");
       }
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//a[text()='"+Name+"']/../preceding-sibling::td/input")).click();
		

	}

}

package Campaign;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_utility;
import POMRepository.HomePage;
import POMRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProduct extends BaseClass  {
  @Test
	public void CreateCampaignWithProduct() throws Throwable {

	     //	public static void main(String[] args) throws Throwable {
         WebDriverManager.edgedriver().setup();
         WebDriver driver= new EdgeDriver();
//       File_Utility flib= new File_Utility();
//       String BROWSER = flib.getKeyAndValueData("browser");	
//       	if(BROWSER.equalsIgnoreCase("Edge"))
//       	{
//       		WebDriverManager.edgedriver().setup();
//       		driver=new EdgeDriver();
//       	}
//       	else if(BROWSER.equalsIgnoreCase("Chrome"))
//       	{
//       		WebDriverManager.chromedriver().setup();
//       		driver=new EdgeDriver();
//       	}
//       	else
//       	{
//       		driver=new ChromeDriver();
//       	}
//       	System.out.println("Launch Browser");
        WebDriver_utility wlib= new WebDriver_utility();
		wlib.maximizingWindow(driver);
		wlib.implicity_wait(driver);
		//driver.manage().window().maximize();
		
		/*driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();*/
		
		File_Utility flib= new File_Utility();
		String URL=flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PASSWORD = flib.getKeyAndValueData("password");
	
		//Using POM
		driver.get(URL);
		LoginPage login= new LoginPage(driver);
		login.loginToApplication(USERNAME, PASSWORD);
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		//Random approach to avoid Duplicates
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		String proName = "Mobile"+ranNum;
		driver.findElement(By.name("productname")).sendKeys(proName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String prodname = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
       
		if(prodname.contains(proName))
       {
    	   System.out.print("Product is created");
       }
       else
       {
    	   System.out.print("Product is not created");
       }
       				
        /*driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Campaigns")).click();*/
				//POM Home
				HomePage home= new HomePage(driver);
				home.clickOnMoreLink();
				home.clickOnCampaignLink();
						
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		Set<String>allWin = driver.getWindowHandles();
		Iterator<String> win = allWin.iterator();
		
		while(win.hasNext())
		{
			String winText = win.next();
			driver.switchTo().window(winText);
			String title = driver.getTitle();
			
			if(title.contains("Products&action"))
			{
				break;
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.name("search_text")).sendKeys(proName);
		driver.findElement(By.name("search")).click();
		
		//Dynamic Xpath
		driver.findElement(By.xpath("//a[text()='"+proName+"']")).click();
		
		Set<String> allWin1 = driver.getWindowHandles();
		Iterator<String> win1 = allWin1.iterator();
		
		while(win1.hasNext())
		{
			String winText1 = win1.next();
			driver.switchTo().window(winText1);
			String title1 = driver.getTitle();
			
			if(title1.contains("Campaigns&action"))
			{
				break;
			}
		}
		String campName = "Marketing"+ranNum;
		Thread.sleep(3000);
		driver.findElement(By.name("campaignname")).sendKeys(campName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	    driver.findElement(By.linkText("Sign Out")).click();
		
	}

}

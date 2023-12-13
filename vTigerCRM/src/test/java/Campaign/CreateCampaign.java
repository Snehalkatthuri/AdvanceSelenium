package Campaign;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Ulitity;
import Generic_Utilities.WebDriver_utility;
import POMRepository.CampaignPage;
import POMRepository.CreateCampaignPage;
import POMRepository.HomePage;
import POMRepository.LoginPage;
import POMRepository.ValidationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(Generic_Utilities.ListenerImplementation.class)
@Listeners(Generic_Utilities.ExtentImplementatin.class)
public class CreateCampaign extends BaseClass {
	@Test(retryAnalyzer=Generic_Utilities.RetryImplementation.class)
    	public void CreateCampaign() throws Throwable {
    	//public static void main(String[] args) throws Throwable {
//  	WebDriverManager.edgedriver().setup();
//		WebDriver driver= new EdgeDriver();
//        File_Utility flib= new File_Utility();
//        String BROWSER = flib.getKeyAndValueData("browser");	
//        	if(BROWSER.equalsIgnoreCase("Edge"))
//        	{
//        		WebDriverManager.edgedriver().setup();
//        		driver=new EdgeDriver();
//        	}
//        	else if(BROWSER.equalsIgnoreCase("Chrome"))
//        	{
//        		WebDriverManager.chromedriver().setup();
//        		driver=new EdgeDriver();
//        	}
//        	else
//        	{
//        		driver=new ChromeDriver();
//        	}
//        	System.out.println("Launch Browser");
//        	
        WebDriver_utility wlib= new WebDriver_utility();
		wlib.maximizingWindow(driver);
		wlib.implicity_wait(driver);
		//driver.manage().window().maximize();
		
		//File Utility generics//commented for base class
		//File_Utility flib= new File_Utility();
		//String URL = flib.getKeyAndValueData("url");
		//String USERNAME = flib.getKeyAndValueData("username");
		//String PASSWORD = flib.getKeyAndValueData("password");
		
		//Fetch data from property file
		/*FileInputStream fis = new FileInputStream("./src/test/resources/Propertiesfile.property.txt");
		Properties pro= new Properties();
		pro.load(fis);
		String URL=pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
		
		//commented for base class
		//driver.get(URL);
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		/*//using POM: Getter Method
		LoginPage LP=new LoginPage(driver);
		LP.getUserTextField().sendKeys(USERNAME);
		LP.getPasswordTextField().sendKeys(PASSWORD);
		LP.getLoginButton().click();*/
		
		//commented for base class
//		LoginPage login= new LoginPage(driver);
//		login.loginToApplication(USERNAME, PASSWORD);
		
		/*driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Campaigns")).click();*/
		
		HomePage home= new HomePage(driver);
		home.clickOnMoreLink();
		home.clickOnCampaignLink();
		
		//Random Approach To avoid Duplicates
		Java_Ulitity jlib=new Java_Ulitity();
		int ranNum = jlib.getRandomNum();
		//Random ran = new Random();
		//int ranNum = ran.nextInt(1000);
		//fetch data from excel
		FileInputStream fis=new FileInputStream("C:\\Users\\sneha\\OneDrive\\Desktop\\MyExcelData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Campaign");
		Row row = sheet.getRow(0);
		Cell cel = row.getCell(0);
		String campName = cel.getStringCellValue()+ranNum;
		//String campName = "Marketing"+ranNum;
			
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		CampaignPage camppage= new CampaignPage(driver);
		camppage.clickOnPlusSign();
		
		//driver.findElement(By.name("campaignname")).sendKeys(campName);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		CreateCampaignPage createCampPage=new CreateCampaignPage(driver);
		createCampPage.createCampName(campName);
		createCampPage.clickOnSaveButton();
		
	// String campaignName = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
     ValidationPage validate=new ValidationPage(driver);
      String actdata = validate.campvalidate();
       //Assert.assertEquals(actdata, campName);
       Assert.assertEquals(true, false);//write it for listener to faile the script
       
     
	/*if(actData.contains(campName))
	{
		System.out.println("Campaign is Created");
	}
	else
	{
		System.out.println("Campaign is not Created");
	}*/
	
       driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
       driver.findElement(By.linkText("Sign Out")).click();
//home.logout(driver);
	}

}

package Organization;
import java.io.FileInputStream;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.bouncycastle.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utilities;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Ulitity;
import Generic_Utilities.WebDriver_utility;
import POMRepository.CreateOrganizationPage;
import POMRepository.HomePage;
import POMRepository.LoginPage;
import POMRepository.Organization;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization extends BaseClass {
    @Test
	public void CreateOrganization() throws Throwable {
    	//public static void main(String[] args) throws Throwable {
		//WebDriverManager.edgedriver().setup();
		//WebDriver driver=new EdgeDriver();
		//driver.manage().window().maximize();
    	// File_Utility flib= new File_Utility();
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
		WebDriver_utility wlib=new WebDriver_utility();
		wlib.maximizingWindow(driver);
		wlib.implicity_wait(driver);
		Thread.sleep(3000);
		
		//Fetch data from file
//		File_Utility flib= new File_Utility();
//		String URL=flib.getKeyAndValueData("url");
//		String USERNAME = flib.getKeyAndValueData("username");
//		String PASSWORD = flib.getKeyAndValueData("password");
		/*FileInputStream fis= new FileInputStream("./src/test/resources/Propertiesfile.property.txt");
		Properties pro = new Properties();
		pro.load(fis);
		
		//fetching key from property file
		String URL = pro.getProperty("url");
		String Username = pro.getProperty("username");
		String Password = pro.getProperty("password");*/
		
		//driver.get("http://localhost:8888/index.php?action=index&module=Home");
//		driver.get(URL);
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();*/
	//using POM	
	//	LoginPage login= new LoginPage(driver);
		//login.loginToApplication(USERNAME, PASSWORD);
        
       /* driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();*/
        		
		HomePage home=new HomePage(driver);
		home.clickOnorganizationslink();
		
		Organization orgPlus=new Organization(driver);
		orgPlus.clickOnCreateOrganization();
		
		
   //Random Approach To avoid Duplicates
        Java_Ulitity jlib= new Java_Ulitity();
        int ranNum = jlib.getRandomNum();
        /*Random ran= new Random();
        int ranNum = ran.nextInt(1000); */
       
        //String OrgName="Qspider"+ranNum;
        //Fetch Data from excel
       /* FileInputStream fes = new FileInputStream("C:\\Users\\sneha\\OneDrive\\Desktop\\MyExcelData.xlsx");
        Workbook book= WorkbookFactory.create(fes);
        Sheet sheet = book.getSheet("Organization");
        Row row = sheet.getRow(0);
        Cell cel = row.getCell(0);
        String OrgName = cel.getStringCellValue()+ranNum;
        */
        Excel_Utilities elit=new Excel_Utilities();
        //String OrgName = elit.getExceldata("Organization",0,0)+ranNum;
        String OrgName= elit.getExcelDataUsingDataFormatter("Organization",0,0)+ranNum;
      //  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        
       // driver.findElement(By.name("accountname")).sendKeys(OrgName);
        //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        CreateOrganizationPage createorg= new CreateOrganizationPage(driver);
        createorg.createAccountname(OrgName);
        createorg.clickonSaveButton();
        Thread.sleep(3000);
        
        
        //validation
        
      
        
        String prdname=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
        if(prdname.contains(OrgName))
        {
        	System.out.println("organization created successfully");
        }
        else
        {
        	System.out.println("organization is not created successfully");
        }
       driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
       driver.findElement(By.linkText("Sign Out")).click();
          
        
	}

}

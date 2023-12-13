package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import POMRepository.HomePage;
import POMRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	
	//@BeforeSuite(groups={"sanityTest","regressionTest","smokeTest"})
	@BeforeSuite
	public void beforSuite()
	{
		System.out.println("DataBase Connection Open");
	}
	
	//@BeforeTest(groups={"sanityTest","regressionTest","smokeTest"})
	@BeforeTest
	public void beforTest()
	{
		System.out.println("Parallel Execution Start");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass
	//@BeforeClass(groups={"sanityTest","regressionTest","smokeTest"})
	public void beforeClass() throws Throwable
	{
		//System.out.println("Launch Browser");
		File_Utility flib= new File_Utility();
      String BROWSER = flib.getKeyAndValueData("browser");	
      	if(BROWSER.equalsIgnoreCase("Edge"))
      	{
      		WebDriverManager.edgedriver().setup();
      		driver=new EdgeDriver();
      	}
      	else if(BROWSER.equalsIgnoreCase("Chrome"))
      	{
      		WebDriverManager.chromedriver().setup();
      		driver=new EdgeDriver();
      	}
      	else
      	{
      		driver=new ChromeDriver();
      	}
      	System.out.println("Launch Browser");
      	sdriver=driver;
	}
	
	@BeforeMethod
	//@BeforeMethod(groups={"sanityTest","regressionTest","smokeTest"})
	public void beforeMethod() throws Throwable
	{
		//System.out.println("Login To application");
		File_Utility flib= new File_Utility();
		String URL = flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PASSWORD = flib.getKeyAndValueData("password");
		
		driver.get(URL);
		LoginPage login= new LoginPage(driver);
        login.loginToApplication(USERNAME, PASSWORD);
        System.out.print("Login To application");	
        
	}
	
	@AfterMethod
	//@AfterMethod(groups={"sanityTest","regressionTest","smokeTest"})
	public void afterMethod()
	{
		System.out.println("Logout from application");
	}
	
	@AfterClass
	//@AfterClass(groups={"sanityTest","regressionTest","smokeTest"})
	public void afterClass()
	{
		HomePage home1= new HomePage(driver);
			home1.logout(driver);
	}
	
	/*@AfterTest
	//@AfterTest(groups={"sanityTest","regressionTest","smokeTest"})
	public void afterTest()
	{
		System.out.println("Parallel execution done");
	}
	
	@AfterSuite
	//@AfterSuite(groups={"sanityTest","regressionTest","smokeTest"})
	public void afterSuite()
	{
		System.out.println("Database Connection close");
	}*/
	
	

}

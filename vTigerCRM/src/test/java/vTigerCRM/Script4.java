package vTigerCRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Script4 {
//Script4. Login to vtiger application
	//click on Leads link
	//click on create lead lookup image
	//Enter FirstName,LastName and companyName
	//click on save Btn
	//verify whether the Lead is created with LastName and CompanyName in Lead Information page and Logout from the application. 
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

	}

}

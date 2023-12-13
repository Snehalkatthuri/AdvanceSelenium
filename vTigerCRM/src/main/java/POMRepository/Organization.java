package POMRepository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {

	public Organization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement plusSign;
	
	public WebElement getCreateOrganization() {
		return plusSign;
	}
	public void clickOnCreateOrganization()
	{
		plusSign.click();
	}
	
}

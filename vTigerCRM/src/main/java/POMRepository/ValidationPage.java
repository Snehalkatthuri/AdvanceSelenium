package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage {

	public ValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement Validation;
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement OrgValidation;

	

	public WebElement getValidation() {
		return Validation;
		
	}
	public WebElement getOrgValidation() {
		return OrgValidation;
	}
	
	public void setValidation(WebElement validation) {
		Validation = validation;
	}
	
	public void setOrgValidation(WebElement OrgValidation ) {
		OrgValidation=OrgValidation;
	}

	public String campvalidate()
	{
		return Validation.getText();
		
	}
public String orgvalidation()
{
	return OrgValidation.getText();
	}
	
}

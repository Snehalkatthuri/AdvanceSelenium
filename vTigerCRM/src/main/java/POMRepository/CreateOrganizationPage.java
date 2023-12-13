package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	//initialization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	
	@FindBy(name="accountname")
	private WebElement Accountname;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	
	//utilization
	public WebElement getAccountname() {
		return Accountname;
	}
	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	//Business Library
	public void createAccountname(String OrgName)
	{
		Accountname.sendKeys(OrgName);
	}
	public void clickonSaveButton()
	{
		SaveButton.click();
	}
	}

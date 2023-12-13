package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
//initialization
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//declaration
	@FindBy(name="campaignname")
	private WebElement campaignName;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
//utilization
	public WebElement getCampaignName() {
		return campaignName;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
//business library
	public void createCampName(String campName)
	{
		campaignName.sendKeys(campName);
	}
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
}

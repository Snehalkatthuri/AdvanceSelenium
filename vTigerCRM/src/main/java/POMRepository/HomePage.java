package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_utility;

public class HomePage {
	//initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	//Campaign Start
	@FindBy(linkText="More")
	private WebElement morelink;
	
	@FindBy(name="Campaigns")
	private WebElement campaignlink;
	//campaign end
	//organization start
	@FindBy(linkText="Organizations")
	private WebElement organizationslink;
	
	//organization end
	//logout start
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']\"")
	private WebElement administratorLink;
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	//logout End
//utilization
	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}
	public WebElement getOrganizationslink() {
		return organizationslink;
	}
	public WebElement getAdministratorLink() {
		return administratorLink;
	}
	public WebElement getSignOut() {
		return signOut;
	}

	//Business Logics
	public void clickOnMoreLink()
	{
	   morelink.click();
	}
	public void clickOnCampaignLink()
	{
		campaignlink.click();
	}
	public void clickOnorganizationslink()
	{
		organizationslink.click();
	}
	public void logout(WebDriver driver)
	{
		WebDriver_utility wlib= new WebDriver_utility();
		wlib.mouseOverOnelement(driver, administratorLink);
		signOut.click();
	}
	
}

package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPage {
	//Initialization

	public DeleteProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//declaration
	
	@FindBy(linkText="Products")
	private WebElement productTab; 
	
}


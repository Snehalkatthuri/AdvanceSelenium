package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	//@FindBy(name="user_password")
	@FindBys({@FindBy(name="user_password"),@FindBy(xpath="//input[@name='user_password']")})
	private WebElement PasswordTextField;
	
	@FindBy(id="submitButton")
	private WebElement LoginButton;
	
	//getter methods
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//Business Logics
	
	public void loginToApplication(String Username,String Password)
	{
		UserTextField.sendKeys(Username);
		PasswordTextField.sendKeys(Password);
		LoginButton.click();
	}
	

}

package Generic_Utilities;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_utility {

	/**
	 *This method is used to maximize the window
	 *@param driver
	 */
	public void maximizingWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method is used implicit wait
	 * @param driver
	 */
	public void implicity_wait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	//Handling DropDown
	public void dropDown(WebElement ele, String text, int index, String value)
	{
		Select s= new Select(ele);
		s.selectByVisibleText(text);
	}

	public void dropDownUsingIndex(WebElement ele, int index)
	{
		Select s= new Select(ele);
		s.selectByIndex(index);
	}
	
	public void dropDownUsingValue(WebElement ele, String value)
	{
		Select s= new Select(ele);
		s.selectByValue(value);
	}
	
	/**This method is used for switching Window
	 * @param driver
	 * @param partialVisibleText
	 **/
	public void windowSwitching(WebDriver driver,String partialVisibleText)
	{
		Set <String>allWin=driver.getWindowHandles();
		Iterator<String>win=allWin.iterator();
		while(win.hasNext())
		{
			String winText = win.next();
			driver.switchTo().window(winText);
			String title = driver.getTitle();
			if(title.contains(partialVisibleText))
			{
				break;
			}
		}
	}
	public void alertDismiss(WebDriver driver)
	{
		Alert alt= driver.switchTo().alert();
	   alt.dismiss();
	}
	public void alertAccept(WebDriver driver)
	{
		Alert alt= driver.switchTo().alert();
	   alt.accept();
	}
	
	//mouser hoverring
	public void mouseOverOnelement(WebDriver driver, WebElement ele)
	{
		Actions act= new Actions(driver);
		act.moveToElement(ele).perform();
	}
}

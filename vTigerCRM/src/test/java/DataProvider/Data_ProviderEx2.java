package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utilities;

public class Data_ProviderEx2 {
	@Test(dataProvider = "dataprovider_BookTicketTest" )
	public void bookTickets(String src, String dest)
	{
		System.out.println("Book Tickets from "+src+" to "+dest+"");
	}

	@DataProvider
	public Object[][]dataprovider_BookTicketTest() throws Throwable
	{
		Excel_Utilities elib= new Excel_Utilities();
		Object[][]value= elib.getDataProvider("Sheet1");
		
		return value ;
		}
}

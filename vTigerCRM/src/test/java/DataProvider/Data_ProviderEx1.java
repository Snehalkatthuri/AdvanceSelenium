package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_ProviderEx1 {
	@Test(dataProvider = "dataprovider_BookTicketTest" )
	public void bookTickets(String src, String dest)
	{
		System.out.println("Book Tickets from "+src+" to "+dest+"");
	}

	@DataProvider
	public Object[][]dataprovider_BookTicketTest()
	{
		Object[][]obj= new Object[2][2];
		obj[0][0]="Hyderabad";
		obj[0][1]="Pune";
		
		obj[1][0]="Hyderabad";
		obj[1][1]="Banglore";
		
		return obj;
		}
}

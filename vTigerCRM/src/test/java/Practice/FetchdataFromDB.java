package Practice;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

public class FetchdataFromDB {

	public static void main(String[] args) throws Throwable {
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/employee","root","root");
		Statement state= conn.createStatement();
		String query="Select *from qspiders";
		ResultSet result= state.execteQuery(query);

		while(result.next())
		{
			System.out.print(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		conn.close();
	}

}

package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
/**
 * This method is used to fetch commom data in application
 * @param Key
 * @return 
 * @return
 * @throws Throwable 
 * @throws Throwable
 **/
	
	public String getKeyAndValueData(String key) throws Throwable
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/Propertiesfile.property.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
}

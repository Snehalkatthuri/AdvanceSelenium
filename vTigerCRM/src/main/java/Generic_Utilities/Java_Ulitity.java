package Generic_Utilities;

import java.util.Random;

public class Java_Ulitity {
	/**
	 * This method is used to avoid duplicate
	 * 
	 * @author snehal*
	 */
	
	public int getRandomNum()
	{
		Random ran = new Random();
		int ranNum=ran.nextInt(1000);
		return ranNum;
	}

}

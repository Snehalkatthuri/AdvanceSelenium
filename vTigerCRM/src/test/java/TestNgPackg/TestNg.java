package TestNgPackg;

import org.testng.annotations.Test;


public class TestNg {
	@Test(priority=2,invocationCount=1)
	//@Test(invocationCount=1)
	public void createProduct()
	{
		System.out.println("Product creted");
	}
	@Test(priority=0,dependsOnMethods="createProduct",invocationCount=2)
	//@Test(dependsOnMethods="createProduct")
	//@Test(invocationCount=2)
	public void modifyProduct()
	{
		System.out.println("Product modified");
	}
	@Test(priority=1,dependsOnMethods="createProduct",invocationCount=3)
	//@Test(dependsOnMethods="createProduct")
	//@Test(invocationCount=3)
	//@Test(enabled=false)
	public void deleteProduct()
	{
		System.out.println("Product deleted");
	}

}

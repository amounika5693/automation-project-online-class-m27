package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGSample {
	@Test(priority=-1,invocationCount=3)
	
	public void CareateSample()
	{
		Assert.fail();//forcefully fail the tc
		System.out.println("create");
	}
	
	@Test(dependsOnMethods="CareateSample")
	public void modifySample()
	{
		System.out.println("modify");
	}
	
	@Test//if we dont want to execute the the tc for this point of time we can use this
	public void deleteSample()
	{
		System.out.println("delete");
	}
	
	//invocation count is no of times the tc should be executed ....it is phycical entity should not be -ve
	//priority is by default 0
	//least priority will execute first....we can give negative priority
	//execution will always be in ascii order (small abc will have least value so they execute first)
	
	
	
}

package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
 
	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)//retry analyser clsss is present in generic utilities package from there im taking properties and im retrying the failed testscripts to run for 3 times again to make the test pass if test script is failed because of any network or server issues
	//im failing this test script to see the retry analyser implementation it will repeat for 3 times and the script will run for 1 time (for the first time )
	public void sample()//hard assertion
	{
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		
		Assert.assertEquals(0, 1);
		
		System.out.println("step 4");
		System.out.println("step 5");
		System.out.println("step 6");
		
		//if i give 1,1 in line 15 it will execute correctly because 1 equals 1
		
		//else it will throw assertion error for (0,1)
		
		
		
		
		
		
		
	}
	
	@Test
	public void sampleSoft()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		
	sa.assertEquals(1, 1);
		
		System.out.println("step 4");
		System.out.println("step 5");
		System.out.println("step 6");
		
		sa.assertAll(); //this method is mandatory for soft assert to get the error where it happend
		//if i give 1,1 in line 15 it will execute correctly because 1 equals 1
		
		//else it will throw assertion error for (0,1)
	}
}

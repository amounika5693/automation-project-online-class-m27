package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this class provides the implementation of IretryAnalyser Interface of TestNG
 * @author mounika
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer {
int count =0;
int retrycount =3;//manual analysis
	@Override
	public boolean retry(ITestResult result) {
		//0<3 ->yes 1<3 ->yes 2<3 ->yes 3<3-->no
	while(count<retrycount)	
	{
		count++;//1 2 3
		return true;//retyy retry retry
	}
		return false;//stop retry
	}

}

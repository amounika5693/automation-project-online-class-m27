package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgSample2 {
@Test(dataProvider="getData")
public void createEmpData(String name,int id)
{
	System.out.println("name is  "+name);
	System.out.println("id is  "+id);
}

@DataProvider
public Object[][] getData1()
{
	
	Object[][] data=new Object[3][2];//3X2 three data sets and each consists of 2 info
	// 1st data set
	data[0][0]="chaitra";
	data[0][1]=22;
	
	// 2nd data set
		data[1][0]="chait";
		data[1][1]=22;
		
		// 3rd data set
		data[2][0]="cham";
		data[2][1]=22;
		
	return data;
	
}





}

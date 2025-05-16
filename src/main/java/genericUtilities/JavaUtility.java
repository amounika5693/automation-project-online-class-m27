package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * this class contains of generic methods related to java
 * @author Shiva
 */
public class JavaUtility {
	
	/**
	 * This method will capture the current system date in required format
	 * and return to caller
	 * @return
	 */
public String getSystemDate()
{
Date d=new Date();
SimpleDateFormat f=new SimpleDateFormat("dd-mm-yyyy_hh-mm-ss");
	String dateinformat=f.format(d);
	return dateinformat;
}
}


 
























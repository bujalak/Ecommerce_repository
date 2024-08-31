package Abstarct_components;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_analyzer implements IRetryAnalyzer {
 
	
	int count =0;
	int maxcount =1;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		 if(count<maxcount) {
			 count++;
			 return true;
		 }
		return false;
	}

}

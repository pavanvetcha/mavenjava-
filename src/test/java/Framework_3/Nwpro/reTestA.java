package Framework_3.Nwpro;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class reTestA implements IRetryAnalyzer{


	int count=0;
	int maxTry=1;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxTry)
		{
			count++;
			return true;
		}
		return false;
	}

}

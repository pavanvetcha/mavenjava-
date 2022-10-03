package Framework_3.Nwpro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Framework_3.pgo.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage lp;
	public WebDriver intializeDriver() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\K.BHAVYA\\eclipse-workspace\\Nwpro\\src\\test\\java\\Framework_3\\Nwpro\\dataprop");
		
		Properties prop= new Properties();
		prop.load(fis);
		String BrowserName=prop.getProperty("browser");
		if(BrowserName.contains("chrome")) {
			ChromeOptions options= new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(BrowserName.contains("headless")) {
				options.addArguments("headless");	
			}
			
			 driver= new ChromeDriver(options);;
		}
		
		
		return driver;
		
	}	
	
		
	public List<HashMap<String, String>> getDatapro(String filepath) throws IOException {
		
		String jsonContent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>> (){});
		return data;
	}
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		FileUtils.copyFile(src,new File(dest));
		return dest;
	}
			
			
}	
	



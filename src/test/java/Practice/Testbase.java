package Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import Com_qa_pages.Landing_page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	
	public WebDriver driver;
	public Landing_page page;

	
	public WebDriver intializedriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\kiran\\eclipse-workspace\\Rahul_shetty_Ecommerce\\src\\test\\java\\Com\\qa\\resources\\resources.properties");
		prop.load(file);
		
		
		String browsername = System.getProperty("broswer")!=null?System.getProperty("browser"):prop.getProperty("browser");
		//String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		//ChromeOptions options = new ChromeOptions();
        //options.addArguments("disable-infobars");

	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
	}	
		return driver;
}
	@BeforeMethod(alwaysRun = true)
	public Landing_page launchapplication() throws IOException {	
		driver = intializedriver();
		page = new Landing_page(driver);
		page.Goto();
		return page;

		
	}
	
	@AfterMethod(alwaysRun = true)
	
	public void teardown() {
		driver.quit();
	}
	
	public String getscreenshot(String testcasename, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		File target = new File(System.getProperty("user.dir")+"//reports"+testcasename+".png");
		FileUtils.copyFile(src, target);
		return System.getProperty("user.dir")+"//reports//"+ testcasename+".png";
		
		
	}
  
}

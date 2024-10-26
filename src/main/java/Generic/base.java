package Generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.exec.TimeoutObserver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base extends lib{
public WebDriver driver;
public ChromeOptions option;
	
	@BeforeMethod
	public void openApplication() throws IOException {
		option=new ChromeOptions();
		option.addArguments("--disable-notifications");
	    driver = new ChromeDriver(option);
		String url = lib.excelfile("TestData1",1,1);
		driver.get(url);
		Reporter.log("application launched"+url, true);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeApplication() throws IOException {
		lib.Screenshot_Method(driver);
		
	}
	
}

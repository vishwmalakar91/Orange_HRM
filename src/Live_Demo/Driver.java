package Live_Demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class Driver extends Main{
  @BeforeSuite
  public void DriverSetup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\S3.4\\chromedriver.exe");
		d=new ChromeDriver();
		d.get(OHUrl);	  
  }
}


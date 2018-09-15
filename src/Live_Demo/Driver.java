package Live_Demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class Driver extends Main1{
  @BeforeSuite
  public void DriverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishw\\OneDrive\\Desktop\\Repo\\Github\\mySelenium\\Drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.get(OHUrl);	  
  }
}


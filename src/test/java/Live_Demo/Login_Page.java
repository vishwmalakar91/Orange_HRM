
package Live_Demo;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Login_Page extends Main  {
	@BeforeTest
	@Parameters({"username_ORHM","password_ORHM"})
	public static void Login(String user_id, String Password) throws Exception
	{	
		Sync.waitForLoad(d);
		d.findElement(By.name("txtUsername")).sendKeys(user_id);
		d.findElement(By.name("txtPassword")).sendKeys(Password);
		d.findElement(By.name("Submit")).click();
	}
}

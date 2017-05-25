package Live_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page {
	static WebDriver d;

	public static void Login(String user_id, String Password) throws Exception
	{	
		Sync.waitForLoad(d);
		d.findElement(By.name("txtUsername")).sendKeys(user_id);
		d.findElement(By.name("txtPassword")).sendKeys(Password);
		d.findElement(By.name("Submit")).click();
	}
}

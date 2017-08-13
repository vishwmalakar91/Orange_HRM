
package Live_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Admin extends Main {
	public static void Admin_Add_User(String Role,String Name,String U_Name,String Status,String Pass)throws Exception
	{
	Thread.sleep(2000);
	d.findElement(By.xpath(".//a[@href='/index.php/admin/viewAdminModule']")).click();
	Thread.sleep(2000);
	d.findElement(By.xpath(".//a[@href='/index.php/admin/viewAdminModule']")).click();
	Thread.sleep(2000);
	d.findElement(By.xpath(".//input[@value='Add']")).click();
	Thread.sleep(2000);
	Sync.waitForLoad(d);
	Select DD_UType=new Select(d.findElement(By.id("systemUser_userType")));
	DD_UType.selectByVisibleText(Role);
	d.findElement(By.id("systemUser_employeeName_empName")).sendKeys(Name);
	d.findElement(By.id("systemUser_userName")).sendKeys(U_Name);
	Select DD_Status=new Select(d.findElement(By.id("systemUser_status")));
	DD_Status.selectByVisibleText(Status);
	d.findElement(By.id("systemUser_password")).sendKeys(Pass);
	d.findElement(By.id("systemUser_confirmPassword")).sendKeys(Pass);
	d.findElement(By.id("btnSave")).click();
	System.out.println("User Added Successfully, User Name: "+U_Name+" , Password : "+Pass);
	}
	public static void Delete_User(String U_name)throws Exception
	{
		Thread.sleep(2000);
		d.findElement(By.xpath(".//a[@href='/index.php/admin/viewAdminModule']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath(".//a[@href='/index.php/admin/viewAdminModule']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath(".//a[text()='"+U_name+"']//preceding::td[1]/input")).click();
		d.findElement(By.id("btnDelete")).click();
		Thread.sleep(2000);
		d.findElement(By.id("dialogDeleteBtn")).click();
		System.out.println("User : "+U_name+" => Deleted Successfully");
		}
}

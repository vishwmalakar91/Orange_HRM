package Live_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PIM extends Main1 {
	static int Emp_id;
	@Test
	@Parameters({"FName","MName","LName","UName","UPass","Status"})
	public static void Add_Eployee(String F_Name,String M_Name,String L_Name,String U_Name,String Pass,String Status)throws Exception
	{
	String Create_Login_Details="Y";
	Thread.sleep(2000);
	d.findElement(By.id("menu_pim_viewPimModule")).click();
	Thread.sleep(2000);
	d.findElement(By.id("menu_pim_viewPimModule")).click();
	Thread.sleep(2000);
	d.findElement(By.id("btnAdd")).click();
	Thread.sleep(2000);
	Sync.waitForLoad(d);
	String Temp=d.findElement(By.name("employeeId")).getAttribute("value");
	Emp_id=Integer.parseInt(Temp);
	d.findElement(By.id("firstName")).sendKeys(F_Name);
	d.findElement(By.id("middleName")).sendKeys(M_Name);
	d.findElement(By.id("lastName")).sendKeys(L_Name);
	if(Create_Login_Details=="Y")
	{
	d.findElement(By.id("chkLogin")).click();
	d.findElement(By.id("user_name")).sendKeys(U_Name);
	d.findElement(By.id("user_password")).sendKeys(Pass);
	d.findElement(By.id("re_password")).sendKeys(Pass);
	Select DD_Status=new Select(d.findElement(By.id("status")));
	DD_Status.selectByVisibleText(Status);
	}
	d.findElement(By.id("btnSave")).click();
	System.out.println("Emplyee Added Successfully ,Employee Name : "+F_Name+" "+M_Name+" "+L_Name+" , Employee ID : "+Emp_id);
	if(Create_Login_Details=="Y")
		{
		System.out.println("User Added Successfully, User Name: "+U_Name+" , Password : "+Pass);	
		}
	}

	//Need to pass Emp ID @Parameters({Emp_id,"FName"})
	
public static void Delete_Employee(int Emp_Id,String Emp_Name) throws Exception
{
	Thread.sleep(2000);
	d.findElement(By.id("menu_pim_viewPimModule")).click();
	Thread.sleep(2000);
	d.findElement(By.id("menu_pim_viewPimModule")).click();
	Thread.sleep(2000);
	d.findElement(By.xpath(".//a[contains(text(),'"+Emp_Name+"')]//ancestor::td//preceding::td//input[@value="+Emp_Id+"]")).click();
	d.findElement(By.id("btnDelete")).click();
	Thread.sleep(2000);
	d.findElement(By.id("dialogDeleteBtn")).click();
	System.out.println("Emplyee : "+Emp_Name+", Emp ID : "+Emp_Id+" => Deleted Successfully");
	}
	
@Test
@Parameters({"FName"})
	public static void Delete_Employee(String Emp_Name) throws Exception
	{
		Thread.sleep(2000);
		d.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(2000);
		d.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath(".//a[contains(text(),'"+Emp_Name+"')]//ancestor::td//preceding::td//input")).click();
		d.findElement(By.id("btnDelete")).click();
		Thread.sleep(2000);
		d.findElement(By.id("dialogDeleteBtn")).click();
		System.out.println("Emplyee : "+Emp_Name+" => Deleted Successfully");
		}

}

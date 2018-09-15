package Live_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo{
	
	static WebDriver d;
	
	public static void main(String[] args) throws Exception {
		
	String OHUrl="https://opensource-demo.orangehrmlive.com/";
	String user_id="Admin";
	String Password="admin";
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishw\\OneDrive\\Desktop\\Repo\\Github\\mySelenium\\Drivers\\chromedriver.exe");
	d=new ChromeDriver();
	//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\S3.4\\geckodriver.exe");
	//d=new FirefoxDriver();
	
	d.manage().window().maximize();
	d.get(OHUrl);
	Login(user_id,Password);
	Add_Eployee("Vishwanath","","Malakar","Vishwa1","Vishwa1","Enabled");
	Admin_Add_User("Admin","Vishwanath Malakar","Vishwa.3","Enabled","Vishwa.3");
	Add_Vacancies("IT Executive","Test Engineer","Vishwanath Malakar",3);
	Delete_User("Vishwa.3");
	Delete_User("Vishwa1");
	Delete_Vacancies("Test Engineer");
	Delete_Employee(PIM.Emp_id,"Vishwanath");
	
	/*for(int i=17;i<=25;i++)
	{
		Delete_Employee(i,"selenium");	
	}*/
	
	//d.close();
	}


public static void Login(String user_id, String Password) throws Exception
{	
	waitForLoad(d);
	d.findElement(By.name("txtUsername")).sendKeys(user_id);
	d.findElement(By.name("txtPassword")).sendKeys(Password);
	d.findElement(By.name("Submit")).click();
}

public static void Admin_Add_User(String Role,String Name,String U_Name,String Status,String Pass)throws Exception
	{
	Thread.sleep(2000);
	d.findElement(By.xpath(".//a[@href='/index.php/admin/viewAdminModule']")).click();
	Thread.sleep(2000);
	d.findElement(By.xpath(".//a[@href='/index.php/admin/viewAdminModule']")).click();
	Thread.sleep(2000);
	d.findElement(By.xpath(".//input[@value='Add']")).click();
	Thread.sleep(2000);
	waitForLoad(d);
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
	waitForLoad(d);
	String Temp=d.findElement(By.name("employeeId")).getAttribute("value");
	PIM.Emp_id=Integer.parseInt(Temp);
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
	System.out.println("Emplyee Added Successfully ,Employee Name : "+F_Name+" "+M_Name+" "+L_Name+" , Employee ID : "+PIM.Emp_id);
	if(Create_Login_Details=="Y")
		{
		System.out.println("User Added Successfully, User Name: "+U_Name+" , Password : "+Pass);	
		}
	}

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
public static void Add_Vacancies(String Job_Title,String Vacancy_Name,String Hiring_Manager,int NOP)throws Exception
{	
	Thread.sleep(2000);
	d.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
	Thread.sleep(2000);
	d.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
	Thread.sleep(2000);
	d.findElement(By.id("btnAdd")).click();
	waitForLoad(d);
	Thread.sleep(3000);
	Select DP_JT=new Select(d.findElement(By.id("addJobVacancy_jobTitle")));
	DP_JT.selectByVisibleText(Job_Title);
	d.findElement(By.id("addJobVacancy_name")).sendKeys(Vacancy_Name);
	d.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(Hiring_Manager);
	String NOP_C = Integer.toString(NOP);
	d.findElement(By.id("addJobVacancy_noOfPositions")).sendKeys(NOP_C);
	d.findElement(By.id("addJobVacancy_description")).sendKeys("dec");
	String Check=d.findElement(By.id("addJobVacancy_status")).getAttribute("checked");
	if(Check!= null)
	{	
		System.out.println("Active - Check box is Already checked");			
	}
	else
	{
		d.findElement(By.id("addJobVacancy_status")).click();	
	}
	d.findElement(By.id("btnSave")).click();
	System.out.println("Vacancy Added Successfully , Job Title : "+Job_Title+" , Vacancy Name: "+Vacancy_Name+" , Number Of Positions : "+NOP);
	}
public static void Delete_Vacancies(String Vacancy_Name)throws Exception
{
	Thread.sleep(2000);
	d.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
	Thread.sleep(2000);
	d.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
	waitForLoad(d);
	Thread.sleep(3000);
	d.findElement(By.xpath(".//a[text()='"+Vacancy_Name+"']//preceding::td[1]")).click();
	d.findElement(By.name("btnDelete")).click();
	Thread.sleep(2000);
	d.findElement(By.id("dialogDeleteBtn")).click();
	System.out.println("Job Vacancy : "+Vacancy_Name+ " => Deleted Successfully");
	}

public static void waitForLoad(WebDriver driver) 
{
    new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
}
}
  
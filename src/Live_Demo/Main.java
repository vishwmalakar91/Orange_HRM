package Live_Demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	public static WebDriver d;
	
public static void main(String[] args) throws Exception {
	
	String OHUrl="http://opensource.demo.orangehrmlive.com/index.php/auth/login";
	String user_id="Admin";
	String Password="admin";
	
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\S3.4\\chromedriver.exe");
	d=new ChromeDriver();
	//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\S3.4\\geckodriver.exe");
	//d=new FirefoxDriver();
	
	d.manage().window().maximize();
	d.get(OHUrl);
	Login_Page.Login(user_id,Password);
	PIM.Add_Eployee("Vishwanath","","Malakar","Vishwa1","Vishwa1","Enabled");
	Admin.Admin_Add_User("Admin","Vishwanath Malakar","Vishwa.3","Enabled","Vishwa.3");
	Recruitment.Add_Vacancies("IT Executive","Test Engineer","Vishwanath Malakar",3);
	Admin.Delete_User("Vishwa.3");
	Admin.Delete_User("Vishwa1");
	Recruitment.Delete_Vacancies("Test Engineer");
	PIM.Delete_Employee(PIM.Emp_id,"Vishwanath");
}
}

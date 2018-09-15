package Live_Demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main1 {
	
	public static WebDriver d;
	static String OHUrl="https://opensource-demo.orangehrmlive.com/";
	static String user_id="Admin";
	static String Password="admin123";
	
	public static void main(String[] args) throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishw\\OneDrive\\Desktop\\Repo\\Github\\mySelenium\\Drivers\\chromedriver.exe");
	d=new ChromeDriver();
	//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\S3.4\\geckodriver.exe");
	//d=new FirefoxDriver();
	
	d.manage().window().maximize();
	d.get(OHUrl);
	Login_Page.Login(user_id,Password);
	PIM.Add_Eployee("Vishwanath","","Malakar","Vishwa1","Vishwa123","Enabled");
	Admin.Admin_Add_User("Admin","Vishwanath Malakar","Vishwa.3","Enabled","Vishwa.3");
	//Recruitment.Add_Vacancies("IT Executive","Test Engineer","Vishwanath Malakar",3);
	Admin.Delete_User("Vishwa.3");
	Admin.Delete_User("Vishwa1");
	//Recruitment.Delete_Vacancies("Test Engineer");
	PIM.Delete_Employee(PIM.Emp_id,"Vishwanath");

}
}

package Live_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Recruitment {
	static WebDriver d;
	public static void Add_Vacancies(String Job_Title,String Vacancy_Name,String Hiring_Manager,int NOP)throws Exception
	{	
		Thread.sleep(2000);
		d.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		Thread.sleep(2000);
		d.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
		Thread.sleep(2000);
		d.findElement(By.id("btnAdd")).click();
		Sync.waitForLoad(d);
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
		Sync.waitForLoad(d);
		Thread.sleep(3000);
		d.findElement(By.xpath(".//a[text()='"+Vacancy_Name+"']//preceding::td[1]")).click();
		d.findElement(By.name("btnDelete")).click();
		Thread.sleep(2000);
		d.findElement(By.id("dialogDeleteBtn")).click();
		System.out.println("Job Vacancy : "+Vacancy_Name+ " => Deleted Successfully");
		}

}

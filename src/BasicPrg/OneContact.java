package BasicPrg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OneContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
WebDriverManager.chromedriver().setup();
		
		ChromeOptions Chromeoptions = new ChromeOptions();
		Chromeoptions.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(Chromeoptions);
		driver.manage().window().maximize();
		driver.get("https://www.mycontactform.com/");
		
		driver.findElement(By.id("user")).sendKeys("sen1");
		Thread.sleep(2000);
		driver.findElement(By.name("pass")).sendKeys("Asdf@1234");
		driver.findElement(By.name("btnSubmit")).click();
		
	String actResult = driver.findElement(By.xpath("/html/body/div[3]/div[3]/h5")).getText();
		
		if (actResult.contains("sen1"))
			System.out.println("Successfully logged in");
		else
			System.out.println("Invalid username and Password");

	}

}

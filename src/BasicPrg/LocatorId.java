package BasicPrg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorId {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stubDriver
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions Chromeoptions = new ChromeOptions();
		Chromeoptions.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(Chromeoptions);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("9689531678");
		Thread.sleep(2000);
		driver.findElement(By.name("pass")).sendKeys("vij()123");
		Thread.sleep(2000);
		driver.findElement(By.name("login")).click();

	}

}

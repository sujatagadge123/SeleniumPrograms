package BasicPrg;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfirmationAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
		
		ChromeOptions Chromeoptions = new ChromeOptions();
		Chromeoptions.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(Chromeoptions);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(3000);
		
		Alert alert  = driver.switchTo().alert();
		//System.out.println("The message in Alert window is :" +alert.getText());
		alert.accept();
		
		System.out.println(driver.findElement(By.id("confirmResult")).getText());

	}

}

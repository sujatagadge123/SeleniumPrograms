package BasicPrg;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PromptAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		ChromeOptions Chromeoptions = new ChromeOptions();
		Chromeoptions.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(Chromeoptions);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		
		WebElement promtAlertButton = driver.findElement(By.id("promtButton"));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("windows.scrollBy(0,200)");
		
		jse.executeScript("arguments[0].scrollIntoView", "promtAlertButton");
		Thread.sleep(3000);
		
		promtAlertButton.click();		
		//driver.findElement(By.id("promtButton")).click();
		Thread.sleep(3000);
		
		Alert alert  = driver.switchTo().alert();
		
		alert.sendKeys("selenium for Deloitte");
		//System.out.println("The message in Alert window is :" +alert.getText());
		alert.accept();
		
		//System.out.println(driver.findElement(By.id("confirmResult")).getText());


	}

}

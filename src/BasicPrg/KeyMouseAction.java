package BasicPrg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyMouseAction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		ChromeOptions Chromeoptions = new ChromeOptions();
		Chromeoptions.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(Chromeoptions);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/menu#");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3);
	
	    WebElement menuItem2 = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a"));
		WebElement subsubList = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/a"));
		WebElement subsubItem2 = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/ul/li[2]/a"));
		
		Actions acts = new Actions(driver);
		
		acts.moveToElement(menuItem2)
		.pause(Duration.ofSeconds(2))
		.moveToElement(subsubList)
		.pause(Duration.ofSeconds(2))
		.moveToElement(subsubItem2)
		.click()
		.build()
		.perform();

		
	}

}

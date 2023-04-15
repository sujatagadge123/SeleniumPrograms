package BasicPrg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipcart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
		
		ChromeOptions Chromeoptions = new ChromeOptions();
		Chromeoptions.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(Chromeoptions);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		driver.findElement(By.name("q")).sendKeys("laptop");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
		List<WebElement> totalLaps =  driver.findElements(By.className("_4rR01T"));
		System.out.println("Total no of Laps:" + totalLaps.size());
		
		for (WebElement eachLap : totalLaps){
			
			System.out.println(eachLap.getText());
		}

	}

}

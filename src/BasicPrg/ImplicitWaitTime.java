package BasicPrg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
		
		ChromeOptions Chromeoptions = new ChromeOptions();
		Chromeoptions.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(Chromeoptions);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.advantageonlineshopping.com/");
		System.out.println("The output is : " + driver.findElement(By.xpath("//*[@id=\"speakersTxt\"]")).getText());
		

	}

}

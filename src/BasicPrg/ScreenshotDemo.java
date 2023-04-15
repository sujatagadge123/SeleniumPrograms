package BasicPrg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.timeout.TimeoutException;

public class ScreenshotDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		ChromeOptions Chromeoptions = new ChromeOptions();
		Chromeoptions.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(Chromeoptions);
		driver.manage().window().maximize();
		driver.get("https://www.mycontactform.com/");
		
		driver.findElement(By.id("user")).sendKeys("sen2");
		Thread.sleep(2000);
		driver.findElement(By.name("pass")).sendKeys("Asdf@1235");
		driver.findElement(By.name("btnSubmit")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try
		{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user_bar\"]/h5")));
		}catch(TimeoutException ie) {
		TakesScreenshot scrnshot = (TakesScreenshot) driver;
		File srcfile = scrnshot.getScreenshotAs(OutputType.FILE);
		
		File desfile = new File(".\\src\\test\\resources\\Screenshots\\ screenshot.png");
		FileUtils.copyFile(srcfile, desfile);
		}
	//String actResult = driver.findElement(By.xpath("/html/body/div[3]/div[3]/h5")).getText();
	//	String actResult = driver.findElement(By.xpath("//*[@id=\"sec_nav\"]/h5")).getText();

		
	//	if (actResult.contains("sen1"))
			//System.out.println("Successfully logged in");
	//else
			//System.out.println("Invalid username and Password");

	}


	}


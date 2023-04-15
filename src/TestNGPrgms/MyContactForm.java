package TestNGPrgms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyContactForm {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		ChromeOptions Chromeoptions = new ChromeOptions();
		Chromeoptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(Chromeoptions);
		driver.manage().window().maximize();
		driver.get("https://www.mycontactform.com/");
	}

	@AfterClass
	public void afterclass() {
		driver.quit();
	}

	@Test
	public void validateLogintest() throws InterruptedException {

		driver.findElement(By.id("user")).sendKeys("sen1");

		driver.findElement(By.name("pass")).sendKeys("Asdf@1234");
		driver.findElement(By.name("btnSubmit")).click();

		String actResult = driver.findElement(By.xpath("//*[@id=\"user_bar\"]/h5")).getText();

		Assert.assertEquals(actResult, "Welcome sen1");
		Assert.assertTrue(actResult.contains("sen1"));

		if (actResult.contains("sen1"))
			System.out.println("Successfully logged in");
		else
			System.out.println("Invalid username and Password");

	}
}

package BasicPrg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.chrome.driver", "C:\\Training Software\\Jar Files\\Drivers\\chromedriver_win32 (2)\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.com/");
		
		String expResult = "Book bus tickets online with redBus!";
		String actResult = driver.getTitle();
		
		if (actResult.equals(expResult))
			System.out.println("passed");
		else
			System.out.println("failed");
		
		driver.quit();

	}

}

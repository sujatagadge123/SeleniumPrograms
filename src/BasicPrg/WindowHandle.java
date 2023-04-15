package BasicPrg;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

WebDriverManager.chromedriver().setup();
		
		ChromeOptions Chromeoptions = new ChromeOptions();
		Chromeoptions.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(Chromeoptions);
		driver.manage().window().maximize();
		driver.get("http://cookbook.seleniumacademy.com/config.html");
		//https://cookbook.seleniumacademy.com/config.html
		
		String parentWindow = driver.getWindowHandle();
	System.out.println("parent window = " + parentWindow);

	
	driver.findElement(By.id("helpbutton")).click();
	Set<String> allWindows = driver.getWindowHandles();
	
	for (String eachWindow : allWindows) {
		System.out.println(parentWindow + "\t" +eachWindow);
	if(parentWindow.equals(eachWindow)) {
		System.out.println("Child Window " + eachWindow);
		
		driver.switchTo().window(eachWindow);
		System.out.println("Text in Child Window is =" + driver.findElement(By.xpath("/html/body/div/h3")).getText());
	}
		}
	
	}

}

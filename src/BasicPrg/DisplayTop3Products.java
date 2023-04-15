package BasicPrg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DisplayTop3Products {

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
		
		System.out.println("laptop \t price");
		for (int i = 2; i<=4; i++) {
		String prodName = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[3]/div/div[" + i + "]/h1/span")).getText();
		String ProdPrice = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[3]/div/div[" + i + "]/div[1]/div/div[1]")).getText();
		
		System.out.println(prodName + "\t" + ProdPrice);
		}
	}

}

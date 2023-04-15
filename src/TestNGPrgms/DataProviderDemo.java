package TestNGPrgms;

import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class DataProviderDemo {
   WebDriver driver;
  @Test(dataProvider = "dp")
  public void displayBooks(String bookName, String SortOrderBy) throws InterruptedException {
	  
	  //below code is to launch browser
	  
	  //to search for book
	  driver.findElement(By.id("inputbar")).sendKeys(bookName);
		driver.findElement(By.name("btnTopSearch")).click();
		Thread.sleep(4000);
		
		//to display total no of books
			String resultMsg = driver.findElement(By.xpath("//*[@id=\"site-wrapper\"]/div[1]/div[2]/div[1]/div[1]/div/b")).getText();
			 System.out.println("Total No of books for : " + bookName + " is = " + resultMsg);
			 Thread.sleep(2000);
			 
			 //to select from sort order
			 Select select = new Select(driver.findElement(By.id("ddlSort")));
				
				//System.out.println("sorted");
				Thread.sleep(2000);
				
				//to dislpay top 2 book name and price
				for (int i = 1; i <= 2; i++) {

					System.out.print(driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div[" + i + "]/div[3]/div[1]/a"))
									.getText() + " - ");

					List<WebElement> total = driver.findElements(By.xpath("//*[@id=\"listSearchResult\"]/div[" + i + "]/div[3]/div[4]/div[1]/div"));
					
					//displaying book price
					if (total.size() == 1)
						System.out.println(
								driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div["+ i +"]/div[3]/div[4]/div[1]/div"))
										.getText());
					else
						System.out.println(
								driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div["+ i +"]/div[3]/div[4]/div[1]/div[2]"))
										.getText());
					
				}

  }

  @DataProvider
  public Object[][] dp() {
    Object[][] data = new Object[2][2];
     data = ReadExcel.readData();
     return data;
    }
    
  
  @BeforeClass
  public void beforeClass() {
	  WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.bookswagon.com/");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}

package BasicPrg;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

class DDFDemo{
	
	WebDriver driver;
	
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.bookswagon.com/");
	}
	
	public void searchBook(String bookName) throws InterruptedException {
		driver.findElement(By.id("inputbar")).sendKeys(bookName);
		driver.findElement(By.name("btnTopSearch")).click();
		Thread.sleep(4000);
    }
	
	public void displayTotalNoOfBooks() throws InterruptedException {
		String resultMsg = driver.findElement(By.xpath("//*[@id=\"site-wrapper\"]/div[1]/div[2]/div[1]/div[1]/div/b")).getText();
		 System.out.println("Total books: " + resultMsg);
		 Thread.sleep(2000);
	}
	
	public void setSortOrder(String sortOrderBy) throws InterruptedException {
		Select select = new Select(driver.findElement(By.id("ddlSort")));
		select.selectByVisibleText(sortOrderBy);
		//System.out.println("sorted");
		Thread.sleep(2000);
	}

	
	public void displayBookDetails() {

		for (int i = 1; i <= 2; i++) {

			System.out.println(driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div[" + i + "]/div[3]/div[1]/a"))
							.getText() + " - ");
////*[@id="listSearchResult"]/div[1]/div[3]/div[1]/a and it inspect from 1 testng bookname
			List<WebElement> total = driver.findElements(By.xpath("//*[@id=\"listSearchResult\"]/div[" + i + "]/div[3]/div[4]/div[1]/div"));

			
			
			// displaying book 
			if (total.size() == 1)
				System.out.println(driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div["+ i +"]/div[3]/div[4]/div[1]/div"))
								.getText());
			else
				System.out.println(driver.findElement(By.xpath("//*[@id=\"listSearchResult\"]/div["+ i +"]/div[3]/div[4]/div[1]/div[2]"))
								.getText());
			
		}
		
	}
	public void closeDriver() {
		
		driver.close();
	}
}
				


public class DataDrivenFramework {
	
	public static void main(String[] args) throws InterruptedException {
		
		DDFDemo d1 = new DDFDemo();
		d1.setup();
		
		for (int rowNo = 1; rowNo<=2; rowNo++) {
			String[] data = ReadExcel.readExcelData(rowNo);
			
		d1.searchBook(data[0]);
		d1.displayTotalNoOfBooks();
		d1.setSortOrder(data[1]);
		d1.displayBookDetails();
	}
	d1.closeDriver();
	}
	 

		
	}
	


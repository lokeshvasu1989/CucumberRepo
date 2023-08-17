package CucumbersT.CucumberTutorials;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	static WebDriver driver;
	  public static void main(String[] args) throws InterruptedException {
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		    String prodKey= "tom";
		 WebElement cartSearch= driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']"));
		 cartSearch.sendKeys(prodKey);
		 Thread.sleep(10000);
		String product= driver.findElement(By.xpath("//h4[contains(text(),Tomato)]")).getText();
	String prddd=	product.split("-")[0].trim();
		System.out.println(prddd);
		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		Thread.sleep(15000);
		Set<String> pg=driver.getWindowHandles();
	Iterator<String>nx=	pg.iterator();
	String one=nx.next();
	String  two=nx.next();
	driver.switchTo().window(two);
		driver.findElement(By.cssSelector("input[id='search-field']")).sendKeys(prodKey);
		Thread.sleep(10000);
	String pdd=	driver.findElement(By.xpath("//td[text()='Tomato']")).getText();
	System.out.println(pdd);
	//if(product.equals(pdd))
	Assert.assertEquals(prddd, pdd);
	  }
  }


package StepDefenitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import Utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPage {
	static WebDriver driver;
	public String landProd;
	public String offerProd;
	TestContext testContext;
	public LandingPage(TestContext testContext)
	{
		this.testContext= testContext;
	} 
	@Given("Logging into Greenkart Page")
	public void logging_into_greenkart_page() {
    WebDriverManager.chromedriver().setup();
    testContext.driver = new ChromeDriver();
    testContext.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("Enters {string} and checks if product is present")
	public void enters_and_checks_if_product_is_present(String string) throws InterruptedException {
    WebElement cartSearch= testContext.driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']"));
	cartSearch.sendKeys(string);
	Thread.sleep(10000);
	String product= testContext.driver.findElement(By.xpath("//h4[contains(text(),Tomato)]")).getText();
	testContext.landProd=	product.split("-")[0].trim();
	System.out.println(testContext.landProd);
	}
}

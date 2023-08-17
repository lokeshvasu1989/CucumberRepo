package StepDefenitions;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utils.TestContext;
import io.cucumber.java.en.Then;

public class OfferPage {
	static WebDriver driver;
	//public String landProd;
	public String offerProd;
	TestContext testContext;
	public OfferPage(TestContext testContext)
	{
		this.testContext= testContext;
	} 
	@Then("Enters {string} in Top Deals and checks both products from green cart page and top deal page are same")
	public void enters_in_top_deals_and_checks_both_products_from_green_cart_page_and_top_deal_page_are_same(String string) throws InterruptedException {
	testContext.driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
	switchTo();
	Thread.sleep(15000);
	testContext.driver.findElement(By.cssSelector("input[id='search-field']")).sendKeys(string);
	Thread.sleep(10000);
	offerProd=	testContext.driver.findElement(By.xpath("//td[text()='Tomato']")).getText();
	System.out.println(offerProd);
	Assert.assertEquals(testContext.landProd, offerProd);
	}
	public void switchTo()
	{
		Set<String> pg=testContext.driver.getWindowHandles();
		Iterator<String>nx=	pg.iterator();
		String one=nx.next();
		String  two=nx.next();
		testContext.driver.switchTo().window(two);
	}

}

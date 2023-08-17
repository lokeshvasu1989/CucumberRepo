package CucumbersT.CucumberTutorials;
import javax.imageio.ImageIO;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrSht {
	@Test
	public void scrsht() throws AWTException, IOException
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		Robot robot = new Robot();
		Dimension scrnSize= Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(scrnSize);
		BufferedImage scrce= robot.createScreenCapture(rect);
		File dest = new File("dle.png");
		ImageIO.write(scrce, "png", dest);
		
//		TakesScreenshot sh = (TakesScreenshot)driver;
//		File src= sh.getScreenshotAs(OutputType.FILE);
//		File dest = new File("dez.png");
//		FileUtils.copyFile(src, dest);
	}

}

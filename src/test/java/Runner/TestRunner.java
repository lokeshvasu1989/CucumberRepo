package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Featur",glue= "StepDefenitions")
public class TestRunner extends AbstractTestNGCucumberTests  {



}

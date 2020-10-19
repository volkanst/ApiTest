package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import static utils.PropertiesReader.getPropertiesReader;

@CucumberOptions(
        plugin = {"pretty", "json:targer/CucumberRunner/cucumber.json", "html:targer/CucumberRunner/cucumber.html"},
        features = "src/test/java/features",
        glue = "steps"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public static void setUp() {
        if (driver == null) {
            getPropertiesReader();
        }
    }

    @AfterClass(alwaysRun = true)
    public void quit() throws IOException, InterruptedException {
        if (driver != null) {
            driver.quit();
        }
    }
}

package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.SeleniumDriver;

public class TestBase {

    @Before
    public static void setUp() {
        SeleniumDriver.setUpDriver();

    }

    @After
    public static void tearDown() {
        SeleniumDriver.tearDown();
    }
}

package steps;

import io.cucumber.java.en.When;
import screens.BasePageScreen;

public class BasePageStep {

    private BasePageScreen basePageScreen = new BasePageScreen();

    @When("I am on the BasePage {string}")
    public void iAmOnTheBasePage(String string) {
        basePageScreen.iAmOnTheBasePage(string);
    }
}

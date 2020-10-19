package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import screens.PopularBetsPageScreen;

import java.io.IOException;

public class PopularBetsPageStep {

    PopularBetsPageScreen popularBetsPageScreen = new PopularBetsPageScreen();

    @And("Click : PopularBetsPage : FootballButton")
    public void clickPopularBetsPageFootballButton() {
        popularBetsPageScreen.clickPopularBetsPageFootballButton();
    }

    @Then("Verify : Api")
    public void verifyApi() throws IOException, ParseException {
        popularBetsPageScreen.verifyApi();
    }

    @Then("Verify : PopularBetsPage : url {string}")
    public void verifyPopularBetsPageUrl(String url) {
        popularBetsPageScreen.verifyPopularBetsPageUrl(url);

    }
}

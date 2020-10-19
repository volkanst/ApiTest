package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import screens.HomePageScreen;

public class HomePageStep {

    HomePageScreen homePageScreen = new HomePageScreen();

    @And("Click : HomePage : PopularBetsButton")
    public void clickHomePagePopularBetsButton() {
        homePageScreen.clickHomePagePopularBetsButton();
    }


    @And("Click : HomePage : MyAccountButton")
    public void clickHomePageMyAccountButton() {
        homePageScreen.clickHomePageMyAccountButton();
    }

    @And("Click : HomePage : LogoutButton")
    public void clickHomePageLogoutButton() {
        homePageScreen.clickHomePageLogoutButton();
    }


}

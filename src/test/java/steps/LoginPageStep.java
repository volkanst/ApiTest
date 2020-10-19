package steps;

import io.cucumber.java.en.And;
import screens.LoginPageScreen;


public class LoginPageStep {

    LoginPageScreen loginPageScreen = new LoginPageScreen();

    @And("I set LoginPage : username {string} and password {string}")
    public void iSetLoginPageUsernameAndPassword(String username, String password) {
        loginPageScreen.iSetLoginPageUsernameAndPassword(username, password);
    }


    @And("Click : LoginPage : LoginButton")
    public void clickLoginPageLoginButton() {
        loginPageScreen.clickLoginPageLoginButton();
    }


}

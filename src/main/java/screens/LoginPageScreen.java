package screens;

import org.junit.Assert;
import org.openqa.selenium.By;
import utils.PropertiesReader;

public class LoginPageScreen extends BaseScreen {

    PropertiesReader propertiesReader = new PropertiesReader();
    private static final By USERNAME_ID = By.xpath("//input[@id='txtUsername']");
    private static final By PASSWORD_ID = By.xpath("//input[@id='realpass']");
    private static final By LOGIN_BTN_ID = By.cssSelector(".login-form [name]");


    public void iSetLoginPageUsernameAndPassword(String username, String password) {
        fillUsername(username);
        fillPassword(password);
    }

    private void fillPassword(String password) {
        password = propertiesReader.getPassword();
        Assert.assertTrue("Şifre Alanı Bulunamadı.",isElementPresent(PASSWORD_ID));
        sendText(PASSWORD_ID, password);
    }

    private void fillUsername(String username) {
        username = propertiesReader.getUsername();
        Assert.assertTrue("Kullanıcı Adı Alanı Bulunamadı.",isElementPresent(USERNAME_ID));
        sendText(USERNAME_ID, username);
    }

    public void clickLoginPageLoginButton() {
        Assert.assertTrue("Giriş Butonu Bulunamadı.", isElementPresent(LOGIN_BTN_ID));
        waitAndClick(LOGIN_BTN_ID);
    }
}

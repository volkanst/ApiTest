package screens;

import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePageScreen extends BaseScreen {

    private static final By POPULER_BETS_BTN_ID = By.linkText("Popüler Bahisler");
    private static final By MY_ACCOUNT_BTN_ID = By.xpath("//div[@id='member-info']//a[contains(text(),'Hesabım')]");
    private static final By LOGOUT_BTN_ID = By.xpath("//div[@id='member-info']//a[contains(text(),'Çıkış')]");


    public void clickHomePagePopularBetsButton() {
        Assert.assertTrue("Popüler Bahisler Butonu Bulunamadı.",isElementPresent(POPULER_BETS_BTN_ID));
        waitAndClick(POPULER_BETS_BTN_ID);
    }

    public void clickHomePageMyAccountButton() {
        Assert.assertTrue("Hesabım Butonu Bulunamadı.",isElementPresent(MY_ACCOUNT_BTN_ID));
        waitAndClick(MY_ACCOUNT_BTN_ID);
    }

    public void clickHomePageLogoutButton() {
        Assert.assertTrue("Çıkış Butonu Bulunamadı.",isElementPresent(LOGOUT_BTN_ID));
        waitAndClick(LOGOUT_BTN_ID);
    }
}

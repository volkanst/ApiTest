package screens;

import utils.PropertiesReader;
import utils.SeleniumDriver;

public class BasePageScreen extends BaseScreen {

    PropertiesReader propertiesReader = new PropertiesReader();


    public void iAmOnTheBasePage(String url) {
        url = propertiesReader.getBase_url();
        SeleniumDriver.openPage(url);
    }
}

package screens;


import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PopularBetsPageScreen extends BaseScreen {

    private static final By POP_BETS_FOOTBALL_BTN_ID = By.linkText("Futbol");
    private static final By SCREEN_MAP_ID = By.xpath("//div[@class='eventRow']");

    public void verifyPopularBetsPageUrl(String url) {
     //   Assert.assertEquals(url, getCurrentUrl(), "Popüler Bahisler Sayfa Linki Hatalı");
        Assert.assertEquals("Popüler Bahisler Sayfa Linki Hatalı",url,getCurrentUrl());
    }

    public void clickPopularBetsPageFootballButton() {
        Assert.assertTrue("Popüler Bahisler Ekranında Futbol Butonu Bulunamadı.", isElementPresent(POP_BETS_FOOTBALL_BTN_ID));
        waitAndClick(POP_BETS_FOOTBALL_BTN_ID);
    }

    public void verifyApi() throws IOException, org.json.simple.parser.ParseException {
        Map<String, String> apiMap = sendPopBetsApi();
        Map<String, String> screenMap = getPopBetScreen();
        Assert.assertEquals(apiMap, screenMap);
    }

    private Map<String, String> getPopBetScreen() {
        List<WebElement> eventRow = waitAndFindListElements(SCREEN_MAP_ID);
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < eventRow.size(); i++) {
            By eventRow_code = By.xpath("//div[@class='eventRow'][" + (i + 1) + "]/div[@class='code']/a/span");
            By eventRow_score = By.xpath("//div[@class='eventRow'][" + (i + 1) + "]/div[@class='score']/strong");
            Assert.assertTrue((i + 1) + ". Satırdaki Etkinliğe Ait Kod Bulunamadı.", isElementPresent(eventRow_code));
            Assert.assertTrue((i + 1) + ". Satırdaki Etkinliğe Ait Oynanam Sayısı Bulunamadı.", isElementPresent(eventRow_score));
            scroll(eventRow_code);
            String code = getText(eventRow_code);
            String score = getText(eventRow_score);
            System.out.println("KOD : " + code + " --> OYNANMA SAYISI : " + score);
            map.put(code, score);
        }
        return map;
    }

    private Map<String, String> sendPopBetsApi() throws IOException, ParseException, org.json.simple.parser.ParseException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://www.nesine.com/Iddaa/GetPopularBets?eventType=1&date=");
        CloseableHttpResponse response = client.execute(httpPost);
        String api = EntityUtils.toString(response.getEntity());
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(api);
        JSONArray jsonArray = (JSONArray) jsonObject.get("PopularBetList");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject array = (JSONObject) jsonArray.get(i);
            String market_no = array.get("MarketNo").toString();
            String played_count = array.get("PlayedCount").toString();
            map.put(market_no, played_count);
        }
        return map;
    }
}

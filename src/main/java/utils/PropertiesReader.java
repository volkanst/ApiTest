package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static PropertiesReader propertiesReader;
    private Properties config = new Properties();
    private String base_url;
    private String username;
    private String password;

    public static PropertiesReader getPropertiesReader() {
        propertiesReader = new PropertiesReader();
        return propertiesReader;
    }

    public PropertiesReader() {
        InputStream is = ClassLoader.getSystemResourceAsStream("config.properties");
        try {
            config.load(is);
            this.username = config.getProperty("username");
            this.password = config.getProperty("password");
            this.base_url = config.getProperty("siteUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

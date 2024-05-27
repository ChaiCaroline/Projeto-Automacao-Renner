package teste.automatizado;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties;

    public ConfigLoader() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Não existe o arquivo.");
        }
    }

    public String getUsername() {
        String username = properties.getProperty("username");
        return username;
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        return password;
    }

    public String getUrl() {
        String urlRenner = properties.getProperty("urlRenner");
        return urlRenner;
    }
}
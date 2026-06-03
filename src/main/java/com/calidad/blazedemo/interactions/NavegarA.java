package com.calidad.blazedemo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Open;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class NavegarA implements Interaction {

    private final String url;

    private NavegarA(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static Interaction a(String relativePath) {
        return new NavegarA(resolveUrl(relativePath));
    }

    public static Interaction laUrl(String url) {
        return new NavegarA(url);
    }

    private static String resolveUrl(String relativePath) {
        String baseUrl = baseUrl();
        if (relativePath == null || relativePath.isBlank()) {
            return baseUrl;
        }
        if (relativePath.startsWith("http://") || relativePath.startsWith("https://")) {
            return relativePath;
        }
        if (baseUrl.endsWith("/") && relativePath.startsWith("/")) {
            relativePath = relativePath.substring(1);
        } else if (!baseUrl.endsWith("/") && !relativePath.startsWith("/")) {
            baseUrl = baseUrl + "/";
        }
        return baseUrl + relativePath;
    }

    private static String baseUrl() {
        String configuredUrl = System.getProperty("webdriver.base.url");
        if (configuredUrl != null && !configuredUrl.isBlank()) {
            return configuredUrl;
        }
        String envUrl = System.getenv("WEBDRIVER_BASE_URL");
        if (envUrl != null && !envUrl.isBlank()) {
            return envUrl;
        }

        Path propertiesPath = Paths.get(System.getProperty("user.dir"), "serenity.properties");
        if (Files.exists(propertiesPath)) {
            Properties properties = new Properties();
            try (InputStream inputStream = Files.newInputStream(propertiesPath)) {
                properties.load(inputStream);
                configuredUrl = properties.getProperty("webdriver.base.url");
                if (configuredUrl != null && !configuredUrl.isBlank()) {
                    return configuredUrl;
                }
            } catch (IOException ignored) {
            }
        }
        return "https://blazedemo.com/";
    }
}

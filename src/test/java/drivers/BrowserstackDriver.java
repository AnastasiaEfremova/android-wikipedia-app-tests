package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import helpers.BrowserstackHelper;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    private static final BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        // Проверка обязательных параметров
        if (config.userName() == null || config.accessKey() == null) {
            throw new IllegalArgumentException("Browserstack credentials required: -DuserName=xxx -DaccessKey=xxx");
        }

        DesiredCapabilities caps = new DesiredCapabilities();
        String appUrl = BrowserstackHelper.uploadApp();

        caps.setCapability("app", appUrl);
        caps.setCapability("appium:deviceName", config.device());
        caps.setCapability("appium:platformVersion", config.osVersion());
        caps.setCapability("appium:projectName", "Wikipedia tests");
        caps.setCapability("appium:buildName", "browserstack-build");
        caps.setCapability("appium:name", "android_tests_wikipedia");

        try {
            return new AndroidDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub",
                    config.userName(), config.accessKey())), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
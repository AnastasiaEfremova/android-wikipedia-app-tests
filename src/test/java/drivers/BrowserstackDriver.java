package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MainConfig;
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

    static MainConfig mainConfig = ConfigFactory.create(MainConfig.class, System.getProperties());
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        DesiredCapabilities caps = new DesiredCapabilities();

        String appUrl = BrowserstackHelper.uploadApp();

        caps.setCapability("app", appUrl);
        caps.setCapability("appium:deviceName", mainConfig.device());
        caps.setCapability("appium:platformVersion", mainConfig.osVersion());
        caps.setCapability("appium:projectName", "Wikipedia tests");
        caps.setCapability("appium:buildName", "browserstack-build");
        caps.setCapability("appium:name", "android_tests_wikipedia");

        try {
            return new AndroidDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub",
                    mainConfig.userName(), mainConfig.accessKey())), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}

package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "system:properties",
    "system:env",
    "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {

    // Обязательные через командную строку
    @Key("userName")
    String userName();

    @Key("accessKey")
    String accessKey();

    // Из browserstack.properties
    @Key("device")
    String device();

    @Key("osVersion")
    String osVersion();

    @Key("appName")
    String appName();

    @Key("appUrl")
    String appUrl();
}
package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "system:properties",
    "system:env", 
    "classpath:local.properties"
})
public interface LocalConfig extends Config {

    @Key("remote.url")
    String remoteUrl();

    @Key("app.package")
    String appPackage();

    @Key("app.activity")
    String appActivity();

    @Key("device.name")
    String deviceName();

    @Key("platform.version")
    String platformVersion();
}
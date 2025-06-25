package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(Config.LoadType.MERGE)
@Sources({
    "system:properties",
    "classpath:api.properties"})
public interface Configuration extends Config {

    @Key("api.base.url")
    String baseUrl();

    @Key("api.key")
    String apiKey();
}

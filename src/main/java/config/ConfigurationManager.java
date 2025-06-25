package config;

import org.aeonbits.owner.ConfigCache;

public final class ConfigurationManager {

    private ConfigurationManager() { /* Singleton */ }

    public static Configuration getConfig() {
        return ConfigCache.getOrCreate(Configuration.class);
    }
}

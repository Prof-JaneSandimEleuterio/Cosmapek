package unicamp.buscame.configuration.core;

import unicamp.buscame.configuration.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class ConfigurationMFactory {
    private static ConfigurationM configurationM = null;

    public static synchronized ConfigurationM createInstance(IManager manager) {
        if (configurationM == null)
            configurationM = new ConfigurationM(manager);
        return configurationM;
    }
}

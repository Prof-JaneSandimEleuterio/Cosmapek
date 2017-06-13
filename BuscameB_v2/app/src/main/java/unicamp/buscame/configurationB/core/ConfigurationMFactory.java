package unicamp.buscame.configurationB.core;

import unicamp.buscame.configurationB.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class ConfigurationMFactory {
    private static unicamp.buscame.configurationB.core.ConfigurationM configurationM = null;

    public static synchronized unicamp.buscame.configurationB.core.ConfigurationM createInstance(IManager manager) {
        if (configurationM == null)
            configurationM = new unicamp.buscame.configurationB.core.ConfigurationM(manager);
        return configurationM;
    }
}

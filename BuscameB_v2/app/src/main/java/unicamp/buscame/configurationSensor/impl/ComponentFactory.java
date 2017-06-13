package unicamp.buscame.configurationSensor.impl;

import unicamp.buscame.configurationSensor.prov.IManager;

/**
 * Created by ArchyWin on 5/23/2015.
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new unicamp.buscame.configurationSensor.impl.Manager();
        return manager;
    }
}

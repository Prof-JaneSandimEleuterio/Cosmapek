package unicamp.buscame.localizationSensor.impl;

import unicamp.buscame.localizationSensor.prov.IManager;

/**
 * Created by ArchyWin on 5/23/2015.
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new unicamp.buscame.localizationSensor.impl.Manager();
        return manager;
    }
}

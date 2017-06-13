package unicamp.buscame.productBSensor.impl;

import unicamp.buscame.productBSensor.prov.IManager;

/**
 * Created by ArchyWin on 5/23/2015.
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new unicamp.buscame.productBSensor.impl.Manager();
        return manager;
    }
}

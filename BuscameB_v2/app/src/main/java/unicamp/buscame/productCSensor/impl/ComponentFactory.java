package unicamp.buscame.productCSensor.impl;

import unicamp.buscame.productCSensor.prov.IManager;

/**
 * Created by ArchyWin on 5/23/2015.
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new unicamp.buscame.productCSensor.impl.Manager();
        return manager;
    }
}

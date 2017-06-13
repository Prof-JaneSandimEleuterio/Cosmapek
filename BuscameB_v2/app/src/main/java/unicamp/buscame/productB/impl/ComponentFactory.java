package unicamp.buscame.productB.impl;

import unicamp.buscame.productB.impl.*;
import unicamp.buscame.productB.prov.IManager;

/**
 * Created by ArchyWin on 5/23/2015.
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new unicamp.buscame.productB.impl.Manager();
        return manager;
    }
}

package unicamp.buscame.configurationB.impl;

import unicamp.buscame.configurationB.impl.*;
import unicamp.buscame.configurationB.prov.IManager;

/**
 * Created by ArchyWin on 5/23/2015.
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new unicamp.buscame.configurationB.impl.Manager();
        return manager;
    }
}

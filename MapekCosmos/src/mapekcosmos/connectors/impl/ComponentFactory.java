package mapekcosmos.connectors.impl;

import mapekcosmos.connectors.prov.IManager;

/**
 * Created by ArchyWin on 5/23/2015.
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new mapekcosmos.connectors.impl.Manager();
        return manager;
    }
}

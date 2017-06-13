package mapekcosmos.executer.impl;

import mapekcosmos.executer.prov.IManager;

/**
 * @author Junior Cupe Casquina
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new mapekcosmos.executer.impl.Manager();
        return manager;
    }
}

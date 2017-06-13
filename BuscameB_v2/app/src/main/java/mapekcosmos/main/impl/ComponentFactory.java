package mapekcosmos.main.impl;

import mapekcosmos.main.prov.IManager;

/**
 * @author Junior Cupe Casquina
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new Manager();
        return manager;
    }
}

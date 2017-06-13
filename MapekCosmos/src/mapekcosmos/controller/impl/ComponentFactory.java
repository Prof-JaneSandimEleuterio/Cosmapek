package mapekcosmos.controller.impl;

import mapekcosmos.controller.prov.IManager;

/**
 * @author Junior Cupe Casquina
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new mapekcosmos.controller.impl.Manager();
        return manager;
    }
}

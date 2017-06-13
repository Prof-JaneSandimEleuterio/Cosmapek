package mapekcosmos.reader.impl;

import mapekcosmos.reader.prov.IManager;

/**
 * @author Junior Cupe Casquina
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new mapekcosmos.reader.impl.Manager();
        return manager;
    }
}

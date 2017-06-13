package mapekcosmos.planner.impl;

import mapekcosmos.planner.prov.IManager;

/**
 * Created by ArchyWin on 5/23/2015.
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new mapekcosmos.planner.impl.Manager();
        return manager;
    }
}

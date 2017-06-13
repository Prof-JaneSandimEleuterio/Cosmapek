package mapekcosmos.conn_executer_controller.impl;


import mapekcosmos.conn_executer_controller.prov.IManager;

/**
 * Created by ArchyWin on 5/25/2015.
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new mapekcosmos.conn_executer_controller.impl.Manager();
        return manager;
    }
}

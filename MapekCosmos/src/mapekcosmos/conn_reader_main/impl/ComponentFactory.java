package mapekcosmos.conn_reader_main.impl;


import mapekcosmos.conn_reader_main.prov.IManager;

/**
 * Created by ArchyWin on 5/25/2015.
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new mapekcosmos.conn_reader_main.impl.Manager();
        return manager;
    }
}

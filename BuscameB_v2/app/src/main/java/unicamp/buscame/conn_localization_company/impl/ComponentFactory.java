package unicamp.buscame.conn_localization_company.impl;


import unicamp.buscame.conn_localization_company.prov.IManager;

/**
 * Created by ArchyWin on 5/25/2015.
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new unicamp.buscame.conn_localization_company.impl.Manager();
        return manager;
    }
}

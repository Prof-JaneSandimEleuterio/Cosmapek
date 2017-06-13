package unicamp.buscame.conn_productC_productCSensor.impl;


import unicamp.buscame.conn_productC_productCSensor.prov.IManager;

/**
 * Created by ArchyWin on 5/25/2015.
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new unicamp.buscame.conn_productC_productCSensor.impl.Manager();
        return manager;
    }
}

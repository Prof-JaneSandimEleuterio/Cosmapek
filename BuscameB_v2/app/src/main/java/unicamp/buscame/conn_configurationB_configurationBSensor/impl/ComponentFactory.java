package unicamp.buscame.conn_configurationB_configurationBSensor.impl;


import unicamp.buscame.conn_configurationB_configurationBSensor.prov.IManager;

/**
 * Created by ArchyWin on 5/25/2015.
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new unicamp.buscame.conn_configurationB_configurationBSensor.impl.Manager();
        return manager;
    }
}

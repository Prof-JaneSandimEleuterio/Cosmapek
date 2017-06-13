package unicamp.buscame.conn_ui_controller.impl;


import unicamp.buscame.conn_ui_controller.prov.IManager;

/**
 * Created by ArchyWin on 5/25/2015.
 */
public class ComponentFactory {
    private static IManager manager = null;

    private ComponentFactory() {
    }

    public static synchronized IManager createInstance() {
        if (manager == null)
            manager = new unicamp.buscame.conn_ui_controller.impl.Manager();
        return manager;
    }
}

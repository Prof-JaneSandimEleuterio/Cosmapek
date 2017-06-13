package mapekcosmos.components.core;

import mapekcosmos.components.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class ComponentMFactory {
    private static ComponentM componentM = null;

    public static synchronized ComponentM createInstance(IManager manager) {
        if (componentM == null)
            componentM = new ComponentM(manager);
        return componentM;
    }
}

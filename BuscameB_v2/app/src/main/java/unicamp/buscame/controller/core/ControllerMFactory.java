package unicamp.buscame.controller.core;

import unicamp.buscame.controller.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class ControllerMFactory {
    private static ControllerM controllerM = null;

    public static synchronized ControllerM createInstance(IManager manager) {
        if (controllerM == null)
            controllerM = new ControllerM(manager);
        return controllerM;
    }
}

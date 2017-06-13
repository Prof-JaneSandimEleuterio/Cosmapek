package unicamp.buscame.controller.impl;

import unicamp.buscame.controller.core.ControllerM;
import unicamp.buscame.controller.core.ControllerMFactory;

import unicamp.buscame.controller.prov.IControllerManager;
import unicamp.buscame.controller.prov.IManager;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class IControllerManagerFacade implements IInterfaceTags, IControllerManager {


    private IManager manager = null;
    private ControllerM controllerM;

    IControllerManagerFacade(IManager manager) {
        this.manager = manager;
        this.controllerM = ControllerMFactory.createInstance(this.manager);
    }

    @Override
    public synchronized boolean createFreeMainUI() {
        return controllerM.createFreeMainUI();
    }
}

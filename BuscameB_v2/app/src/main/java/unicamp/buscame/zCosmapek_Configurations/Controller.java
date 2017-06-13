package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Controller implements IExecution,IInterfaceTags {
    private unicamp.buscame.controller.prov.IManager controller;
    private unicamp.buscame.controller.prov.IControllerManager controllerIContr;
    @Override
    public void execute() {
        controller = unicamp.buscame.controller.impl.ComponentFactory.createInstance();
        controllerIContr =
                (unicamp.buscame.controller.prov.IControllerManager) controller.getProvidedInterface(IControllerManagerTag);
//        controllerIContr.createFreeMainUI();
    }
}

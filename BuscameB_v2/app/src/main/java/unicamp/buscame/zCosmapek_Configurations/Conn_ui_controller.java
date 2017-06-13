package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_ui_controller implements IExecution,IInterfaceTags {
    private unicamp.buscame.ui.prov.IManager ui;
    private unicamp.buscame.ui.prov.IUiManager uiIUi;

    private unicamp.buscame.conn_ui_controller.prov.IManager ui_controller;
    private unicamp.buscame.controller.prov.IManager controller;
    @Override
    public synchronized void execute() {
        ui = unicamp.buscame.ui.impl.ComponentFactory.createInstance();
        uiIUi =
                (unicamp.buscame.ui.prov.IUiManager) ui.getProvidedInterface(IUiManagerTag);

        ui_controller=unicamp.buscame.conn_ui_controller.impl.ComponentFactory.createInstance();
        ui_controller.setRequiredInterface(IUiManagerTag, uiIUi);

        controller = unicamp.buscame.controller.impl.ComponentFactory.createInstance();
        controller.setRequiredInterface(IUiManagerTag,
                ui_controller.getProvidedInterface(IUiManagerTag));
    }
}

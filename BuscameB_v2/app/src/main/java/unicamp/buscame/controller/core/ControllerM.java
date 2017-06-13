package unicamp.buscame.controller.core;

import unicamp.buscame.controller.prov.IManager;

import unicamp.buscame.controller.req.IClientManager;
import unicamp.buscame.controller.req.ICompanyManager;
import unicamp.buscame.controller.req.IUiManager;

/**
 * @author Junior Cupe Casquina
 */
public class ControllerM {
    private IManager manager;

    private IClientManager clientManager;
    private ICompanyManager companyManager;
    private IUiManager uiManager;


    public ControllerM(IManager manager) {
        this.manager = manager;
    }

    private void getManagers() {
        this.clientManager =
            (IClientManager) manager.getRequiredInterface("IClientManager");
        this.companyManager = (ICompanyManager) manager.getRequiredInterface("ICompanyManager");
        this.uiManager =
                (IUiManager) manager.getRequiredInterface("IUiManager");
    }

    public boolean createFreeMainUI() {
        getManagers();
        return uiManager.createFreeMainUI();
    }
}

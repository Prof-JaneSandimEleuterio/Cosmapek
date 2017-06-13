package unicamp.buscame.ui.impl;

import unicamp.buscame.ui.core.UiM;
import unicamp.buscame.ui.core.UiMFactory;
import unicamp.buscame.ui.prov.IUiManager;
import unicamp.buscame.ui.prov.IManager;

import java.util.LinkedList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class IUiManagerFacade implements IInterfaceTags, IUiManager {
    private IManager manager = null;
    private UiM uiM;

    IUiManagerFacade(IManager manager) {
        this.manager = manager;
        this.uiM = UiMFactory.createInstance(this.manager);
    }

    @Override
    public synchronized boolean createFreeMainUI() {
        return uiM.createFreeMainUI();
    }

}

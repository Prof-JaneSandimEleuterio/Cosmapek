package unicamp.buscame.conn_ui_controller.impl;

import unicamp.buscame.conn_ui_controller.prov.IManager;

class Adapter
    implements unicamp.buscame.controller.req.IUiManager, unicamp.buscame.conn_ui_controller.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }
/*
    @Override public void start() {
        mapekcosmos.analyzer.prov.IAnalysisManager compAnalyzer =
            (mapekcosmos.analyzer.prov.IAnalysisManager) this.manager.getRequiredInterface(IAnalysisManagerTag);
        compAnalyzer.start();
    }*/

    @Override
    public synchronized boolean createFreeMainUI() {
        unicamp.buscame.ui.prov.IUiManager compUi =
                (unicamp.buscame.ui.prov.IUiManager) this.manager.getRequiredInterface(IUiManagerTag);
        return compUi.createFreeMainUI();
    }
}

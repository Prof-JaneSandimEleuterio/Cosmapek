package mapekcosmos.conn_analyzer_controller.impl;

import mapekcosmos.conn_analyzer_controller.prov.IManager;

class Adapter
    implements mapekcosmos.controller.req.IAnalysisManager, mapekcosmos.conn_analyzer_controller.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void start() {
        mapekcosmos.analyzer.prov.IAnalysisManager compAnalyzer =
            (mapekcosmos.analyzer.prov.IAnalysisManager) this.manager.getRequiredInterface(IAnalysisManagerTag);
        compAnalyzer.start();
    }
}

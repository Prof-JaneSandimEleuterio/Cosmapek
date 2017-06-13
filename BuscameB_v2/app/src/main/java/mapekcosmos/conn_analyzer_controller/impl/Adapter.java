package mapekcosmos.conn_analyzer_controller.impl;

import mapekcosmos.conn_analyzer_controller.prov.IManager;

class Adapter
    implements mapekcosmos.controller.req.IAnalysisManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void start() {
        mapekcosmos.analyzer.prov.IAnalysisManager compAnalyzer =
            (mapekcosmos.analyzer.prov.IAnalysisManager) this.manager.getRequiredInterface(IAnalysisManagerTag);
        compAnalyzer.start();
    }

    @Override
    public boolean hasActivatedRuntimeSensors() {
        mapekcosmos.analyzer.prov.IAnalysisManager compAnalyzer =
                (mapekcosmos.analyzer.prov.IAnalysisManager) this.manager.getRequiredInterface(IAnalysisManagerTag);
        return compAnalyzer.hasActivatedRuntimeSensors();
    }
/*
    @Override
    public boolean hasActivatedSensors() {
        mapekcosmos.analyzer.prov.IAnalysisManager compAnalyzer =
                (mapekcosmos.analyzer.prov.IAnalysisManager) this.manager.getRequiredInterface(IAnalysisManagerTag);
        return compAnalyzer.hasActivatedSensors();
    }*/
}

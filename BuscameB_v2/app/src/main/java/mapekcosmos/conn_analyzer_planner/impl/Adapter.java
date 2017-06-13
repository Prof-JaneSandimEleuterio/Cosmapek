package mapekcosmos.conn_analyzer_planner.impl;

import mapekcosmos.conn_analyzer_planner.prov.IManager;

import java.util.LinkedList;

class Adapter implements mapekcosmos.planner.req.IAnalysisManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized LinkedList<String> getFailedFeatures() {
        mapekcosmos.analyzer.prov.IAnalysisManager compAnalyzer =
            (mapekcosmos.analyzer.prov.IAnalysisManager) this.manager.getRequiredInterface(IAnalysisManagerTag);

        return compAnalyzer.getFailedFeatures();
    }
}

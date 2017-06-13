package mapekcosmos.analyzer.impl;

import mapekcosmos.analyzer.core.Analyzer;
import mapekcosmos.analyzer.core.AnalyzerFactory;
import mapekcosmos.analyzer.prov.IAnalysisManager;
import mapekcosmos.analyzer.prov.IManager;

import java.util.LinkedList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class IAnalysisManagerFacade implements IAnalysisManager {
    private IManager manager;
    private Analyzer analyzer;

    IAnalysisManagerFacade(IManager manager) {
        this.manager = manager;
        this.analyzer = AnalyzerFactory.createInstance(this.manager);
    }

    @Override public synchronized void start() {
        analyzer.start();
    }

    @Override
    public boolean hasActivatedSensors() {
        return analyzer.hasActivatedSensors();
    }

    @Override
    public boolean hasActivatedRuntimeSensors() {
        return analyzer.hasActivatedRuntimeSensors();
    }

    @Override public synchronized LinkedList<String> getFailedFeatures() {
        return analyzer.getFailedFeatures();
    }

}

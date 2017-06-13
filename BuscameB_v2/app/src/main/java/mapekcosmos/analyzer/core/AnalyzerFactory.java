package mapekcosmos.analyzer.core;

import mapekcosmos.analyzer.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class AnalyzerFactory {
    private static Analyzer componentM = null;

    public static synchronized Analyzer createInstance(IManager manager) {
        if (componentM == null)
            componentM = new Analyzer(manager);
        return componentM;
    }
}

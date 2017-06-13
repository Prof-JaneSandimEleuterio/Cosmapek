package mapekcosmos.analyzer.prov;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public interface IAnalysisManager {

    void start();

    LinkedList<String> getFailedFeatures();
}

package mapekcosmos.analyzer.prov;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public interface IAnalysisManager {

    void start();

    boolean hasActivatedSensors();

    boolean hasActivatedRuntimeSensors();

    LinkedList<String> getFailedFeatures();
}

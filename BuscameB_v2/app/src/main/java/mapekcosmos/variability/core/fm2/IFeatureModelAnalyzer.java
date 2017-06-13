package mapekcosmos.variability.core.fm2;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public interface IFeatureModelAnalyzer {
    LinkedList<String> getASolutionWithout(LinkedList<String> failedFeatures);

    int countConcreteFeatures();
}

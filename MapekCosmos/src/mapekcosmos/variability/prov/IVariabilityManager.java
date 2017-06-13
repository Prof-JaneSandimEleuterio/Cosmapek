package mapekcosmos.variability.prov;

import java.util.LinkedList;

public interface IVariabilityManager {
    void setVariabilityPath(String variabilityPath);

    void read();

    LinkedList<String> getASolutionWithout(LinkedList<String> failedFeatures);
}

package mapekcosmos.planner.req;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public interface IVariabilityManager {

    LinkedList<String> getASolutionWithout(LinkedList<String> failedFeatures);
}

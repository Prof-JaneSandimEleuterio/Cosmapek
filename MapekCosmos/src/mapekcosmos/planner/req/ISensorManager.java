package mapekcosmos.planner.req;

import mapekcosmos.interfaces.ISensor;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public interface ISensorManager {

    LinkedList<ISensor> getSensorsWith(String feature);

    boolean hasSensorsWith(String feature);

}

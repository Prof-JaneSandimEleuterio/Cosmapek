package mapekcosmos.sensors.prov;

import mapekcosmos.interfaces.ISensor;
import mapekcosmos.interfaces.ISensors;

import java.util.LinkedList;

public interface ISensorManager {

    void createASensor(String name, String feature, boolean isSensor, int orderT);

    LinkedList<ISensor> getSensorsWith(String feature);

    boolean hasSensorsWith(String feature);

    boolean hasSensorsInRuntime();

    ISensors getSensorsInRuntime();

    void updateRuntimeRegistry(LinkedList<String> sol);

    void clearSensors();
}

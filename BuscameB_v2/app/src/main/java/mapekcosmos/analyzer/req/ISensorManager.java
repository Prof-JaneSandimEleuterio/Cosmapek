package mapekcosmos.analyzer.req;

import mapekcosmos.interfaces.ISensors;

public interface ISensorManager {

    boolean hasSensorsInRuntime();

    ISensors getSensors();

    ISensors getSensorsInRuntime();
}

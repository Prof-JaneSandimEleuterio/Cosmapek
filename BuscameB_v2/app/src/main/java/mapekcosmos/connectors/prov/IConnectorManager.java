package mapekcosmos.connectors.prov;

import mapekcosmos.interfaces.IConnector;
import mapekcosmos.interfaces.IConnectors;

import java.util.LinkedList;

public interface IConnectorManager {

    void createAConnector(String name, String origin, String destination, int orderT);

    LinkedList<IConnector> getConnectorsWith(String feature);

    boolean hasConnectorsWith(String feature);

    boolean hasConnectorsInRuntime();

    IConnectors getConnectorsInRuntime();

    void updateRuntimeRegistry(LinkedList<String> sol);

    void clearConnectors();
}

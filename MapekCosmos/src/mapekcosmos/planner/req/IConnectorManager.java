package mapekcosmos.planner.req;

import mapekcosmos.interfaces.IConnector;

import java.util.LinkedList;

public interface IConnectorManager {

    LinkedList<IConnector> getConnectorsWith(String feature);

    boolean hasConnectorsWith(String feature);

}

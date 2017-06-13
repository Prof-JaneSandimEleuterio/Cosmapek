package mapekcosmos.connectors.impl;

import mapekcosmos.connectors.core.ConnectorM;
import mapekcosmos.connectors.core.ConnectorMFactory;
import mapekcosmos.connectors.prov.IConnectorManager;
import mapekcosmos.connectors.prov.IManager;
import mapekcosmos.interfaces.IConnector;
import mapekcosmos.interfaces.IConnectors;

import java.util.LinkedList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class IConnectorManagerFacade implements IInterfaceTags, IConnectorManager {
    private IManager manager = null;
    private ConnectorM connectorM;

    IConnectorManagerFacade(IManager manager) {
        this.manager = manager;
        this.connectorM = ConnectorMFactory.createInstance(this.manager);
    }

    @Override
    public synchronized void createAConnector(String name, String origin, String destination, int orderT) {
        connectorM.createAConnector(name, origin, destination, orderT);
    }

    @Override public synchronized LinkedList<IConnector> getConnectorsWith(String feature) {
        return connectorM.getConnectorsWith(feature);
    }

    @Override public synchronized boolean hasConnectorsWith(String feature) {
        return connectorM.hasConnectorsWith(feature);
    }

    @Override public synchronized boolean hasConnectorsInRuntime() {
        return connectorM.hasConnectorsInRuntime();
    }

    @Override public synchronized IConnectors getConnectorsInRuntime() {
        return connectorM.getConnectorsInRuntime();
    }

    @Override public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        connectorM.updateRuntimeRegistry(sol);
    }

    @Override public synchronized void clearConnectors() {
        connectorM.clearConnectors();
    }
}

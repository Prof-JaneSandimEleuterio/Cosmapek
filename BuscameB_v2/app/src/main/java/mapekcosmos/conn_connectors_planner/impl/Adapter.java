package mapekcosmos.conn_connectors_planner.impl;

import mapekcosmos.conn_connectors_planner.prov.IManager;
import mapekcosmos.interfaces.IConnector;

import java.util.LinkedList;

class Adapter
    implements mapekcosmos.planner.req.IConnectorManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized LinkedList<IConnector> getConnectorsWith(String feature) {
        mapekcosmos.connectors.prov.IConnectorManager compConnector =
            (mapekcosmos.connectors.prov.IConnectorManager) this.manager
                .getRequiredInterface(IConnectorManagerTag);
        return compConnector.getConnectorsWith(feature);
    }

    @Override public synchronized boolean hasConnectorsWith(String feature) {
        mapekcosmos.connectors.prov.IConnectorManager compConnector =
            (mapekcosmos.connectors.prov.IConnectorManager) this.manager
                .getRequiredInterface(IConnectorManagerTag);
        return compConnector.hasConnectorsWith(feature);
    }
}

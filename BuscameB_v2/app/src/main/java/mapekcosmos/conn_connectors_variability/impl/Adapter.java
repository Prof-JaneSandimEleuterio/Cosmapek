package mapekcosmos.conn_connectors_variability.impl;

import mapekcosmos.conn_connectors_variability.prov.IManager;

import java.util.LinkedList;

class Adapter
    implements mapekcosmos.variability.req.IConnectorManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        mapekcosmos.connectors.prov.IConnectorManager compConnectors =
            (mapekcosmos.connectors.prov.IConnectorManager) this.manager
                .getRequiredInterface(IConnectorManagerTag);
        compConnectors.updateRuntimeRegistry(sol);
    }
}

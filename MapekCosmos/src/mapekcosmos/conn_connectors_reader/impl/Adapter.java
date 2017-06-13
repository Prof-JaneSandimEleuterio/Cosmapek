package mapekcosmos.conn_connectors_reader.impl;

import mapekcosmos.conn_connectors_reader.prov.IManager;

class Adapter implements mapekcosmos.reader.req.IConnectorManager, mapekcosmos.conn_connectors_reader.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override
    public synchronized void createAConnector(String name, String origin, String destination, int orderT) {
        mapekcosmos.connectors.prov.IConnectorManager compConnectors =
            (mapekcosmos.connectors.prov.IConnectorManager) this.manager
                .getRequiredInterface(IConnectorManagerTag);
        compConnectors.createAConnector(name, origin, destination, orderT);
    }

}

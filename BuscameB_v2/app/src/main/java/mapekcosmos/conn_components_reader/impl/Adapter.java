package mapekcosmos.conn_components_reader.impl;

import mapekcosmos.conn_components_reader.prov.IManager;

class Adapter implements mapekcosmos.reader.req.IComponentManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override
    public synchronized void createAComponent(String name, String feature, boolean isSensor, int orderT) {
        mapekcosmos.components.prov.IComponentManager compComponents =
            (mapekcosmos.components.prov.IComponentManager) this.manager
                .getRequiredInterface(IComponentManagerTag);
        compComponents.createAComponent(name, feature, isSensor, orderT);
    }
}

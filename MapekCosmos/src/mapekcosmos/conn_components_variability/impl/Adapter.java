package mapekcosmos.conn_components_variability.impl;

import mapekcosmos.conn_components_variability.prov.IManager;

import java.util.LinkedList;

class Adapter
    implements mapekcosmos.variability.req.IComponentManager, mapekcosmos.conn_components_variability.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        mapekcosmos.components.prov.IComponentManager compComponents =
            (mapekcosmos.components.prov.IComponentManager) this.manager
                .getRequiredInterface(IComponentManagerTag);
        compComponents.updateRuntimeRegistry(sol);//error
    }
}

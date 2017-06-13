package mapekcosmos.conn_components_planner.impl;

import mapekcosmos.conn_components_planner.prov.IManager;
import mapekcosmos.interfaces.IComponent;

import java.util.LinkedList;

class Adapter
    implements mapekcosmos.planner.req.IComponentManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized LinkedList<IComponent> getComponentsWith(String feature) {
        mapekcosmos.components.prov.IComponentManager compComponents =
            (mapekcosmos.components.prov.IComponentManager) this.manager
                .getRequiredInterface(IComponentManagerTag);
        return compComponents.getComponentsWith(feature);
    }

    @Override public synchronized boolean hasComponentsWith(String feature) {
        mapekcosmos.components.prov.IComponentManager compComponents =
            (mapekcosmos.components.prov.IComponentManager) this.manager
                .getRequiredInterface(IComponentManagerTag);
        return compComponents.hasComponentsWith(feature);
    }

}

package mapekcosmos.conn_features_variability.impl;

import mapekcosmos.conn_features_variability.prov.IManager;

import java.util.LinkedList;

class Adapter
    implements mapekcosmos.variability.req.IFeatureManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        mapekcosmos.features.prov.IFeatureManager compFeatures =
            (mapekcosmos.features.prov.IFeatureManager) this.manager.getRequiredInterface(IFeatureManagerTag);
        compFeatures.updateRuntimeRegistry(sol);
    }
}

package mapekcosmos.conn_features_reader.impl;

import mapekcosmos.conn_features_reader.prov.IManager;

class Adapter implements mapekcosmos.reader.req.IFeatureManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void createAFeature(String name) {
        mapekcosmos.features.prov.IFeatureManager compFeatures =
            (mapekcosmos.features.prov.IFeatureManager) this.manager.getRequiredInterface(IFeatureManagerTag);
        compFeatures.createAFeature(name);
    }
}

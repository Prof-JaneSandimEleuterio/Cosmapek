package mapekcosmos.features.impl;

import mapekcosmos.features.core.FeatureM;
import mapekcosmos.features.core.FeatureMFactory;
import mapekcosmos.features.prov.IFeatureManager;
import mapekcosmos.features.prov.IManager;
import mapekcosmos.interfaces.IFeatureB;
import mapekcosmos.interfaces.IFeaturesB;

import java.util.LinkedList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class IFeatureManagerFacade implements mapekcosmos.features.impl.IInterfaceTags, IFeatureManager {
    private IManager manager = null;
    private FeatureM features;

    public IFeatureManagerFacade(IManager manager) {
        this.manager = manager;
        this.features = FeatureMFactory.createInstance(this.manager);
    }

    @Override public synchronized void createAFeature(String name) {
        features.createAFeature(name);
    }

    @Override public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        features.updateRuntimeRegistry(sol);
    }

    @Override public synchronized LinkedList<IFeatureB> getFeaturesWith(String feature) {
        return features.getFeaturesWith(feature);
    }

    @Override public synchronized boolean hasFeaturesWith(String feature) {
        return features.hasFeaturesWith(feature);
    }

    @Override public synchronized IFeaturesB getFeaturesInRuntime() {
        return features.getFeaturesInRuntime();
    }

    @Override public synchronized void clearFeatures() {
        features.clearFeatures();
    }

}

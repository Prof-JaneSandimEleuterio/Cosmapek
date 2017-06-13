package mapekcosmos.features.core;

import mapekcosmos.interfaces.IFeatureB;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public class Feature implements IFeatureB {
    private String name;

    public Feature(String name) {
        this.name = name;
    }

    @Override public String getFeatureName() {
        return name;
    }
}

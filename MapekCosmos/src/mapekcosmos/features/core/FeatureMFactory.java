package mapekcosmos.features.core;

import mapekcosmos.features.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class FeatureMFactory {
    private static FeatureM sensorM = null;

    public static synchronized FeatureM createInstance(IManager manager) {
        if (sensorM == null)
            sensorM = new FeatureM(manager);
        return sensorM;
    }
}

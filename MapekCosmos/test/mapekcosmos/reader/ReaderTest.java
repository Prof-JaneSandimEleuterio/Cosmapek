package mapekcosmos.reader;

import java.io.File;
import java.net.URI;

/**
 * Created by ArchyWin on 6/9/2015.
 */
public class ReaderTest implements IInterfaceTags {

    //requirements
    private mapekcosmos.components.prov.IManager comp;
    private mapekcosmos.components.prov.IComponentManager compIComp;
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorManager sensISens;
    private mapekcosmos.connectors.prov.IManager conn;
    private mapekcosmos.connectors.prov.IConnectorManager connIConn;
    private mapekcosmos.features.prov.IManager feature;
    private mapekcosmos.features.prov.IFeatureManager featureIFeature;
    private mapekcosmos.variability.prov.IManager varia;
    private mapekcosmos.variability.prov.IVariabilityManager variaIVaria;
    private mapekcosmos.reader.prov.IManager reade;
    private mapekcosmos.reader.prov.IReadingManager readeIReading;
    //mapekcosmos.connectors
    private mapekcosmos.conn_components_connectors.prov.IManager comp_conn;
    private mapekcosmos.conn_components_reader.prov.IManager comp_reade;
    private mapekcosmos.conn_components_variability.prov.IManager comp_varia;
    private mapekcosmos.conn_connectors_reader.prov.IManager conn_reade;
    private mapekcosmos.conn_connectors_variability.prov.IManager conn_varia;
    private mapekcosmos.conn_features_reader.prov.IManager feature_reade;
    private mapekcosmos.conn_features_variability.prov.IManager feature_varia;
    private mapekcosmos.conn_sensors_connectors.prov.IManager sens_conn;
    private mapekcosmos.conn_sensors_reader.prov.IManager sens_reade;
    private mapekcosmos.conn_sensors_variability.prov.IManager sens_varia;
    private mapekcosmos.conn_variability_reader.prov.IManager varia_reade;

    @org.junit.Before public void setUp() throws Exception {
        comp = mapekcosmos.components.impl.ComponentFactory.createInstance();
        compIComp =
            (mapekcosmos.components.prov.IComponentManager) comp.getProvidedInterface(IComponentManagerTag);
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorManager) sens.getProvidedInterface(ISensorManagerTag);

        conn = mapekcosmos.connectors.impl.ComponentFactory.createInstance();

        comp_conn = mapekcosmos.conn_components_connectors.impl.ComponentFactory.createInstance();
        comp_conn.setRequiredInterface(IComponentManagerTag, compIComp);
        sens_conn = mapekcosmos.conn_sensors_connectors.impl.ComponentFactory.createInstance();
        sens_conn.setRequiredInterface(ISensorManagerTag, sensISens);

        conn.setRequiredInterface(IComponentManagerTag,
            comp_conn.getProvidedInterface(IComponentManagerTag));
        conn.setRequiredInterface(ISensorManagerTag,
            sens_conn.getProvidedInterface(ISensorManagerTag));
        connIConn =
            (mapekcosmos.connectors.prov.IConnectorManager) conn.getProvidedInterface(IConnectorManagerTag);

        feature = mapekcosmos.features.impl.ComponentFactory.createInstance();
        featureIFeature =
            (mapekcosmos.features.prov.IFeatureManager) feature.getProvidedInterface(IFeatureManagerTag);

        varia = mapekcosmos.variability.impl.ComponentFactory.createInstance();

        comp_varia = mapekcosmos.conn_components_variability.impl.ComponentFactory.createInstance();
        comp_varia.setRequiredInterface(IComponentManagerTag, compIComp);
        sens_varia = mapekcosmos.conn_sensors_variability.impl.ComponentFactory.createInstance();
        sens_varia.setRequiredInterface(ISensorManagerTag, sensISens);
        feature_varia = mapekcosmos.conn_features_variability.impl.ComponentFactory.createInstance();
        feature_varia.setRequiredInterface(IFeatureManagerTag, featureIFeature);
        conn_varia = mapekcosmos.conn_connectors_variability.impl.ComponentFactory.createInstance();
        conn_varia.setRequiredInterface(IConnectorManagerTag, connIConn);

        varia.setRequiredInterface(IComponentManagerTag,
            comp_varia.getProvidedInterface(IComponentManagerTag));
        varia.setRequiredInterface(ISensorManagerTag,
            sens_varia.getProvidedInterface(ISensorManagerTag));
        varia.setRequiredInterface(IFeatureManagerTag,
            feature_varia.getProvidedInterface(IFeatureManagerTag));
        varia.setRequiredInterface(IConnectorManagerTag,
            conn_varia.getProvidedInterface(IConnectorManagerTag));
        variaIVaria = (mapekcosmos.variability.prov.IVariabilityManager) varia
            .getProvidedInterface(IVariabilityManagerTag);

        reade = mapekcosmos.reader.impl.ComponentFactory.createInstance();

        comp_reade = mapekcosmos.conn_components_reader.impl.ComponentFactory.createInstance();
        comp_reade.setRequiredInterface(IComponentManagerTag, compIComp);
        sens_reade = mapekcosmos.conn_sensors_reader.impl.ComponentFactory.createInstance();
        sens_reade.setRequiredInterface(ISensorManagerTag, sensISens);
        conn_reade = mapekcosmos.conn_connectors_reader.impl.ComponentFactory.createInstance();
        conn_reade.setRequiredInterface(IConnectorManagerTag, connIConn);
        feature_reade = mapekcosmos.conn_features_reader.impl.ComponentFactory.createInstance();
        feature_reade.setRequiredInterface(IFeatureManagerTag, featureIFeature);
        varia_reade = mapekcosmos.conn_variability_reader.impl.ComponentFactory.createInstance();
        varia_reade.setRequiredInterface(IVariabilityManagerTag, variaIVaria);

        reade.setRequiredInterface(IComponentManagerTag,
            comp_reade.getProvidedInterface(IComponentManagerTag));
        reade.setRequiredInterface(ISensorManagerTag,
            sens_reade.getProvidedInterface(ISensorManagerTag));
        reade.setRequiredInterface(IConnectorManagerTag,
            conn_reade.getProvidedInterface(IConnectorManagerTag));
        reade.setRequiredInterface(IFeatureManagerTag,
            feature_reade.getProvidedInterface(IFeatureManagerTag));
        reade.setRequiredInterface(IVariabilityManagerTag,
            varia_reade.getProvidedInterface(IVariabilityManagerTag));
        readeIReading =
            (mapekcosmos.reader.prov.IReadingManager) reade.getProvidedInterface(IReadingManagerTag);
        // Here begin the important

    }

    //void setConfigurationPath(String configurationPath)
    @org.junit.Test public void setConfigurationPath() {
    }

    //setVariabilityPath(String variabilityPath)
    @org.junit.Test public void setVariabilityPath() {
    }

    //void read()
    @org.junit.Test public void read() {

        String jarPath = "file:///C:/Users/ArchyWin/Dropbox/Codigos/wsJunior/MapekOsgi/resources/jar";

        String configurationPath =
            "file:///C:/Users/ArchyWin/Dropbox/Codigos/wsJunior/MapekCosmos/resources/config.xml";
        String variabilityPath =
            "file:///C:/Users/ArchyWin/Dropbox/Codigos/wsJunior/MapekCosmos/resources/variability.xml";

        File inputConfigurationPath = new File(URI.create(configurationPath));
        File inputVariabilityPath = new File(URI.create(variabilityPath));

        //to load the mapekcosmos.components
        readeIReading.setConfigurationPath(inputConfigurationPath.getPath());
        readeIReading.setVariabilityPath(inputVariabilityPath.getPath());
        readeIReading.read();

    }
}

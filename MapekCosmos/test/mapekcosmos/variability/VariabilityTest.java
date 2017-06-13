package mapekcosmos.variability;

import java.io.File;
import java.net.URI;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ArchyWin on 6/9/2015.
 */
public class VariabilityTest implements IInterfaceTags {
    private mapekcosmos.variability.prov.IManager varia;
    private mapekcosmos.variability.prov.IVariabilityManager variaIVaria;
    //requirements
    private mapekcosmos.components.prov.IManager comp;
    private mapekcosmos.components.prov.IComponentManager compIComp;
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorManager sensISens;
    private mapekcosmos.connectors.prov.IManager conn;
    private mapekcosmos.connectors.prov.IConnectorManager connIConn;
    private mapekcosmos.features.prov.IManager feature;
    private mapekcosmos.features.prov.IFeatureManager featureIFeature;
    //mapekcosmos.connectors
    private mapekcosmos.conn_components_connectors.prov.IManager comp_conn;
    private mapekcosmos.conn_components_variability.prov.IManager comp_varia;
    private mapekcosmos.conn_connectors_variability.prov.IManager conn_varia;
    private mapekcosmos.conn_features_variability.prov.IManager feature_varia;
    private mapekcosmos.conn_sensors_connectors.prov.IManager sens_conn;
    private mapekcosmos.conn_sensors_variability.prov.IManager sens_varia;

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

        // Here begin the important
    }

    //void setVariabilityPath(String variabilityPath);
    @org.junit.Test public void setVariabilityPath() {
        //Data
        /*String variabilityPath =
            "file:///C:/Users/ArchyWin/Dropbox/Codigos/wsJunior/MapekOsgi/resources/mapekcosmos.variability.xml";
        */
        //Test
        //Trivial method
    }

    //void read();
    @org.junit.Test public void read() {
        //Data
        String variabilityPath =
            "file:///C:/Users/ArchyWin/Dropbox/Codigos/wsJunior/MapekOsgi/resources/mapekcosmos.variability.xml";
        variaIVaria.setVariabilityPath(variabilityPath);
        //test
        //difficult to test (use just the debugger)
        variaIVaria.read();

    }

    //LinkedList<String> getASolutionWithout(LinkedList<String> failedFeatures);
    @org.junit.Test public void getASolutionWithout() {
        //Data
        String variabilityPath =
            "file:///C:/Users/ArchyWin/Dropbox/Codigos/wsJunior/MapekOsgi/resources/mapekcosmos.variability.xml";
        variaIVaria.setVariabilityPath(variabilityPath);
        variaIVaria.read(); // each time I read. The before set is cleaned.

        //Solution
        LinkedList<String> failureFeatures = new LinkedList<String>();

        failureFeatures.add("PersonServiceB");
        failureFeatures.add("PersonServiceC");
        failureFeatures.add("LocalizationServiceB");
        failureFeatures.add("LocalizationServiceC");
        Set<String> setSol=new TreeSet<String>();
        setSol.add("APP");
        setSol.add("Buscame");
        setSol.add("Person");
        setSol.add("PersonServiceA");
        setSol.add("Localization");
        setSol.add("LocalizationServiceA");
        //Test
        LinkedList<String> solutions = variaIVaria.getASolutionWithout(failureFeatures);

        Set<String> setA=new TreeSet<String>();
        for (int i = 0; i < solutions.size(); i++) {
            setA.add(solutions.get(i));
            System.out.println(solutions.get(i));
        }
        assertTrue(setSol.equals(setA));
    }
    //LinkedList<String> getASolutionWithout(LinkedList<String> failedFeatures);
    @org.junit.Test public void getASolutionWithoutB() {

        String variabilityPath =
            "file:///C:/Users/ArchyWin/Dropbox/Codigos/wsJunior/MapekOsgi/resources/mapekcosmos.variability.xml";

        File inputVariabilityPath = new File(URI.create(variabilityPath));

        //Data

        variaIVaria.setVariabilityPath(inputVariabilityPath.getPath());
        variaIVaria.read(); // each time I read. The before set is cleaned.

        //Solution
        LinkedList<String> failureFeatures = new LinkedList<String>();

        failureFeatures.add("PersonServiceA");
        failureFeatures.add("PersonServiceC");
        failureFeatures.add("LocalizationServiceA");
        failureFeatures.add("LocalizationServiceC");
        Set<String> setSol=new TreeSet<String>();
        setSol.add("APP");
        setSol.add("Buscame");
        setSol.add("Person");
        setSol.add("PersonServiceB");
        setSol.add("Localization");
        setSol.add("LocalizationServiceB");
        //Test
        LinkedList<String> solutions = variaIVaria.getASolutionWithout(failureFeatures);

        Set<String> setA=new TreeSet<String>();
        for (int i = 0; i < solutions.size(); i++) {
            setA.add(solutions.get(i));
        }
        assertTrue(setSol.equals(setA));
    }
    //LinkedList<String> getASolutionWithout(LinkedList<String> failedFeatures);
    @org.junit.Test public void getASolutionWithoutC() {
        //Data
        String variabilityPath =
            "file:///C:/Users/ArchyWin/Dropbox/Codigos/wsJunior/MapekOsgi/resources/mapekcosmos.variability.xml";
        variaIVaria.setVariabilityPath(variabilityPath);
        variaIVaria.read(); // each time I read. The before set is cleaned.

        //Solution
        LinkedList<String> failureFeatures = new LinkedList<String>();

        failureFeatures.add("PersonServiceA");
        failureFeatures.add("PersonServiceB");
        failureFeatures.add("LocalizationServiceA");
        failureFeatures.add("LocalizationServiceB");

        Set<String> setSol=new TreeSet<String>();
        setSol.add("APP");
        setSol.add("Buscame");
        setSol.add("Person");
        setSol.add("PersonServiceC");
        setSol.add("Localization");
        setSol.add("LocalizationServiceC");
        //Test
        LinkedList<String> solutions = variaIVaria.getASolutionWithout(failureFeatures);

        Set<String> setA=new TreeSet<String>();
        for (int i = 0; i < solutions.size(); i++) {
            setA.add(solutions.get(i));
        }
        assertTrue(setSol.equals(setA));
    }
    //LinkedList<String> getASolutionWithout(LinkedList<String> failedFeatures);
    @org.junit.Test public void getASolutionWithoutD() {
        //Data
        String variabilityPath =
            "file:///C:/Users/ArchyWin/Dropbox/Codigos/wsJunior/MapekOsgi/resources/mapekcosmos.variability.xml";
        variaIVaria.setVariabilityPath(variabilityPath);
        variaIVaria.read(); // each time I read. The before set is cleaned.

        //Solution
        LinkedList<String> failureFeatures = new LinkedList<String>();

        failureFeatures.add("PersonServiceB");
        failureFeatures.add("PersonServiceC");
        failureFeatures.add("LocalizationServiceB");
        failureFeatures.add("LocalizationServiceC");
        failureFeatures.add("Person");

        //Test
        LinkedList<String> solutions = variaIVaria.getASolutionWithout(failureFeatures);
        if(solutions==null){
            assertTrue(true);
        }else{
            assertTrue(false);
        }
    }

}

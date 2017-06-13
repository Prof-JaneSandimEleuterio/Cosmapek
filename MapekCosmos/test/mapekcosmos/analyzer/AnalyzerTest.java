package mapekcosmos.analyzer;

import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

/**
 * Created by ArchyWin on 6/9/2015.
 */
public class AnalyzerTest implements IInterfaceTags {

    private mapekcosmos.analyzer.prov.IManager analy;
    private mapekcosmos.analyzer.prov.IAnalysisManager analyIAnaly;
    //requirements
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorManager sensISens;
    //mapekcosmos.connectors
    private mapekcosmos.conn_sensors_analyzer.prov.IManager sens_analy;

    @org.junit.Before public void setUp() throws Exception {
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorManager) sens.getProvidedInterface(ISensorManagerTag);

        analy = mapekcosmos.analyzer.impl.ComponentFactory.createInstance();

        sens_analy = mapekcosmos.conn_sensors_analyzer.impl.ComponentFactory.createInstance();
        sens_analy.setRequiredInterface(ISensorManagerTag, sensISens);
        // Here begin the important
        analy.setRequiredInterface(ISensorManagerTag,
            sens_analy.getProvidedInterface(ISensorManagerTag));
        analyIAnaly =
            (mapekcosmos.analyzer.prov.IAnalysisManager) analy.getProvidedInterface(IAnalysisManagerTag);

    }

    //void start()
    @org.junit.Test public void start() {


    }

    //LinkedList<String> getFailedFeatures()
    @org.junit.Test public void getFailedFeatures() {
        String inputNameA = "SensorA";
        String inputFeatureA = "FeatureA";
        boolean inputIsSensorA = true;
        int inputOrderTA = 1;
        sensISens.createASensor(inputNameA, inputFeatureA, inputIsSensorA, inputOrderTA);

        String inputNameB = "SensorB";
        String inputFeatureB = "FeatureA";
        boolean inputIsSensorB = true;
        int inputOrderTB = 2;
        sensISens.createASensor(inputNameB, inputFeatureB, inputIsSensorB, inputOrderTB);

        String inputNameC = "SensorC";
        String inputFeatureC = "FeatureA";
        boolean inputIsSensorC = true;
        int inputOrderTC = 3;
        sensISens.createASensor(inputNameC, inputFeatureC, inputIsSensorC, inputOrderTC);

        LinkedList<String> sol = new LinkedList<String>();
        sol.add(inputFeatureA);
        //     sol.add(inputFeatureB);
        //     sol.add(inputFeatureC);

        sensISens.updateRuntimeRegistry(sol);
        analyIAnaly.start();

        LinkedList<String> tem = analyIAnaly.getFailedFeatures();
        for (String t : tem) {
            assertTrue(t.equals(sol.getFirst()));
        }

    }
}

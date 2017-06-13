package mapekcosmos.sensors;

import mapekcosmos.interfaces.ISensor;
import mapekcosmos.interfaces.ISensors;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ArchyWin on 6/9/2015.
 */
public class SensorsTest implements IInterfaceTags {
    private mapekcosmos.sensors.prov.IManager sens;
    private mapekcosmos.sensors.prov.ISensorManager sensISens;
    private mapekcosmos.sensors.prov.ISensorUpdater sensIUp;
    //requirements
    //mapekcosmos.connectors

    @org.junit.Before public void setUp() throws Exception {
        // Here begin the important
        sens = mapekcosmos.sensors.impl.ComponentFactory.createInstance();
        sensISens = (mapekcosmos.sensors.prov.ISensorManager) sens.getProvidedInterface(ISensorManagerTag);
        sensIUp= (mapekcosmos.sensors.prov.ISensorUpdater) sens.getProvidedInterface(ISensorUpdaterTag);
    }

    //void createASensor(String name, String feature, boolean isSensor, int orderT);
    @org.junit.Test public void createASensor() {
        //clean
        sensISens.clearSensors();
        //Data
        String inputName = "SensorA";
        String inputFeature = "FeatureA";
        boolean inputIsSensor = true;
        int inputOrderT = 1;
        sensISens.createASensor(inputName, inputFeature, inputIsSensor, inputOrderT);
        //Test
        boolean resp = sensISens.hasSensorsWith(inputFeature);
        assertTrue(resp);
    }

    //LinkedList<ISensor> getSensorsWith(String feature);
    @org.junit.Test public void getSensorsWith() {
        //clean
        sensISens.clearSensors();
        //Data
        String inputName = "SensorB";
        String inputFeature = "FeatureB";
        boolean inputIsSensor = true;
        int inputOrderT = 2;
        sensISens.createASensor(inputName, inputFeature, inputIsSensor, inputOrderT);
        //test
        LinkedList<ISensor> resp;
        resp = sensISens.getSensorsWith(inputFeature);

        for (ISensor s : resp) {
            assertEquals(s.getFeatureName(), inputFeature);
        }
    }

    //boolean hasSensorsWith(String feature);
    @org.junit.Test public void hasSensorsWith() {
        //clean
        sensISens.clearSensors();
        //Data
        String inputName = "SensorC";
        String inputFeature = "FeatureC";
        boolean inputIsSensor = true;
        int inputOrderT = 3;
        sensISens.createASensor(inputName, inputFeature, inputIsSensor, inputOrderT);
        //test
        boolean resp = sensISens.hasSensorsWith(inputFeature);
        assertTrue(resp);
    }

    //boolean hasSensorsInRuntime();
    @org.junit.Test public void hasSensorsInRuntime() {
        //clean
        sensISens.clearSensors();
        //Data
        String inputName = "SensorD";
        String inputFeature = "FeatureD";
        boolean inputIsSensor = true;
        int inputOrderT = 4;
        sensISens.createASensor(inputName, inputFeature, inputIsSensor, inputOrderT);

        String input2Name = "SensorD2";
        String input2Feature = "FeatureD";
        boolean input2IsSensor = true;
        int input2OrderT = 5;
        sensISens.createASensor(input2Name, inputFeature, input2IsSensor, input2OrderT);
        //output
        LinkedList<String> sol = new LinkedList<String>();
        sol.add(inputFeature);
        sol.add(input2Feature);

        //test
        sensISens.updateRuntimeRegistry(sol);

        ISensors group = sensISens.getSensorsInRuntime();
        int count = 0;
        boolean resp = true;
        for (ISensor s : group) {
            count++;
        }
        if (count == 0)
            resp = false;
        assertTrue(resp);
    }

    //ISensors getSensorsInRuntime();
    @org.junit.Test public void getSensorsInRuntime() {
        //clean
        sensISens.clearSensors();
        //Data
        String inputName = "SensorF";
        String inputFeature = "FeatureF";
        boolean inputIsSensor = true;
        int inputOrderT = 6;
        sensISens.createASensor(inputName, inputFeature, inputIsSensor, inputOrderT);

        LinkedList<String> sol = new LinkedList<String>();
        sol.add(inputFeature);

        //test
        sensISens.updateRuntimeRegistry(sol);
        ISensors group = sensISens.getSensorsInRuntime();
        ISensor temp = null;
        for (ISensor s : group) {
            if (s.getFeatureName() == inputFeature) {
                temp = s;
            }
        }
        assertEquals(temp.getName(), inputName);
    }

    //void updateRuntimeRegistry(LinkedList<String> sol);
    @org.junit.Test public void updateRuntimeRegistry() {
        //clean
        sensISens.clearSensors();
        String inputName = "SensorG";
        String inputFeature = "FeatureG";
        boolean inputIsSensor = true;
        int inputOrderT = 7;
        sensISens.createASensor(inputName, inputFeature, inputIsSensor, inputOrderT);

        //output
        LinkedList<String> sol2 = new LinkedList<String>();
        sol2.add(inputFeature);

        //test
        sensISens.updateRuntimeRegistry(sol2);

        ISensors group = sensISens.getSensorsInRuntime();
        for (ISensor s : group) {
            assertEquals(s.getName(), inputName);
        }
    }

    //void clearSensors();
    @org.junit.Test public void clearSensors() {
        //clean
        sensISens.clearSensors();
        String inputName = "SensorG";
        String inputFeature = "FeatureG";
        boolean inputIsSensor = true;
        int inputOrderT = 7;
        sensISens.createASensor(inputName, inputFeature, inputIsSensor, inputOrderT);

        //test
        sensISens.clearSensors();
        boolean r = sensISens.hasSensorsWith(inputFeature);
        assertTrue(!r);
    }
    // UPDATER SENSORS
    //boolean activateSensor(String name);
    @org.junit.Test public void activateSensor(){
        sensISens.clearSensors();
        String inputName = "SensorG";
        String inputFeature = "FeatureG";
        boolean inputIsSensor = true;
        int inputOrderT = 7;
        sensISens.createASensor(inputName, inputFeature, inputIsSensor, inputOrderT);
        sensIUp.activateSensor(inputName);




    }
    //boolean deactivateSensor(String name);
    @org.junit.Test public void deactivateSensor(){
        sensISens.clearSensors();
        String inputName = "SensorG";
        String inputFeature = "FeatureG";
        boolean inputIsSensor = true;
        int inputOrderT = 7;
        sensISens.createASensor(inputName, inputFeature, inputIsSensor, inputOrderT);
        sensIUp.activateSensor(inputName);
        sensIUp.deactivateSensor(inputName);


    }
}

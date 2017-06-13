package mapekcosmos.sensors.core;

import mapekcosmos.interfaces.ISensor;
import mapekcosmos.interfaces.ISensors;
import mapekcosmos.sensors.prov.IManager;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public class SensorM {
    private IManager manager;
    private ISensors sensors; //set of mapekcosmos.sensors
    private ISensors sensorsinRuntime; //set of mapekcosmos.sensors

    public SensorM(IManager manager) {
        this.manager = manager;
        this.sensors = new Sensors();
        this.sensorsinRuntime = new Sensors();
    }

    public synchronized void createASensor(String name, String feature, boolean isSensor, int orderT) {
        sensors.add(new Sensor(name, feature, isSensor, orderT));
    }

    public synchronized LinkedList<ISensor> getSensorsWith(String feature) {
        LinkedList<ISensor> resp = new LinkedList<ISensor>();
        for (ISensor s : sensors) {
            if (s.getFeatureName().equals(feature)) {
                resp.add(s);
            }
        }
        return resp;
    }

    public synchronized boolean hasSensorsWith(String feature) {
        if (getSensorsWith(feature).size() == 0) {
            return false;
        }

        return true;
    }

    public synchronized boolean hasSensorsInRuntime() {

        if(sensorsinRuntime.isEmpty()){
            return false;
        }
        return true;
    }

    public synchronized ISensors getSensorsInRuntime() {
        return sensorsinRuntime;
    }

    public synchronized void updateRuntimeRegistry(LinkedList<String> sol) {
        sensorsinRuntime.clear();
        for (String s : sol) {
            for (ISensor sen : getSensorsWith(s)) {
                sensorsinRuntime.add(sen);
            }
        }
    }

    public synchronized void clearSensors() {
        sensorsinRuntime.clear();
        sensors.clear();
    }

    public synchronized boolean activateSensor(String name) {
       /*
        if (!hasSensorsInRuntime() || !hasASensorInRuntimeWith(name)) {
            return false;
        }*/
        ISensor r=getASensorInRuntimeWith(name);
        if(r == null){
            return false;
        }else{
            r.setIsActivated(true);
            return true;
        }

    }

    private synchronized boolean hasASensorInRuntimeWith(String name) {
        if (getASensorInRuntimeWith(name) == null) {
            return false;
        }
        return true;
    }

    private synchronized ISensor getASensorInRuntimeWith(String name) {
        for (ISensor s : sensorsinRuntime) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    public synchronized boolean deactivateSensor(String name) {
        ISensor r=getASensorInRuntimeWith(name);
        if(r == null){
            return false;
        }else{
            r.setIsActivated(false);
            return true;
        }
    }
}

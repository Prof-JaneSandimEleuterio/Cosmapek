package mapekcosmos.analyzer.core;

import mapekcosmos.analyzer.prov.IManager;
import mapekcosmos.analyzer.req.ISensorManager;

import mapekcosmos.interfaces.ISensor;
import mapekcosmos.interfaces.ISensors;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Junior Cupe Casquina
 */
public class Analyzer implements IInterfaceTags {
    private IManager manager;
    private ISensorManager sensor;
    private SortedSet<String> failedFeatures;

    public Analyzer(IManager manager) {
        this.manager = manager;
        this.failedFeatures = new TreeSet<String>();
    }

    public synchronized void start() {
        sensor = (ISensorManager) manager.getRequiredInterface(ISensorManagerReq);
        if (sensor.hasSensorsInRuntime()) {
            analyzeSensors();
        }
    }

    private void analyzeSensors() {
        ISensors sensors = sensor.getSensors();//give me the mapekcosmos.sensors in run time

        failedFeatures.clear();
        for (ISensor sensor : sensors) {
            if (sensor.isActivated()) {
                failedFeatures.add(sensor.getFeatureName());//add the failed mapekcosmos.sensors
                //TO TEST
                long time= System.currentTimeMillis();
                android.util.Log.i("Buscame", "Analyzer_SensorFlagActivate: "+time);
            }
        }
    }

    public synchronized LinkedList<String> getFailedFeatures() {

        LinkedList<String> result = new LinkedList<String>();

        for (Iterator<String> it = failedFeatures.iterator(); it.hasNext(); ) {
            String el = it.next();
            result.add(el);
        }

        return result;
    }

    public synchronized boolean hasActivatedSensors() {
        if(failedFeatures.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean hasActivatedRuntimeSensors() {

        ISensors sensorsRuntime = sensor.getSensorsInRuntime();
        for (ISensor sensor : sensorsRuntime) {
            if (sensor.isActivated()) {
                return true;
            }
        }
        return  false;
    }
}

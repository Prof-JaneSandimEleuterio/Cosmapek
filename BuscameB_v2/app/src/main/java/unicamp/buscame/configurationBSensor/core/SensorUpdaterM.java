package unicamp.buscame.configurationBSensor.core;

import android.util.Log;

import unicamp.buscame.configurationBSensor.prov.IManager;
import unicamp.buscame.configurationBSensor.req.IConfigurationManager;
import unicamp.buscame.configurationBSensor.req.ISensorUpdater;
/**
 * @author Junior Cupe Casquina
 */
public class SensorUpdaterM {
    private IManager manager;
    private long timeLapse;
    private String nome;
    private IConfigurationManager configurationManager;
    private ISensorUpdater sensorUpdater;
    private boolean turnOn;


    public SensorUpdaterM(IManager manager) {
        this.manager = manager;
        this.timeLapse = 10000;
        this.turnOn = false;
        this.nome = "ConfigurationBSensor";
    }

    private void getManagers() {
            this.configurationManager =
                    (IConfigurationManager) manager.getRequiredInterface("IConfigurationManager");
            this.sensorUpdater =
                    (ISensorUpdater) manager.getRequiredInterface("ISensorUpdater");

    }

    public synchronized boolean runSensor() {
        this.turnOn = true;
            while (this.turnOn) {
                try {
                    Thread.sleep(timeLapse);
                    this.executeSensor();
                }catch (Exception e){
                    // the component has a error
                    Log.d("Buscame", "Error = Configuration B Sensor " + e.toString());
                }
            }

        return true;
    }

    private void executeSensor() {
        getManagers();
        try {
        //performance true and false
            long startTime = System.currentTimeMillis();
            configurationManager.getOperationHourList("1000");
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            if(totalTime>100000){
                long timeSensorI= System.currentTimeMillis();
                Log.d("Buscame", "Configuration B Sensor(Activated)I: "+timeSensorI+" " + nome + " Time: " + totalTime + " ");

                sensorUpdater.activateSensor(nome);

                long timeSensorF= System.currentTimeMillis();
                Log.d("Buscame", "Configuration B Sensor(Activated)F: " + timeSensorF + " " + nome + " Time: " + totalTime + " ");
            }else{
                long timeSensorI= System.currentTimeMillis();
                android.util.Log.i("Buscame", "Configuration B Sensor(Deactivated)I: " + timeSensorI + " ");

                sensorUpdater.deactivateSensor(nome);
                long timeSensorF= System.currentTimeMillis();
                android.util.Log.i("Buscame", "Configuration B Sensor(Deactivated)F: " + timeSensorF + " ");

            }
        }catch (Exception e){
            // the component has a error
            Log.d("Buscame", "Configuration B Sensor Catch -> " + e.toString());
            long timeSensorI= System.currentTimeMillis();
            android.util.Log.i("Buscame", "Configuration B Sensor(Activated)I: " + timeSensorI + " ");

            sensorUpdater.activateSensor(nome);

            long timeSensorF= System.currentTimeMillis();
            android.util.Log.i("Buscame", "Configuration B Sensor(Activated)F: " + timeSensorF + " ");

        }
    }

    public synchronized boolean deactivateSensor() {
        getManagers();
        this.turnOn = false;
        return true;
    }
}

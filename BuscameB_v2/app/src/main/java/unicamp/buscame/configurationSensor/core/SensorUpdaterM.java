package unicamp.buscame.configurationSensor.core;

import android.util.Log;

import unicamp.buscame.configurationSensor.prov.IManager;
import unicamp.buscame.configurationSensor.req.IConfigurationManager;
import unicamp.buscame.configurationSensor.req.ISensorUpdater;
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
        this.nome = "ConfigurationSensor";
    }

    private void getManagers() {
            this.configurationManager =
                    (IConfigurationManager) this.manager.getRequiredInterface("IConfigurationManager");
            this.sensorUpdater =
                    (ISensorUpdater) this.manager.getRequiredInterface("ISensorUpdater");
    }

    public synchronized boolean runSensor() {
        this.turnOn = true;
            while (this.turnOn) {
                try {
                Thread.sleep(timeLapse);
                this.executeSensor();
                }catch (Exception e){
                    // the component has a error
                    Log.d("Buscame", "Error = Configuration A Sensor " + e.toString());
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
                Log.d("Buscame", "Configuration A Sensor(Activated)I: "+timeSensorI+" " + nome + " Time: " + totalTime + " ");

                sensorUpdater.activateSensor(nome);

                long timeSensorF= System.currentTimeMillis();
                Log.d("Buscame", "Configuration A Sensor(Activated)F: " + timeSensorF + " " + nome + " Time: " + totalTime + " ");

            }else{
                long timeSensorI= System.currentTimeMillis();
                android.util.Log.i("Buscame", "Configuration A Sensor(Deactivated)I: " + timeSensorI + " ");

                sensorUpdater.deactivateSensor(nome);

                long timeSensorF= System.currentTimeMillis();
                android.util.Log.i("Buscame", "Configuration A Sensor(Deactivated)F: " + timeSensorF + " ");
            }
        }catch (Exception e){
            Log.d("Buscame", "Configuration A Sensor Catch -> " + e.toString());
            long timeSensorI= System.currentTimeMillis();
            android.util.Log.i("Buscame", "Configuration A Sensor(Activated)I: " + timeSensorI + " ");

            sensorUpdater.activateSensor(nome);

            long timeSensorF= System.currentTimeMillis();
            android.util.Log.i("Buscame", "Configuration A Sensor(Activated)F: " + timeSensorF + " ");
        }
    }

    public synchronized boolean deactivateSensor() {
        getManagers();
        this.turnOn = false;
        return true;
    }
}

package unicamp.buscame.productSensor.core;

import android.util.Log;

import unicamp.buscame.productSensor.prov.IManager;
import unicamp.buscame.productSensor.req.IProductManager;
import unicamp.buscame.productSensor.req.ISensorUpdater;

/**
 * @author Junior Cupe Casquina
 */
public class SensorUpdaterM {
    private IManager manager;
    private long timeLapse;
    private String nome;
    private IProductManager productManager;
    private ISensorUpdater sensorUpdater;
    private boolean turnOn;


    public SensorUpdaterM(IManager manager) {
        this.manager = manager;
        this.timeLapse = 10000;
        this.turnOn = false;
        this.nome = "ProductSensor";
    }

    private void getManagers() {
        this.productManager =
                (IProductManager) manager.getRequiredInterface("IProductManager");
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
                    Log.d("Buscame", "Error = Product A Sensor " + e.toString());
                }
            }

        return true;
    }

    private synchronized void executeSensor() {
        getManagers();
        try{
            long startTime = System.currentTimeMillis();
            productManager.getCompanyProductList("1000");
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            if(totalTime>100000){
                long timeSensorI= System.currentTimeMillis();
                Log.d("Buscame", "Product A Sensor(Activated)I: "+timeSensorI+" " + nome + " Time: " + totalTime + " ");

                sensorUpdater.activateSensor(nome);

                long timeSensorF= System.currentTimeMillis();
                Log.d("Buscame", "Product A Sensor(Activated)F: "+timeSensorF +" "+ nome + " Time: " + totalTime + " ");
            }else{
                long timeSensorI= System.currentTimeMillis();
                android.util.Log.i("Buscame", "Product A Sensor(Deactivated)I: " + timeSensorI + " ");

                sensorUpdater.deactivateSensor(nome);

                long timeSensorF= System.currentTimeMillis();
                android.util.Log.i("Buscame", "Product A Sensor(Deactivated)F: " + timeSensorF + " ");
            }
        }catch (Exception e){

            Log.d("Buscame", "Product A Sensor Catch -> " + e.toString());
            long timeSensorI= System.currentTimeMillis();
            android.util.Log.i("Buscame", "Product A Sensor(Activated)I: " + timeSensorI + " ");
            sensorUpdater.activateSensor(nome);
            long timeSensorF= System.currentTimeMillis();
            android.util.Log.i("Buscame", "Product A Sensor(Activated)F: " + timeSensorF + " ");
        }
    }

    public synchronized boolean deactivateSensor() {
        getManagers();
        this.turnOn = false;
        return true;
    }
}

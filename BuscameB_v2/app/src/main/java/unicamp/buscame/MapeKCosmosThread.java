package unicamp.buscame;

import java.io.File;

/**
 * @author ArchyWin on 9/17/2015.
 */
public class MapeKCosmosThread extends Thread implements IInterfaceTags {
    private mapekcosmos.reader.prov.IManager reade;
    private mapekcosmos.reader.prov.IReadingManager readeIReading;
    private mapekcosmos.controller.prov.IManager controll;
    private mapekcosmos.controller.prov.IControllerManager controllIControll;

    String sdcard_variability;
    String sdcard_config;
    String jarPath;

    public MapeKCosmosThread(String sdcard_variability, String sdcard_config, String jarPath) {
        super();
        this.sdcard_config=sdcard_config;
        this.sdcard_variability=sdcard_variability;
        this.jarPath=jarPath;
    }

    @Override
    public void run() {
        //super.run();
        reade = mapekcosmos.reader.impl.ComponentFactory.createInstance();
        readeIReading =
                (mapekcosmos.reader.prov.IReadingManager) reade.getProvidedInterface(IReadingManagerTag);

        controll = mapekcosmos.controller.impl.ComponentFactory.createInstance();
        controllIControll = (mapekcosmos.controller.prov.IControllerManager) controll
                .getProvidedInterface(IControllerManagerTag);


        String configurationPath = sdcard_config;
        String variabilityPath   = sdcard_variability;
        //to load the mapekcosmos.components
        readeIReading.setConfigurationPath(configurationPath);
        readeIReading.setVariabilityPath(variabilityPath);
        readeIReading.read();

        controllIControll.setJarPath(jarPath);

        //the loop
 // in milliseconds
        long monitoringTimeLapse = 2000;
        controllIControll.setTimeLapse(monitoringTimeLapse);

        controllIControll.execute();

       controllIControll.monitor();// here is the control loop
    }

}

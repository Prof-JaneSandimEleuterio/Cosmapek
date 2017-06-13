package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_configurationB_configurationBSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.configurationB.prov.IManager configurationB;
    private unicamp.buscame.configurationB.prov.IConfigurationManager configurationBIConf;

    private unicamp.buscame.conn_configurationB_configurationBSensor.prov.IManager configurationB_configurationBSensor;
    private unicamp.buscame.configurationBSensor.prov.IManager configurationBSensor;
    @Override
    public synchronized void execute() {
        configurationB = unicamp.buscame.configurationB.impl.ComponentFactory.createInstance();
        configurationBIConf =
                (unicamp.buscame.configurationB.prov.IConfigurationManager) configurationB.getProvidedInterface(IConfigurationManagerTag);
        configurationB_configurationBSensor = unicamp.buscame.conn_configurationB_configurationBSensor.impl.ComponentFactory.createInstance();
        configurationB_configurationBSensor.setRequiredInterface(IConfigurationManagerTag, configurationBIConf);

        configurationBSensor = unicamp.buscame.configurationBSensor.impl.ComponentFactory.createInstance();
        configurationBSensor.setRequiredInterface(IConfigurationManagerTag,
                configurationB_configurationBSensor.getProvidedInterface(IConfigurationManagerTag));
    }
}

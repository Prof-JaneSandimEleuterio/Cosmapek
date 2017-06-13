package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_configuration_configurationSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.configuration.prov.IManager configuration;
    private unicamp.buscame.configuration.prov.IConfigurationManager configurationIConf;

    private unicamp.buscame.conn_configuration_configurationSensor.prov.IManager configuration_configurationSensor;
    private unicamp.buscame.configurationSensor.prov.IManager configurationSensor;
    @Override
    public synchronized void execute() {
        configuration = unicamp.buscame.configuration.impl.ComponentFactory.createInstance();
        configurationIConf =
                (unicamp.buscame.configuration.prov.IConfigurationManager) configuration.getProvidedInterface(IConfigurationManagerTag);

        configuration_configurationSensor = unicamp.buscame.conn_configuration_configurationSensor.impl.ComponentFactory.createInstance();
        configuration_configurationSensor.setRequiredInterface(IConfigurationManagerTag, configurationIConf);

        configurationSensor = unicamp.buscame.configurationSensor.impl.ComponentFactory.createInstance();
        configurationSensor.setRequiredInterface(IConfigurationManagerTag,
                configuration_configurationSensor.getProvidedInterface(IConfigurationManagerTag));
    }
}

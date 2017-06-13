package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_configuration_company implements IExecution,IInterfaceTags {
    private unicamp.buscame.configuration.prov.IManager configuration;
    private unicamp.buscame.configuration.prov.IConfigurationManager configurationIConf;

    private unicamp.buscame.conn_configuration_company.prov.IManager configuration_company;
    private unicamp.buscame.company.prov.IManager company;

    @Override
    public synchronized void execute() {
        configuration = unicamp.buscame.configuration.impl.ComponentFactory.createInstance();
        configurationIConf =
                (unicamp.buscame.configuration.prov.IConfigurationManager) configuration.getProvidedInterface(IConfigurationManagerTag);

        configuration_company = unicamp.buscame.conn_configuration_company.impl.ComponentFactory.createInstance();
        configuration_company.setRequiredInterface(IConfigurationManagerTag, configurationIConf);

        company = unicamp.buscame.company.impl.ComponentFactory.createInstance();
        company.setRequiredInterface(IConfigurationManagerTag,
                configuration_company.getProvidedInterface(IConfigurationManagerTag));
    }
}

package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_configurationB_company implements IExecution,IInterfaceTags {
    private unicamp.buscame.configurationB.prov.IManager configurationB;
    private unicamp.buscame.configurationB.prov.IConfigurationManager configurationBIConf;
    private unicamp.buscame.conn_configurationB_company.prov.IManager configurationB_company;
    private unicamp.buscame.company.prov.IManager company;
    @Override
    public synchronized void execute() {
        configurationB = unicamp.buscame.configurationB.impl.ComponentFactory.createInstance();
        configurationBIConf =
                (unicamp.buscame.configurationB.prov.IConfigurationManager) configurationB.getProvidedInterface(IConfigurationManagerTag);

        configurationB_company = unicamp.buscame.conn_configurationB_company.impl.ComponentFactory.createInstance();
        configurationB_company.setRequiredInterface(IConfigurationManagerTag, configurationBIConf);

        company = unicamp.buscame.company.impl.ComponentFactory.createInstance();
        company.setRequiredInterface(IConfigurationManagerTag,
                configurationB_company.getProvidedInterface(IConfigurationManagerTag));
    }
}

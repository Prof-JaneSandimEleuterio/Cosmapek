package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * Created by ArchyWin on 8/20/2015.
 */
public class ConfigurationB implements IExecution,IInterfaceTags {
    private unicamp.buscame.configurationB.prov.IManager configurationB;
    private unicamp.buscame.configurationB.prov.IConfigurationManager configurationBIConf;
    @Override public void execute() {
/*        configurationB = unicamp.buscame.configurationB.impl.ComponentFactory.createInstance();
        configurationBIConf =
                (unicamp.buscame.configurationB.prov.IConfigurationManager) configurationB.getProvidedInterface(IConfigurationManagerTag);
*/    }
}

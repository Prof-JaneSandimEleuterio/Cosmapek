package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * Created by ArchyWin on 8/20/2015.
 */
public class Configuration implements IExecution,IInterfaceTags {
    private unicamp.buscame.configuration.prov.IManager configuration;
    private unicamp.buscame.configuration.prov.IConfigurationManager configurationIConf;
    @Override public void execute() {
/*        configuration = unicamp.buscame.configuration.impl.ComponentFactory.createInstance();
        configurationIConf =
                (unicamp.buscame.configuration.prov.IConfigurationManager) configuration.getProvidedInterface(IConfigurationManagerTag);
*/    }
}

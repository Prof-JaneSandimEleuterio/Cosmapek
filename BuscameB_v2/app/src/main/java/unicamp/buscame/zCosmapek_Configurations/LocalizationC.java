package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class LocalizationC implements IExecution,IInterfaceTags {
    private unicamp.buscame.localizationC.prov.IManager localizationC;
    private unicamp.buscame.localizationC.prov.ILocalizationManager localizationCILoca;
    @Override
    public void execute() {
/*        localizationC = unicamp.buscame.localizationC.impl.ComponentFactory.createInstance();
        localizationCILoca =
                (unicamp.buscame.localizationC.prov.ILocalizationManager) localizationC.getProvidedInterface(ILocalizationManagerTag);

*/
    }
}

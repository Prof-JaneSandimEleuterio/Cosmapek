package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class LocalizationB implements IExecution,IInterfaceTags {
    private unicamp.buscame.localizationB.prov.IManager localizationB;
    private unicamp.buscame.localizationB.prov.ILocalizationManager localizationBILoca;
    @Override
    public void execute() {
/*        localizationB = unicamp.buscame.localizationB.impl.ComponentFactory.createInstance();
        localizationBILoca =
                (unicamp.buscame.localizationB.prov.ILocalizationManager) localizationB.getProvidedInterface(ILocalizationManagerTag);
*/
    }
}

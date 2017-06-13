package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Localization implements IExecution,IInterfaceTags {
    private unicamp.buscame.localization.prov.IManager localization;
    private unicamp.buscame.localization.prov.ILocalizationManager localizationILoca;
    @Override
    public void execute() {
/*        localization = unicamp.buscame.localization.impl.ComponentFactory.createInstance();
        localizationILoca =
                (unicamp.buscame.localization.prov.ILocalizationManager) localization.getProvidedInterface(ILocalizationManagerTag);
*/
    }
}

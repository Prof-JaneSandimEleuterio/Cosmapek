package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_localization_company implements IExecution,IInterfaceTags {
    private unicamp.buscame.localization.prov.IManager localization;
    private unicamp.buscame.localization.prov.ILocalizationManager localizationILoca;

    private unicamp.buscame.conn_localization_company.prov.IManager localization_company;
    private unicamp.buscame.company.prov.IManager company;
    @Override
    public synchronized void execute() {
        localization = unicamp.buscame.localization.impl.ComponentFactory.createInstance();
        localizationILoca =
                (unicamp.buscame.localization.prov.ILocalizationManager) localization.getProvidedInterface(ILocalizationManagerTag);

        localization_company = unicamp.buscame.conn_localization_company.impl.ComponentFactory.createInstance();
        localization_company.setRequiredInterface(ILocalizationManagerTag, localizationILoca);

        company = unicamp.buscame.company.impl.ComponentFactory.createInstance();
        company.setRequiredInterface(ILocalizationManagerTag,
                localization_company.getProvidedInterface(ILocalizationManagerTag));
    }
}

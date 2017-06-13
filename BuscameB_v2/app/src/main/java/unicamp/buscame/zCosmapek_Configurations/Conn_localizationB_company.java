package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_localizationB_company implements IExecution,IInterfaceTags {
    private unicamp.buscame.localizationB.prov.IManager localizationB;
    private unicamp.buscame.localizationB.prov.ILocalizationManager localizationBILoca;

    private unicamp.buscame.conn_localizationB_company.prov.IManager localizationB_company;
    private unicamp.buscame.company.prov.IManager company;
    @Override
    public synchronized void execute() {
        localizationB = unicamp.buscame.localizationB.impl.ComponentFactory.createInstance();
        localizationBILoca =
                (unicamp.buscame.localizationB.prov.ILocalizationManager) localizationB.getProvidedInterface(ILocalizationManagerTag);

        localizationB_company = unicamp.buscame.conn_localizationB_company.impl.ComponentFactory.createInstance();
        localizationB_company.setRequiredInterface(ILocalizationManagerTag, localizationBILoca);

        company = unicamp.buscame.company.impl.ComponentFactory.createInstance();
        company.setRequiredInterface(ILocalizationManagerTag,
                localizationB_company.getProvidedInterface(ILocalizationManagerTag));
    }
}

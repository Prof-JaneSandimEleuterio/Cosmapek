package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_localizationC_company implements IExecution,IInterfaceTags {
    private unicamp.buscame.localizationC.prov.IManager localizationC;
    private unicamp.buscame.localizationC.prov.ILocalizationManager localizationCILoca;

    private unicamp.buscame.conn_localizationC_company.prov.IManager localizationC_company;
    private unicamp.buscame.company.prov.IManager company;
    @Override
    public synchronized void execute() {
        localizationC = unicamp.buscame.localizationC.impl.ComponentFactory.createInstance();
        localizationCILoca =
                (unicamp.buscame.localizationC.prov.ILocalizationManager) localizationC.getProvidedInterface(ILocalizationManagerTag);
        localizationC_company = unicamp.buscame.conn_localizationC_company.impl.ComponentFactory.createInstance();
        localizationC_company.setRequiredInterface(ILocalizationManagerTag, localizationCILoca);

        company = unicamp.buscame.company.impl.ComponentFactory.createInstance();
        company.setRequiredInterface(ILocalizationManagerTag,
                localizationC_company.getProvidedInterface(ILocalizationManagerTag));
    }
}

package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_localizationC_localizationCSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.localizationC.prov.IManager localizationC;
    private unicamp.buscame.localizationC.prov.ILocalizationManager localizationCILoca;

    private unicamp.buscame.conn_localizationC_localizationCSensor.prov.IManager localizationC_localizationCSensor;
    private unicamp.buscame.localizationCSensor.prov.IManager localizationCSensor;
    @Override
    public synchronized void execute() {
        localizationC = unicamp.buscame.localizationC.impl.ComponentFactory.createInstance();
        localizationCILoca =
                (unicamp.buscame.localizationC.prov.ILocalizationManager) localizationC.getProvidedInterface(ILocalizationManagerTag);

        localizationC_localizationCSensor = unicamp.buscame.conn_localizationC_localizationCSensor.impl.ComponentFactory.createInstance();
        localizationC_localizationCSensor.setRequiredInterface(ILocalizationManagerTag, localizationCILoca);

        localizationCSensor = unicamp.buscame.localizationCSensor.impl.ComponentFactory.createInstance();
        localizationCSensor.setRequiredInterface(ILocalizationManagerTag,
                localizationC_localizationCSensor.getProvidedInterface(ILocalizationManagerTag));
    }
}

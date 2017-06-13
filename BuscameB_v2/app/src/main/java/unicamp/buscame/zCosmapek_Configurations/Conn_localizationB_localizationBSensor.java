package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_localizationB_localizationBSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.localizationB.prov.IManager localizationB;
    private unicamp.buscame.localizationB.prov.ILocalizationManager localizationBILoca;

    private unicamp.buscame.conn_localizationB_localizationBSensor.prov.IManager localizationB_localizationBSensor;
    private unicamp.buscame.localizationBSensor.prov.IManager localizationBSensor;

    @Override
    public synchronized void execute() {
        localizationB = unicamp.buscame.localizationB.impl.ComponentFactory.createInstance();
        localizationBILoca =
                (unicamp.buscame.localizationB.prov.ILocalizationManager) localizationB.getProvidedInterface(ILocalizationManagerTag);
        localizationB_localizationBSensor = unicamp.buscame.conn_localizationB_localizationBSensor.impl.ComponentFactory.createInstance();
        localizationB_localizationBSensor.setRequiredInterface(ILocalizationManagerTag, localizationBILoca);

        localizationBSensor = unicamp.buscame.localizationBSensor.impl.ComponentFactory.createInstance();
        localizationBSensor.setRequiredInterface(ILocalizationManagerTag,
                localizationB_localizationBSensor.getProvidedInterface(ILocalizationManagerTag));
    }
}

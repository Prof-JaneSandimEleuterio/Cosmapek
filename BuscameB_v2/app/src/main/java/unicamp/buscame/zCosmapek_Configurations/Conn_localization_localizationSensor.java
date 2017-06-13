package unicamp.buscame.zCosmapek_Configurations;

import mapekcosmos.interfaces.IExecution;

/**
 * @author ArchyWin on 9/14/2015.
 */
public class Conn_localization_localizationSensor implements IExecution,IInterfaceTags {
    private unicamp.buscame.localization.prov.IManager localization;
    private unicamp.buscame.localization.prov.ILocalizationManager localizationILoca;

    private unicamp.buscame.conn_localization_localizationSensor.prov.IManager localization_localizationSensor;
    private unicamp.buscame.localizationSensor.prov.IManager localizationSensor;
    @Override
    public synchronized void execute() {
        localization = unicamp.buscame.localization.impl.ComponentFactory.createInstance();
        localizationILoca =
                (unicamp.buscame.localization.prov.ILocalizationManager) localization.getProvidedInterface(ILocalizationManagerTag);

        localization_localizationSensor = unicamp.buscame.conn_localization_localizationSensor.impl.ComponentFactory.createInstance();
        localization_localizationSensor.setRequiredInterface(ILocalizationManagerTag, localizationILoca);

        localizationSensor = unicamp.buscame.localizationSensor.impl.ComponentFactory.createInstance();
        localizationSensor.setRequiredInterface(ILocalizationManagerTag,
                localization_localizationSensor.getProvidedInterface(ILocalizationManagerTag));

    }
}

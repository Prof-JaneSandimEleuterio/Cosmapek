package unicamp.buscame.localization.core;

import unicamp.buscame.localization.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class LocalizationMFactory {
    private static LocalizationM localizationM = null;

    public static synchronized LocalizationM createInstance(IManager manager) {
        if (localizationM == null)
            localizationM = new LocalizationM(manager);
        return localizationM;
    }
}

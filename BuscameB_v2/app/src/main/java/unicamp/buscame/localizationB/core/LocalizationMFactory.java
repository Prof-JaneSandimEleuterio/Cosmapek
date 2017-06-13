package unicamp.buscame.localizationB.core;

import unicamp.buscame.localizationB.core.*;
import unicamp.buscame.localizationB.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class LocalizationMFactory {
    private static unicamp.buscame.localizationB.core.LocalizationM localizationM = null;

    public static synchronized unicamp.buscame.localizationB.core.LocalizationM createInstance(IManager manager) {
        if (localizationM == null)
            localizationM = new unicamp.buscame.localizationB.core.LocalizationM(manager);
        return localizationM;
    }
}

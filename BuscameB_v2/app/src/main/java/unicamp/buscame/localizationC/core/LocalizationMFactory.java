package unicamp.buscame.localizationC.core;

import unicamp.buscame.localizationC.core.*;
import unicamp.buscame.localizationC.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class LocalizationMFactory {
    private static unicamp.buscame.localizationC.core.LocalizationM localizationM = null;

    public static synchronized unicamp.buscame.localizationC.core.LocalizationM createInstance(IManager manager) {
        if (localizationM == null)
            localizationM = new unicamp.buscame.localizationC.core.LocalizationM(manager);
        return localizationM;
    }
}

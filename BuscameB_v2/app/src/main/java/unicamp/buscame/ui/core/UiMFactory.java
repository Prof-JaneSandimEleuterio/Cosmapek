package unicamp.buscame.ui.core;

import unicamp.buscame.ui.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class UiMFactory {
    private static UiM uiM = null;

    public static UiM createInstance(IManager manager) {
        if (uiM == null)
            uiM = new UiM(manager);
        return uiM;
    }
}

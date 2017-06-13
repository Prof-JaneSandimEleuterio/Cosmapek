package unicamp.buscame.company.core;

import unicamp.buscame.company.prov.IManager;

/**
 * Created by ArchyWin on 7/14/2015.
 */
public class CompanyMFactory {
    private static CompanyM companyM = null;

    public static synchronized CompanyM createInstance(IManager manager) {
        if (companyM == null)
            companyM = new CompanyM(manager);
        return companyM;
    }
}

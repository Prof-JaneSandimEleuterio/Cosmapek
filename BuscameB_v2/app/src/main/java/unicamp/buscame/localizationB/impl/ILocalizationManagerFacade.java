package unicamp.buscame.localizationB.impl;

import unicamp.buscame.localizationB.core.LocalizationM;
import unicamp.buscame.localizationB.core.LocalizationMFactory;
import unicamp.buscame.localizationB.impl.*;
import unicamp.buscame.localizationB.prov.ILocalizationManager;
import unicamp.buscame.localizationB.prov.IManager;
import unicamp.buscame.util.representation.CompanyList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class ILocalizationManagerFacade implements unicamp.buscame.localizationB.impl.IInterfaceTags, ILocalizationManager {
    private IManager manager = null;
    private LocalizationM localizationM;

    ILocalizationManagerFacade(IManager manager) {
        this.manager = manager;
        this.localizationM = LocalizationMFactory.createInstance(this.manager);
    }

    @Override
    public synchronized CompanyList getCompanyList(Double longitude, Double latitude, int numCompanies) {
        return localizationM.getCompanyList(longitude,latitude,numCompanies);
    }
}

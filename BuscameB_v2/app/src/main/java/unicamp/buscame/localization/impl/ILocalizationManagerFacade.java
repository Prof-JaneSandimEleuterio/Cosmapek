package unicamp.buscame.localization.impl;

import unicamp.buscame.localization.core.LocalizationM;
import unicamp.buscame.localization.core.LocalizationMFactory;
import unicamp.buscame.localization.prov.ILocalizationManager;
import unicamp.buscame.localization.prov.IManager;
import unicamp.buscame.util.representation.CompanyList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class ILocalizationManagerFacade implements IInterfaceTags, ILocalizationManager {
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

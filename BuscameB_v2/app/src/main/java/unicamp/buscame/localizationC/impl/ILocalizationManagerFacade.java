package unicamp.buscame.localizationC.impl;

import unicamp.buscame.localizationC.core.LocalizationM;
import unicamp.buscame.localizationC.core.LocalizationMFactory;
import unicamp.buscame.localizationC.impl.*;
import unicamp.buscame.localizationC.prov.ILocalizationManager;
import unicamp.buscame.localizationC.prov.IManager;
import unicamp.buscame.util.representation.CompanyList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class ILocalizationManagerFacade implements unicamp.buscame.localizationC.impl.IInterfaceTags, ILocalizationManager {
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

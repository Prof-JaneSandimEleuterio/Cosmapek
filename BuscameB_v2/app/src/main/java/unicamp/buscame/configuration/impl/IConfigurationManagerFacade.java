package unicamp.buscame.configuration.impl;

import unicamp.buscame.configuration.core.ConfigurationM;
import unicamp.buscame.configuration.core.ConfigurationMFactory;
import unicamp.buscame.configuration.prov.IConfigurationManager;
import unicamp.buscame.configuration.prov.IManager;
import unicamp.buscame.product.impl.*;
import unicamp.buscame.util.representation.CompanyOperationHourList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class IConfigurationManagerFacade implements IInterfaceTags, IConfigurationManager {
    private IManager manager = null;
    private ConfigurationM configurationM;

    IConfigurationManagerFacade(IManager manager) {
        this.manager = manager;
        this.configurationM = ConfigurationMFactory.createInstance(this.manager);
    }

    @Override
    public synchronized CompanyOperationHourList getOperationHourList(String companyId) {
        return configurationM.getOperationHourList(companyId);
    }
}

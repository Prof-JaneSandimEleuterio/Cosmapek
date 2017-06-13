package unicamp.buscame.configurationB.impl;

import unicamp.buscame.configurationB.core.ConfigurationM;
import unicamp.buscame.configurationB.core.ConfigurationMFactory;
import unicamp.buscame.configurationB.impl.*;
import unicamp.buscame.configurationB.prov.IConfigurationManager;
import unicamp.buscame.configurationB.prov.IManager;
import unicamp.buscame.product.impl.*;
import unicamp.buscame.util.representation.CompanyOperationHourList;

/**
 * Created by ArchyWin on 5/26/2015.
 */
class IConfigurationManagerFacade implements unicamp.buscame.configurationB.impl.IInterfaceTags, IConfigurationManager {
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

package unicamp.buscame.conn_configurationB_configurationBSensor.impl;

import unicamp.buscame.conn_configurationB_configurationBSensor.prov.IManager;
import unicamp.buscame.util.representation.CompanyOperationHourList;

class Adapter
    implements unicamp.buscame.configurationBSensor.req.IConfigurationManager, unicamp.buscame.conn_configurationB_configurationBSensor.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override
    public synchronized CompanyOperationHourList getOperationHourList(String companyId) {
        unicamp.buscame.configurationB.prov.IConfigurationManager compConfiguration =
                (unicamp.buscame.configurationB.prov.IConfigurationManager) this.manager.getRequiredInterface(IConfigurationManagerTag);
        return compConfiguration.getOperationHourList(companyId);
    }
}

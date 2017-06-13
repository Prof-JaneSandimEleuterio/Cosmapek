package unicamp.buscame.conn_configuration_configurationSensor.impl;

import unicamp.buscame.conn_configuration_configurationSensor.prov.IManager;
import unicamp.buscame.util.representation.CompanyOperationHourList;

class Adapter
    implements unicamp.buscame.configurationSensor.req.IConfigurationManager, unicamp.buscame.conn_configuration_configurationSensor.impl.IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override
    public synchronized CompanyOperationHourList getOperationHourList(String companyId) {
        unicamp.buscame.configuration.prov.IConfigurationManager compConfiguration =
                (unicamp.buscame.configuration.prov.IConfigurationManager) this.manager.getRequiredInterface(IConfigurationManagerTag);
        return compConfiguration.getOperationHourList(companyId);
    }
}

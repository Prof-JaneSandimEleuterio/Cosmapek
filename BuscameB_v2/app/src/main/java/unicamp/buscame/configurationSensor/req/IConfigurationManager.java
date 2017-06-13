package unicamp.buscame.configurationSensor.req;

import unicamp.buscame.util.representation.CompanyOperationHourList;

public interface IConfigurationManager {

    CompanyOperationHourList getOperationHourList(String companyId);

}

package unicamp.buscame.configurationBSensor.req;

import unicamp.buscame.util.representation.CompanyOperationHourList;

public interface IConfigurationManager {

    CompanyOperationHourList getOperationHourList(String companyId);

}

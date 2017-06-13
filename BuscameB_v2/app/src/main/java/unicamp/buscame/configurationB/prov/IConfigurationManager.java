package unicamp.buscame.configurationB.prov;

import unicamp.buscame.util.representation.CompanyOperationHourList;

public interface IConfigurationManager {

    CompanyOperationHourList getOperationHourList(String companyId);

}

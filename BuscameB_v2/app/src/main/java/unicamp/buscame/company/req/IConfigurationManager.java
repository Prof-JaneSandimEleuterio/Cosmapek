package unicamp.buscame.company.req;

import unicamp.buscame.util.representation.CompanyOperationHourList;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public interface IConfigurationManager {

    CompanyOperationHourList getOperationHourList(String companyId);
}

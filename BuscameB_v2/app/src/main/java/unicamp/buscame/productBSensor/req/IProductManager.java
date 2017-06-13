package unicamp.buscame.productBSensor.req;

import unicamp.buscame.util.representation.CompanyProductList;

public interface IProductManager {

    CompanyProductList getCompanyProductList(String companyId);

}

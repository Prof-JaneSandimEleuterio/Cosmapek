package unicamp.buscame.company.req;

import unicamp.buscame.util.representation.CompanyProductList;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public interface IProductManager {

    CompanyProductList getCompanyProductList(String companyId);
}

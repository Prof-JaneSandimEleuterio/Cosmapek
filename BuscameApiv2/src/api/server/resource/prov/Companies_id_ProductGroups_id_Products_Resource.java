package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Companies_id_ProductGroups_id_Products_Resource {
    @Get
    api.server.representation.CompanyProductList getCompanyProductGroupsProducts() throws Exception;

    @Delete
    void removeAllCompanyProductGroupsProducts() throws Exception;

    @Post
    api.server.representation.CompanyProduct addACompanyProductGroupProduct(api.server.representation.CompanyProduct bean) throws Exception;

}

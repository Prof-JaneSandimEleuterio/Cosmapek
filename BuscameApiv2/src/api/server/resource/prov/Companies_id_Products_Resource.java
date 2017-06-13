package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Companies_id_Products_Resource {

    @Get
    api.server.representation.CompanyProductList getCompanyProducts() throws Exception;

    @Delete
    void removeAllCompanyProducts() throws Exception;

    @Post
    api.server.representation.CompanyProduct addACompanyProduct(api.server.representation.CompanyProduct bean) throws Exception;

}

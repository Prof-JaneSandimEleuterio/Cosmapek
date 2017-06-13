package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Products_Resource {
    @Get
    api.server.representation.CompanyProductList getAllProducts() throws Exception;

    @Delete
    void removeAllProducts() throws Exception;

    //post not have logic
}

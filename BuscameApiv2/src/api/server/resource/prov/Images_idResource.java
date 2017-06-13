package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Images_idResource {
    @Get
    api.server.representation.Image getAImage() throws Exception;

    @Put
    api.server.representation.Image updateAImage(
            api.server.representation.Image bean) throws Exception;

    @Delete
    void removeAImage() throws Exception;
}

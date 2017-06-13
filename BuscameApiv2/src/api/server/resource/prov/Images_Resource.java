package api.server.resource.prov;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public interface Images_Resource {
    @Get
    api.server.representation.ImageList getAllImages() throws Exception;

    @Delete
    void removeAllImages() throws Exception;

    //post not have logic
}

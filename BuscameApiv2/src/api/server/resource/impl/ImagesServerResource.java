package api.server.resource.impl;

import api.server.representation.ImageList;
import api.server.resource.prov.ImagesResource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class ImagesServerResource extends AbstractServerResource implements ImagesResource, DBConfiguration {
    @Override public ImageList getAImagesList() throws Exception {
        return null;
    }
}

package api.server.resource.impl;

import api.server.representation.Image;
import api.server.resource.prov.Images_idResource;
import db.main.DBConfiguration;

/**
 * Created by ArchyWin on 8/27/2015.
 */
public class Images_idServerResource extends AbstractServerResource implements Images_idResource, DBConfiguration {
    @Override public Image getAImage() throws Exception {
        return null;
    }

    @Override public Image updateAImage(Image bean) throws Exception {
        return null;
    }

    @Override public void removeAImage() throws Exception {

    }
}

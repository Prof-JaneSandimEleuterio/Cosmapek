package db.entity.company;

import db.entity.general.Configuration;

/**
 * Created by Junior Cupe on 8/22/2015.
 */
public class CompanyConfiguration extends Configuration {
    private boolean open;

    public boolean isOpen() {
        return open;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }
}

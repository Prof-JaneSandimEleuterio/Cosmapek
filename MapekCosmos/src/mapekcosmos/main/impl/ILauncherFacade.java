package mapekcosmos.main.impl;

import mapekcosmos.main.core.Boot;
import mapekcosmos.main.core.BootFactory;
import mapekcosmos.main.prov.ILauncher;
import mapekcosmos.main.prov.IManager;

/**
 * @author Junior Cupe Casquina
 */
class ILauncherFacade implements ILauncher {
    private IManager manager;
    private Boot launcher;

    ILauncherFacade(IManager manager) {
        this.manager = manager;
        this.launcher = BootFactory.createInstance(this.manager);
    }

    @Override public synchronized boolean start() {

        return launcher.start();
    }
}

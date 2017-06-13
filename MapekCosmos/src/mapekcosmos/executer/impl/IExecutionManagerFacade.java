package mapekcosmos.executer.impl;

import mapekcosmos.executer.core.Executer;
import mapekcosmos.executer.core.ExecuterFactory;
import mapekcosmos.executer.prov.IExecutionManager;
import mapekcosmos.executer.prov.IManager;

/**
 * @author Junior Cupe Casquina
 */
class IExecutionManagerFacade implements mapekcosmos.executer.impl.IInterfaceTags, IExecutionManager {
    private IManager manager;
    private Executer executer;

    IExecutionManagerFacade(IManager manager) {
        this.manager = manager;
        this.executer = ExecuterFactory.createInstance(this.manager);
    }

    @Override public synchronized void start() {
        executer.start();
    }

    @Override public synchronized void setJarPath(String jarPath) {
        executer.setJarPath(jarPath);
    }
}

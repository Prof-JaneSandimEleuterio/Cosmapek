package mapekcosmos.controller.impl;

import mapekcosmos.controller.core.Monitor;
import mapekcosmos.controller.core.MonitorFactory;
import mapekcosmos.controller.prov.IControllerManager;
import mapekcosmos.controller.prov.IManager;

/**
 * @author Junior Cupe Casquina
 */
class IControllerManagerFacade implements IControllerManager {
    private IManager manager;
    private Monitor monitor;

    IControllerManagerFacade(IManager manager) {
        this.manager = manager;
        monitor = MonitorFactory.createInstance(this.manager);
    }

    @Override public synchronized void execute() {
        monitor.execute();
    }

    @Override public synchronized void setTimeLapse(long monitoringTimeLapse) {
        monitor.setTimeLapse(monitoringTimeLapse);
    }

    @Override public synchronized void monitor() {
        monitor.monitor();
    }

    @Override public synchronized void setJarPath(String jarPath) {
        monitor.setJarPath(jarPath);
    }
}

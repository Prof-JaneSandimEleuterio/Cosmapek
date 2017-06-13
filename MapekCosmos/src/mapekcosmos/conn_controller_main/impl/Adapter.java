package mapekcosmos.conn_controller_main.impl;

import mapekcosmos.conn_controller_main.prov.IManager;

class Adapter implements mapekcosmos.main.req.IControllerManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void execute() {
        mapekcosmos.controller.prov.IControllerManager compController =
            (mapekcosmos.controller.prov.IControllerManager) this.manager
                .getRequiredInterface(IControllerManagerTag);
        compController.execute();
    }

    @Override public synchronized void setTimeLapse(long monitoringTimeLapse) {
        mapekcosmos.controller.prov.IControllerManager compController =
            (mapekcosmos.controller.prov.IControllerManager) this.manager
                .getRequiredInterface(IControllerManagerTag);
        compController.setTimeLapse(monitoringTimeLapse);
    }

    @Override public synchronized void monitor() {
        mapekcosmos.controller.prov.IControllerManager compController =
            (mapekcosmos.controller.prov.IControllerManager) this.manager
                .getRequiredInterface(IControllerManagerTag);
        compController.monitor();
    }

    @Override public synchronized void setJarPath(String jarPath) {
        mapekcosmos.controller.prov.IControllerManager compController =
            (mapekcosmos.controller.prov.IControllerManager) this.manager
                .getRequiredInterface(IControllerManagerTag);
        compController.setJarPath(jarPath);
    }
}

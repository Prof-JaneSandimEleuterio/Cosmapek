package mapekcosmos.conn_executer_controller.impl;

import mapekcosmos.conn_executer_controller.prov.IManager;

class Adapter
    implements mapekcosmos.controller.req.IExecutionManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void start() {
        mapekcosmos.executer.prov.IExecutionManager compExecuter =
            (mapekcosmos.executer.prov.IExecutionManager) this.manager
                .getRequiredInterface(IExecutionManagerTag);
        compExecuter.start();
    }

    @Override public synchronized void setJarPath(String jarPath) {
        mapekcosmos.executer.prov.IExecutionManager compExecuter =
            (mapekcosmos.executer.prov.IExecutionManager) this.manager
                .getRequiredInterface(IExecutionManagerTag);
        compExecuter.setJarPath(jarPath);
    }
}

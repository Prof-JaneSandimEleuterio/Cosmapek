package mapekcosmos.conn_planner_controller.impl;

import mapekcosmos.conn_planner_controller.prov.IManager;

class Adapter
    implements mapekcosmos.controller.req.IPlanningManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }

    @Override public synchronized void start() {
        mapekcosmos.planner.prov.IPlanningManager compPlanner =
            (mapekcosmos.planner.prov.IPlanningManager) this.manager.getRequiredInterface(IPlanningManagerTag);
        compPlanner.start();
    }
}

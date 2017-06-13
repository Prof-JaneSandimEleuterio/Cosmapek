package mapekcosmos.conn_planner_executer.impl;

import mapekcosmos.conn_planner_executer.prov.IManager;

import java.util.LinkedList;

class Adapter implements mapekcosmos.executer.req.IPlanningManager, IInterfaceTags {
    private IManager manager;

    Adapter(IManager manager) {
        this.manager = manager;
    }
/*
    @Override public void start() {
        mapekcosmos.components.prov.IComponentManager compComponents = (mapekcosmos.components.prov.IComponentManager) this.manager.getRequiredInterface(IComponentManagerTag);
       // compComponents.start();
    }
*/

    @Override public synchronized void start() {
        mapekcosmos.planner.prov.IPlanningManager compPlanner =
            (mapekcosmos.planner.prov.IPlanningManager) this.manager.getRequiredInterface(IPlanningManagerTag);
        compPlanner.start();
    }

    @Override public synchronized LinkedList<String> getComponents() {
        mapekcosmos.planner.prov.IPlanningManager compPlanner =
            (mapekcosmos.planner.prov.IPlanningManager) this.manager.getRequiredInterface(IPlanningManagerTag);
        return compPlanner.getComponents();
    }
}

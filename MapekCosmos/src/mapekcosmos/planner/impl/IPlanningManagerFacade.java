package mapekcosmos.planner.impl;

import mapekcosmos.planner.core.Planner;
import mapekcosmos.planner.core.PlannerFactory;
import mapekcosmos.planner.prov.IPlanningManager;
import mapekcosmos.planner.prov.IManager;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
class IPlanningManagerFacade implements IPlanningManager {
    private IManager manager;
    private Planner planner;

    IPlanningManagerFacade(IManager manager) {
        this.manager = manager;
        this.planner = PlannerFactory.createInstance(this.manager);
    }

    @Override public synchronized void start() {
        planner.start();
    }

    @Override public synchronized LinkedList<String> getComponents() {
        return planner.getComponents();
    }
}

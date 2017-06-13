package mapekcosmos.controller.core;

import mapekcosmos.controller.prov.IManager;
import mapekcosmos.controller.req.IAnalysisManager;
import mapekcosmos.controller.req.IExecutionManager;
import mapekcosmos.controller.req.IPlanningManager;

/**
 * @author Junior Cupe Casquina
 */
public class Monitor implements mapekcosmos.controller.core.IInterfaceTags {
    private IManager manager;

    private long timeLapse;
    private String jarPath;

    private IAnalysisManager analyzer;
    private IExecutionManager executor;
    private IPlanningManager planner;

    public Monitor(IManager manager) {
        this.manager = manager;
        this.timeLapse = 1000;// 1 second(default)
        this.jarPath = "";
    }

    private void getManagers() {
        IManager mg = getManager();
        analyzer = (IAnalysisManager) mg.getRequiredInterface(IAnalysisManagerTag);
        executor = (IExecutionManager) mg.getRequiredInterface(IExecutionManagerTag);
        planner = (IPlanningManager) mg.getRequiredInterface(IPlanningManagerTag);
    }

    public synchronized void execute() {

        getManagers();
        analyzer.start();
        planner.start();
        executor.setJarPath(getJarPath());
        executor.start();
    }

    public synchronized void setTimeLapse(long monitoringTimeLapse) {
        getManagers();
        this.timeLapse = monitoringTimeLapse;
    }

    public synchronized void monitor() {
        getManagers();
        while (true) {
            try {
                Thread.sleep(timeLapse);
                //this.wait(getTimeLapse());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.execute();
        }
    }

    public synchronized void setJarPath(String jarPath) {
        getManagers();
        this.jarPath = jarPath;
    }

    private  long getTimeLapse() {
        return timeLapse;
    }

    private IManager getManager() {
        return manager;
    }

    private String getJarPath() {
        return jarPath;
    }
}

package mapekcosmos.executer.core;

import mapekcosmos.executer.prov.IManager;
import mapekcosmos.executer.req.IPlanningManager;
import mapekcosmos.interfaces.IExecution;

import java.util.*;

/**
 * @author Junior Cupe Casquina
 */
public class Executer implements IInterfaceTags {
    private IManager manager;
    private String jarPath;

    private IPlanningManager planner;


    public Executer(IManager manager) {
        this.manager = manager;
        this.jarPath = "file:///C:/Users/ArchyWin/Dropbox/Codigos/wsJunior/Mapek/resources";
    }

    private void getManagers() {
        planner = (IPlanningManager) manager.getRequiredInterface(IPlanningManagerReq);
        //
    }

    public synchronized void start() {
        getManagers();
        loadComponents(planner.getComponents());//get the names of the mapekcosmos.components
    }

    private void loadComponents(LinkedList<String> components) {
        getManagers();
        String path;
        try {

            for (String compName : components) {
                path = getJarPath()+"." + compName;
                Class<?> c = Class.forName(path);
                Object obj = c.newInstance();
                IExecution exe=(IExecution)obj;
                exe.execute();
                exe=null;
                obj=null;
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public synchronized void setJarPath(String jarPath) {
        this.jarPath = jarPath;
    }

    private String getJarPath() {
        return jarPath;
    }
}

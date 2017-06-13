package mapekcosmos.planner.core;

import mapekcosmos.interfaces.IComponent;
import mapekcosmos.interfaces.IConnector;
import mapekcosmos.interfaces.IElement;
import mapekcosmos.interfaces.ISensor;
import mapekcosmos.planner.core.sort.DefaultAlgorithm;
import mapekcosmos.planner.core.sort.Sort;
import mapekcosmos.planner.prov.IManager;
import mapekcosmos.planner.req.*;

import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author Junior Cupe Casquina
 */
public class Planner implements IInterfaceTags {
    private IManager manager;
    private IAnalysisManager analyzer;
    private IVariabilityManager variability;
    private ISensorManager sensors;
    private IComponentManager components;
    private IConnectorManager connectors;

    private LinkedList<String> featureSolution;
    private LinkedList<IElement> componentsSolution;

    public Planner(IManager manager) {
        this.manager = manager;
        this.featureSolution = new LinkedList<String>();
    }

    private void getManagers() {
        analyzer = (IAnalysisManager) manager.getRequiredInterface(IAnalysisManagerReq);
        variability = (IVariabilityManager) manager.getRequiredInterface(IVariabilityManagerReq);
        //
        sensors = (ISensorManager) manager.getRequiredInterface(ISensorManagerReq);
        connectors = (IConnectorManager) manager.getRequiredInterface(IConnectorManagerReq);
        components = (IComponentManager) manager.getRequiredInterface(IComponentManagerReq);
    }

    public synchronized void start() {
        getManagers();
//====================================================================
        //Hack to the test just the plan and the executor
        //remove this to get a normal execution
        //featureSolution = variability.getASolutionWithout(hackFailedFeatures());
//====================================================================
        featureSolution = variability.getASolutionWithout(analyzer.getFailedFeatures());//Solution real; it works

    }
//Hack
  /*  private LinkedList<String> hackFailedFeatures() {
        String[] setSol1 = new String[3];
        String[] setSol2 = new String[3];
        String[] setSol3 = new String[2];
        setSol1[0]="LocalizationServiceA";
        setSol1[1]="LocalizationServiceB";
        setSol1[2]="LocalizationServiceC";
        setSol2[0]="ProductServiceA";
        setSol2[1]="ProductServiceB";
        setSol2[2]="ProductServiceC";
        setSol3[0]="ConfigurationServiceA";
        setSol3[1]="ConfigurationServiceB";
        TreeSet<String> sol=new TreeSet<String>();
        sol.clear();
        hackFailedRandom(setSol1, sol);
        hackFailedRandom(setSol2, sol);
        hackFailedRandom(setSol3, sol);
        return hackToList(sol);
    }
//Hack
    private void hackFailedRandom(String[] setSol1, TreeSet<String> sol) {
        Random ran = new Random(Double.doubleToLongBits(Math.random()));
        //System.nanoTime()
        int tam=setSol1.length;
        int numE = (int)(ran.nextDouble()* (tam));//number of elements
        int t2=-1;
        for(int i=0;i<numE;i++){
            int t=(int)(ran.nextDouble()*(tam));
            while(t2==t){
                t=(int)(ran.nextDouble()*(tam));
            }
            sol.add(setSol1[t]);
            t2=t;
        }
    }
//Hack
    private LinkedList<String> hackToList(TreeSet<String> sol) {
        LinkedList<String> res=new LinkedList<String>();
        Iterator<String> it = sol.iterator();
        while(it.hasNext()) {
            res.add(it.next());
        }
        return res;
    }
*/
    public synchronized LinkedList<String> getComponents() {
        getManagers();
        componentsSolution = new LinkedList<IElement>();

        for (int i = 0; i < featureSolution.size(); i++) {
            String feature = featureSolution.get(i);
            if (sensors.hasSensorsWith(feature)) {

                for (ISensor sensor : sensors.getSensorsWith(feature)) {
                    if(!existOtherEquals(componentsSolution,sensor))
                    componentsSolution.add(sensor);
                }
            }
            if (connectors.hasConnectorsWith(feature)) {
                for (IConnector conne : connectors.getConnectorsWith(feature)) {
                    if(!existOtherEquals(componentsSolution,conne))
                    componentsSolution.add(conne);
                }
            }
            if (components.hasComponentsWith(feature)) {
                for (IComponent comps : components.getComponentsWith(feature)) {
                    if(!existOtherEquals(componentsSolution,comps))
                    componentsSolution.add(comps);
                }
            }
        }

        orderComponents(componentsSolution);
        return getNames(componentsSolution);
    }

    private boolean existOtherEquals(LinkedList<IElement> componentsSolution, IElement ele) {
        for(IElement e:componentsSolution){
            if((e.getName().equals(ele.getName())) && (e.getPosition()==ele.getPosition())){
                return true;
            }
        }
        return false;
    }

    private LinkedList<String> getNames(LinkedList<IElement> ele) {
        LinkedList<String> resp = new LinkedList<String>();
        for (IElement e : ele) {
            resp.add(e.getName());
        }
        return resp;
    }
    private void orderComponents(LinkedList<IElement> solution) {
        Sort s = new DefaultAlgorithm();
        s.sort(solution);
    }
}

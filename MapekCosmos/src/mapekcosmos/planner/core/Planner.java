package mapekcosmos.planner.core;

import mapekcosmos.interfaces.IComponent;
import mapekcosmos.interfaces.IConnector;
import mapekcosmos.interfaces.IElement;
import mapekcosmos.interfaces.ISensor;
import mapekcosmos.planner.core.sort.DefaultAlgorithm;
import mapekcosmos.planner.core.sort.Sort;
import mapekcosmos.planner.prov.IManager;
import mapekcosmos.planner.req.*;

import java.util.LinkedList;
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
        featureSolution = variability.getASolutionWithout(analyzer.getFailedFeatures());
    }

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

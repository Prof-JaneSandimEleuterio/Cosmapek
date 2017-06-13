package mapekcosmos.variability.core.fm2;

import org.sat4j.specs.TimeoutException;
import mapekcosmos.variability.core.fm2.editing.NodeCreator;
import mapekcosmos.variability.core.prop4j.Node;
import mapekcosmos.variability.core.prop4j.SatSolver;

import java.util.*;

/**
 * @author Junior Cupe Casquina
 */
public class FeatureModelAnalyzer implements IFeatureModelAnalyzer {
    private static final String TRUE = "True";
    private static final String FALSE = "False";

    private IFeatureModel fm;

    public FeatureModelAnalyzer(IFeatureModel featureModel) {
        this.fm = featureModel;
    }

    @Override public synchronized  LinkedList<String> getASolutionWithout(LinkedList<String> failedFeatures) {
        //algorithm brute force
        //eliminate the features the model copy
        //get a solution
        //return the solution
        IFeatureModel copy=fm.getCopy();
        copy.remove(failedFeatures);

        Node root = NodeCreator.createNodes(copy);
        LinkedList<String> solution=new LinkedList<String>();
        SatSolver list=new SatSolver(root, 1000);
        try {
            if(list.isSatisfiable()){
                solution=list.getASolutionFeatures();
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        if(!solution.isEmpty()){
            solution.removeLast();
        }
        return solution;
    }

    @Override public synchronized int countConcreteFeatures() {
        int number = 0;
        for (IFeature feature : fm.getFeatures())
            if (feature.isConcrete())
                number++;
        return number;
    }
}

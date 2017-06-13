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

    @Override public LinkedList<String> getASolutionWithout(LinkedList<String> failedFeatures) {
        //algorithm brute force
        //eliminate the mapekcosmos.features the model copy
        //get a solution
        //return the solution
        IFeatureModel copy=fm.getCopy();
        //if I am trying delete a feature that not must to be deleted
       /* Map<String,IFeature> invariants=copy.getMapInvariant();

        for(String s:failedFeatures){
            if(invariants.containsKey(s)){
                return null;
            }
        }
        */
        copy.remove(failedFeatures);
        //Set<String> lSet = new TreeSet<String>(failedFeatures);

        //Node root =NodeCreator.createNodes(copy,lSet);

        //Node root = NodeCreator.createNodes(fm.clone());

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
        solution.removeLast();
        return solution;
    }

    @Override public int countConcreteFeatures() {
        int number = 0;
        for (IFeature feature : fm.getFeatures())
            if (feature.isConcrete())
                number++;
        return number;
    }
}

package mapekcosmos.variability.core.fm2;

import mapekcosmos.variability.core.prop4j.Node;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Junior Cupe Casquina
 */
public class FeatureModel implements IFeatureModel, PropertyConstants {
    private IFeature rootFeature;
    private final RenamingsManager renamingsManager = new RenamingsManager(this);
    private final FeatureModelAnalyzer analyser = createAnalyser();

    /*
        public FeatureModel() {
            this.rootFeature = new Feature("Root");///////////
            featureTable.put("root",rootFeature);/////////////
        }
    */
    private FeatureModelAnalyzer createAnalyser() {
        return new FeatureModelAnalyzer(this);
    }

    private final Map<String, IFeature> featureTable = new ConcurrentHashMap<String, IFeature>();
    private final Map<String, IFeature> featureInvariantTable = new ConcurrentHashMap<String, IFeature>();
    protected final List<IConstraint> constraints = new LinkedList<IConstraint>();

    private final List<PropertyChangeListener> listenerList =
        new LinkedList<PropertyChangeListener>();

    /*
    private final List<String> comments;
    private final List<String> annotations;
    private ColorschemeTable colorschemeTable;
    private final List<String> featureOrderList;
    */

    @Override public synchronized IFeatureModelAnalyzer getAnalyser() {
        return analyser;
    }

    @Override public synchronized void reset() {
        if (rootFeature != null) {
            while (rootFeature.hasChildren()) {
                IFeature child = rootFeature.getLastChild();
                deleteChildFeatures(child);
                rootFeature.removeChild(child);
                featureTable.remove(child.getName());
            }
            rootFeature = null;
        }
        featureTable.clear();
        renamingsManager.clear();
        constraints.clear();
        /*
        if (comments != null) {
            comments.clear();
        }
        if (annotations != null) {
            annotations.clear();
        }
        if (colorschemeTable != null) {
          //  colorschemeTable.reset();
        }
        featureOrderList.clear();
        */
    }

    private void deleteChildFeatures(IFeature feature) {
        while (feature.hasChildren()) {
            IFeature child = feature.getLastChild();
            deleteChildFeatures(child);
            feature.removeChild(child);
            featureTable.remove(child.getName());
        }
    }

    @Override public synchronized void handleModelDataLoaded() {
        fireEvent(MODEL_DATA_LOADED);
    }

    private final void fireEvent(final String action) {
        final PropertyChangeEvent event =
            new PropertyChangeEvent(this, action, Boolean.FALSE, Boolean.TRUE);
        for (PropertyChangeListener listener : listenerList) {
            listener.propertyChange(event);
        }
    }

    @Override public synchronized IFeature getFeature(String name) {
        return featureTable.get(name);
    }

    @Override public synchronized boolean addFeature(IFeature f) {
        String name = f.getName();
        if (featureTable.containsKey(name))
            return false;
        featureTable.put(name, f);
      /*  if((f.isAnd()) || f.isAbstract() || f.isAlternative()){//may be here put the static or dynamic attribute
            featureInvariantTable.put(name, f);
        }*/
        return true;
    }
    @Override public synchronized Map<String, IFeature> getMapInvariant(){
        return featureInvariantTable;
    }

    @Override public synchronized void setRoot(IFeature f) {
        this.rootFeature = f;
    }

    @Override public synchronized void addConstraint(IConstraint c) {
        constraints.add(c);
    }

    @Override public synchronized Collection<IFeature> getFeatures() {
        return Collections.unmodifiableCollection(featureTable.values());
    }

    @Override public synchronized IFeature getRoot() {
        return rootFeature;
    }

    @Override public synchronized List<Node> getPropositionalNodes() {
        LinkedList<Node> nodes = new LinkedList<Node>();
        for (IConstraint c : constraints) {
            nodes.add(c.getNode());
        }
        return Collections.unmodifiableList(nodes);
    }

    @Override public synchronized IRenamingsManager getRenamingsManager() {
        return renamingsManager;
    }

    @Override public synchronized IFeatureModel clone() {
        FeatureModel clone = new FeatureModel();

        clone.featureTable.putAll(this.featureTable);
        if (rootFeature == null) {
            //
            clone.rootFeature = new Feature(clone, "Root");
            clone.featureTable.put("root", clone.rootFeature);
        } else {
            clone.rootFeature = clone.featureTable.get(rootFeature.getName());
        }
        clone.constraints.addAll(constraints);
        return clone;
    }

    @Override synchronized public void remove(LinkedList<String> listNameOfFeatures) {
        for(String s:listNameOfFeatures){
            IFeature f=getFeature(s);
            //deleteFeature(f);//tenho a versao 2
            deleteFeatureV2(f);
        }


    }
    private boolean deleteFeature(IFeature feature) {
        // the root can not be deleted
        if (feature == rootFeature) {
            return false;
        }

        // check if it exists
        String name = feature.getName();
        if (!featureTable.containsKey(name)) {
            return false;
        }

        // use the group type of the feature to delete
        IFeature parent = feature.getParent();

        if (parent.getChildrenCount() == 1) {
            if (feature.isAnd()) {
                parent.setAnd();
            } else if (feature.isAlternative()) {
                parent.setAlternative();
            } else {
                parent.setOr();
            }
        }

        // add children to parent
        int index = parent.getChildIndex(feature);
        while (feature.hasChildren()) {
            parent.addChildAtPosition(index, feature.removeLastChild());
        }

        // delete feature
        parent.removeChild(feature);
        featureTable.remove(name);
        return true;
    }

    private boolean deleteFeatureV2(IFeature feature) {
        // the root can not be deleted
        if (feature == rootFeature) {
            return false;
        }

        // check if it exists
        String name = feature.getName();
        if (!featureTable.containsKey(name)) {
            return false;
        }

        //
        /*
        // use the group type of the feature to delete
        IFeature parent = feature.getParent();

        if (parent.getChildrenCount() == 1) {
            if (feature.isAnd()) {
                parent.setAnd();
            } else if (feature.isAlternative()) {
                parent.setAlternative();
            } else {
                parent.setOr();
            }
        }

        // add children to parent
        int index = parent.getChildIndex(feature);
        while (feature.hasChildren()) {
            parent.addChildAtPosition(index, feature.removeLastChild());
        }

        // delete feature
        parent.removeChild(feature);
        featureTable.remove(name);*/
        IFeature parent = feature.getParent();
        while(feature.hasChildren()){
            deleteFeatureV2(feature.getLastChild());
        }
        parent.removeChild(feature);
        return true;
    }

    @Override public IFeatureModel getCopy() {
        FeatureModel fm3=new FeatureModel();
        IFeature newRoot;
        fm3.featureTable.clear();

        if (rootFeature == null) {
        }else{
            newRoot=rootFeature.getCopy();
            newRoot.setParent(null);
            copyChilds(newRoot);
            fm3.featureTable.put(newRoot.getName(),newRoot);
            fillTable(newRoot,fm3.featureTable);
            fm3.rootFeature=newRoot;
        }
        fm3.constraints.addAll(constraints);
        return fm3;
    }

    private void fillTable(IFeature newRoot, Map<String, IFeature> featureTable) {
        for(IFeature f:newRoot.getChildren()){
            featureTable.put(f.getName(),f);
            fillTable(f,featureTable);
        }
    }


    private void copyChilds(IFeature newRoot) {
        if(newRoot!=null){
            LinkedList<IFeature> childs=newRoot.getChildren();
            LinkedList<IFeature> childsCopy= new LinkedList<IFeature>();
            for(IFeature child:childs){
                IFeature childCopy=child.getCopy();
                childCopy.setParent(newRoot);
                copyChilds(childCopy);
                childsCopy.add(childCopy);
            }
            newRoot.setChildren(childsCopy);
        }
    }
}

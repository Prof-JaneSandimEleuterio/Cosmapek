package mapekcosmos.variability.core.fm2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public class Feature implements IFeature, PropertyConstants {
    private String name;
    private String description;

    private boolean mandatory;
    private boolean concret;
    private boolean and;
    private boolean multiple;
    private boolean hidden;
    private boolean constraintSelected;

    private IFeatureModel featureModel;
    private FeatureStatus status;
    private FMPoint location;

    private LinkedList<IFeature> children = new LinkedList<IFeature>();
    private IFeature parent;
    private IFeatureConnection parentConnection = new FeatureConnection(this);

    private LinkedList<IFeatureConnection> sourceConnections = new LinkedList<IFeatureConnection>();
    private LinkedList<IFeatureConnection> targetConnections = new LinkedList<IFeatureConnection>();

    private boolean or=false;

    //registry my listener
    private LinkedList<PropertyChangeListener> listenerList =
        new LinkedList<PropertyChangeListener>();

    public Feature(String name) {
        this.name = name;
    }

    public Feature(IFeatureModel featureModel, String name) {
        this.featureModel = featureModel;
        this.name = name;

        this.mandatory = false;
        this.concret = true;
        this.and = true;
        this.multiple = false;
        this.hidden = false;
        this.constraintSelected = false;
        this.status = FeatureStatus.NORMAL;
        this.location = new FMPoint(0, 0);
        this.description = null;
        this.parent = null;

        sourceConnections.add(parentConnection);
    }


    @Override public void setDescription(String description) {
        this.description = description;
    }

    @Override public void setMandatory(boolean b) {
        this.mandatory = b;
        fireMandatoryChanged();
    }

    private void fireMandatoryChanged() {
        PropertyChangeEvent event =
            new PropertyChangeEvent(this, MANDATORY_CHANGED, Boolean.FALSE, Boolean.TRUE);
        for (PropertyChangeListener listener : listenerList)
            listener.propertyChange(event);
    }

    @Override public void setAnd() {
        this.and = true;
    }

    @Override public void setAlternative() {
        this.and = false;
        this.multiple = false;
    }

    @Override public void setOr() {
        //hack
        this.or=true;
        //
        this.and = false;
        this.multiple = true;
    }

    @Override public void setAbstract(boolean anAbstract) {
        this.concret = !anAbstract;
        fireChildrenChanged();
    }

    @Override public void setSensor(boolean sensor) {

    }

    @Override public void setDynamic(boolean dynamic) {

    }

    @Override public void setNewLocation(FMPoint featureLocation) {
        this.location = featureLocation;
    }

    @Override public void addChild(IFeature f) {
        children.add(f);
        f.setParent(this);
        fireChildrenChanged();
    }

    private void fireChildrenChanged() {
        PropertyChangeEvent event =
            new PropertyChangeEvent(this, CHILDREN_CHANGED, Boolean.FALSE, Boolean.TRUE);
        for (PropertyChangeListener listener : listenerList)
            listener.propertyChange(event);
    }

    @Override public void setParent(IFeature feature) {
        if (feature == parent)
            return;
        // delete old parent connection (if existing)
        if (parent != null) {
            parent.removeTargetConnection(parentConnection);
            parentConnection.setTarget(null);
        }

        // update the target
        parent = feature;
        if (feature != null) {
            parentConnection.setTarget(feature);
            feature.addTargetConnection(parentConnection);
        }
    }

    @Override public boolean removeTargetConnection(IFeatureConnection parentConnection) {
        return targetConnections.remove(parentConnection);
    }

    @Override public boolean addTargetConnection(IFeatureConnection parentConnection) {
        return targetConnections.add(parentConnection);
    }

    @Override public boolean isAbstract() {
        return !isConcrete();
    }

    @Override public String getName() {
        return name;
    }

    @Override public boolean isConcrete() {
        return concret;
    }

    @Override public boolean hasChildren() {
        return !children.isEmpty();
    }

    @Override public LinkedList<IFeature> getChildren() {
        return children;
    }

    @Override public int getChildrenCount() {
        return children.size();
    }

    @Override public boolean isAnd() {
        return and;
    }

    @Override public boolean isMandatory() {
        return parent == null || !parent.isAnd() || mandatory;
    }

    @Override public boolean isAlternative() {
        return !and && !multiple;
    }

    @Override public IFeature getParent() {
        return parent;
    }

    @Override public boolean isMandatorySet() {
        return mandatory;
    }

    @Override public IFeature getLastChild() {
        if (!children.isEmpty()) {
            return children.getLast();
        }
        return null;
    }

    @Override public void removeChild(IFeature child) {
        children.remove(child);
        child.setParent(null);
        fireChildrenChanged();
    }

    public int getChildIndex(IFeature feature) {
        return children.indexOf(feature);
    }
    public void addChildAtPosition(int index, IFeature newChild) {
        children.add(index, newChild);
        newChild.setParent(this);
        fireChildrenChanged();
    }
    public IFeature removeLastChild() {
        IFeature child = children.removeLast();
        child.setParent(null);
        fireChildrenChanged();
        return child;
    }
    /*Setters*/

    @Override public IFeature getCopy() {
        IFeature featureCopy=new Feature(getName());
        featureCopy.setAbstract(isAbstract());
        if(isAnd()){featureCopy.setAnd();}
        else if(isAlternative()){featureCopy.setAlternative();}
        else if(isOr()){featureCopy.setOr();}

        if(isAbstract()) featureCopy.setAbstract(true);
        if(isMandatory()) featureCopy.setMandatory(true);
        /*FMPoint newloca=new FMPoint(location.getX(),location.getY());
        fcopy.setNewLocation(newloca);
*/
        featureCopy.setParent(getParent());
        featureCopy.setChildren(getChildren());
        return featureCopy;
    }

    @Override public boolean isOr() {
        return or;
    }

    @Override public FMPoint getNewLocation() {
        return this.location;
    }

    @Override public void setChildren(LinkedList<IFeature> children) {
        this.children=children;
    }
}

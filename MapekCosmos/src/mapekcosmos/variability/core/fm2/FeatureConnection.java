package mapekcosmos.variability.core.fm2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;

/**
 * Created by ArchyWin on 6/4/2015.
 */
public class FeatureConnection implements IFeatureConnection, PropertyConstants {
    private IFeature source;
    private IFeature target;

    private LinkedList<PropertyChangeListener> listenerList =
        new LinkedList<PropertyChangeListener>();

    public FeatureConnection(IFeature feature) {
        this.source = feature;
    }

    @Override public void setTarget(IFeature feature) {
        if (this.target == feature) {
            return;
        }
        this.target = feature;
        fireParentChanged();
    }

    private void fireParentChanged() {
        PropertyChangeEvent event =
            new PropertyChangeEvent(this, PARENT_CHANGED, Boolean.FALSE, Boolean.TRUE);
        for (PropertyChangeListener listener : listenerList)
            listener.propertyChange(event);
    }

}

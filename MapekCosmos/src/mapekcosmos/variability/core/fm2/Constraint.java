package mapekcosmos.variability.core.fm2;

import mapekcosmos.variability.core.prop4j.Node;

/**
 * @author Junior Cupe Casquina
 */
public class Constraint implements IConstraint {
    private IFeatureModel featureModel;
    private Node propNode;
    private FMPoint location = new FMPoint(0, 0);

    public Constraint(IFeatureModel featureModel, Node first) {
        this.featureModel = featureModel;
        this.propNode = first;
    }

    @Override public void setLocation(FMPoint fmPoint) {
        location = fmPoint;
    }

    @Override public Node getNode() {
        return propNode;
    }
}

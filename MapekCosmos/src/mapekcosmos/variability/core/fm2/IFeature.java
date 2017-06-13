package mapekcosmos.variability.core.fm2;

import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
public interface IFeature {
    void setDescription(String description);

    void setMandatory(boolean b);

    void setAnd();

    void setAlternative();

    void setOr();

    void setAbstract(boolean anAbstract);

    void setSensor(boolean sensor);

    void setDynamic(boolean dynamic);

    void setNewLocation(FMPoint featureLocation);

    FMPoint getNewLocation();

    void addChild(IFeature f);

    void setParent(IFeature feature);

    boolean removeTargetConnection(IFeatureConnection parentConnection);

    boolean addTargetConnection(IFeatureConnection parentConnection);

    boolean isAbstract();

    String getName();

    boolean isConcrete();

    boolean hasChildren();

    LinkedList<IFeature> getChildren();

    void setChildren(LinkedList<IFeature> children);
    int getChildrenCount();

    boolean isAnd();

    boolean isMandatory();

    boolean isAlternative();

    boolean isOr();

    IFeature getParent();

    boolean isMandatorySet();

    IFeature getLastChild();

    void removeChild(IFeature child);

    int getChildIndex(IFeature feature);
    void addChildAtPosition(int index, IFeature newChild);
    IFeature removeLastChild();

    IFeature getCopy();
}

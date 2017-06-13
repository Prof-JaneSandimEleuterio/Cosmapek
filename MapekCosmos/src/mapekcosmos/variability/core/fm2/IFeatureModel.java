package mapekcosmos.variability.core.fm2;

import mapekcosmos.variability.core.prop4j.Node;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Junior Cupe Casquina
 */
public interface IFeatureModel {
    IFeatureModelAnalyzer getAnalyser();

    void reset();

    void handleModelDataLoaded();

    IFeature getFeature(String name);

    boolean addFeature(IFeature f);

    void setRoot(IFeature f);

    void addConstraint(IConstraint c);

    Collection<IFeature> getFeatures();

    IFeature getRoot();

    List<Node> getPropositionalNodes();

    IRenamingsManager getRenamingsManager();

    IFeatureModel clone();

    void remove(LinkedList<String> listNameOfFeatures);

    Map<String, IFeature> getMapInvariant();

    IFeatureModel getCopy();
}

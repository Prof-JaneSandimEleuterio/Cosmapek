package mapekcosmos.interfaces;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public interface IFeaturesB extends Iterable<IFeatureB> {
    void add(IFeatureB feature);

    void clear();

    boolean isEmpty();
}

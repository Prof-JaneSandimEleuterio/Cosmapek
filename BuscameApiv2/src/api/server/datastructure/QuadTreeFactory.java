package api.server.datastructure;

import db.entity.company.Company;

/**
 * Created by Junior Cupe on 9/4/2015.
 */
public class QuadTreeFactory {
    private static QuadTree quadTree = null;

    public static QuadTree<Double,Company> createInstance() {
        if (quadTree == null)
            quadTree = new QuadTree<Double,Company>();
        return quadTree;
    }

}

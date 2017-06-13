package api.server.datastructure.sort;

import api.server.datastructure.DisCompany;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
//de menor a mayor please
public class DefaultAlgorithm implements Sort {
    private LinkedList<DisCompany> defaultSort(LinkedList<DisCompany> input) {
        Collections.sort(input, new ComparatorIElement());
        return input;
    }

    @Override public LinkedList<DisCompany> sort(LinkedList<DisCompany> input) {
        //implement this method
        return defaultSort(input);//we can uses other algorithm to order
    }
}

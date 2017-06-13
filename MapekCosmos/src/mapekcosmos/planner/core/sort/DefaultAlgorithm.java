package mapekcosmos.planner.core.sort;

import mapekcosmos.interfaces.IElement;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Junior Cupe Casquina
 */
//de menor a mayor please
public class DefaultAlgorithm implements Sort {
    private LinkedList<IElement> defaultSort(LinkedList<IElement> input) {
        Collections.sort(input, new ComparatorIElement());
        return input;
    }

    @Override public LinkedList<IElement> sort(LinkedList<IElement> input) {
        //implement this method
        return defaultSort(input);//we can uses other algorithm to order
    }
}

package mapekcosmos.planner.core.sort;

import mapekcosmos.interfaces.IElement;

import java.util.LinkedList;

/**
 * Created by ArchyWin on 5/28/2015.
 */
public class MergeSortAlgorithm implements Sort {
    private void merge(LinkedList<IElement> input, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        LinkedList<IElement> L = new LinkedList<IElement>();
        LinkedList<IElement> R = new LinkedList<IElement>();
        for (int i = 0; i <= n1; i++) {
            L.add(i, input.get(p + i - 1));
        }
        for (int j = 0; j <= n1; j++) {
            R.add(j, input.get(q + j));
        }
        L.add(n1 + 1, null);
        R.add(n2 + 1, null);//error null with size
        int i = 1;
        int j = 1;
        for (int k = p; k < r; k++) {
            if (L.get(i).getPosition() <= R.get(j).getPosition()) {
                input.add(k, L.get(i));
                i++;
            } else {
                input.add(k, R.get(j));
                j++;
            }
        }
    }

    private void mergeSort(LinkedList<IElement> input, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(input, p, q);
            mergeSort(input, q + 1, r);
            merge(input, p, q, r);
        }
    }

    private LinkedList<IElement> mergeSort(LinkedList<IElement> input) {
        int r = input.size();
        mergeSort(input, 0, r - 1);
        return input;
    }

    @Override public LinkedList<IElement> sort(LinkedList<IElement> input) {
        return mergeSort(input);
    }
}

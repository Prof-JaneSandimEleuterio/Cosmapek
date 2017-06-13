package mapekcosmos.features.core;

import mapekcosmos.interfaces.IFeatureB;
import mapekcosmos.interfaces.IFeaturesB;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public class Features implements IFeaturesB {
    private LinkedList<IFeatureB> arrayList;
    private int currentSize;

    public Features() {
        currentSize = 0;
        arrayList = new LinkedList<IFeatureB>();
    }

    @Override public synchronized void add(IFeatureB featureB) {
        arrayList.add(currentSize, featureB);
        currentSize++;
    }

    @Override public synchronized void clear() {
        arrayList.clear();
        currentSize = 0;
    }

    @Override public synchronized boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override public synchronized Iterator<IFeatureB> iterator() {
        Iterator<IFeatureB> it = new FeatureIterator();
        /* new Iterator<IFeatureB>() {

            private int currentIndex = 0;

            @Override public synchronized boolean hasNext() {
                return currentIndex < currentSize && arrayList.get(currentIndex) != null;
            }

            @Override public synchronized IFeatureB next() {
                return arrayList.get(currentIndex++);
            }

            @Override public synchronized void remove() {
                throw new UnsupportedOperationException();
            }
        };*/
        return it;
    }

    class FeatureIterator implements Iterator<IFeatureB>{
        private int currentIndex = 0;

        @Override public synchronized boolean hasNext() {
            return currentIndex < currentSize && arrayList.get(currentIndex) != null;
        }

        @Override public synchronized IFeatureB next() {
            return arrayList.get(currentIndex++);
        }

        @Override public synchronized void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

package mapekcosmos.sensors.core;

import mapekcosmos.interfaces.ISensor;
import mapekcosmos.interfaces.ISensors;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public class Sensors implements ISensors {
    private LinkedList<ISensor> arrayList;
    private int currentSize;

    public Sensors() {
        currentSize = 0;
        arrayList = new LinkedList<ISensor>();
    }

    @Override public synchronized void add(ISensor sensor) {
        arrayList.add(currentSize, sensor);
        currentSize++;
    }

    @Override public synchronized void clear() {
        arrayList.clear();
        currentSize = 0;
    }

    @Override public synchronized boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override public synchronized Iterator<ISensor> iterator() {
        //
        Iterator<ISensor> it =new SensorsIterator();
        /*new Iterator<ISensor>() {

            private int currentIndex = 0;

            @Override public synchronized boolean hasNext() {
                return currentIndex < currentSize && arrayList.get(currentIndex) != null;
            }

            @Override public synchronized ISensor next() {
                return arrayList.get(currentIndex++);
            }

            @Override public synchronized void remove() {
                throw new UnsupportedOperationException();
            }
        };*/
        return it;
    }
    class SensorsIterator implements Iterator<ISensor>{

        private int currentIndex = 0;

        @Override public synchronized boolean hasNext() {
            return currentIndex < currentSize && arrayList.get(currentIndex) != null;
        }

        @Override public synchronized ISensor next() {
            return arrayList.get(currentIndex++);
        }

        @Override public synchronized void remove() {
            throw new UnsupportedOperationException();
        }

    }

}

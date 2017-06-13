package mapekcosmos.connectors.core;

import mapekcosmos.interfaces.IConnector;
import mapekcosmos.interfaces.IConnectors;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public class Connectors implements IConnectors {
    private LinkedList<IConnector> arrayList;
    private int currentSize;

    public Connectors() {
        this.currentSize = 0;
        this.arrayList = new LinkedList<IConnector>();
    }

    @Override public synchronized void add(IConnector connector) {
        arrayList.add(currentSize, connector);
        currentSize++;
    }

    @Override public synchronized void clear() {
        arrayList.clear();
        currentSize = 0;
    }

    @Override public synchronized boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override public synchronized Iterator<IConnector> iterator() {
        Iterator<IConnector> it = new ConnectorIterator();
            /*new Iterator<IConnector>() {

            private int currentIndex = 0;

            @Override public synchronized boolean hasNext() {
                return currentIndex < currentSize && arrayList.get(currentIndex) != null;
            }

            @Override public synchronized IConnector next() {
                return arrayList.get(currentIndex++);
            }

            @Override public synchronized void remove() {
                throw new UnsupportedOperationException();
            }
        };*/
        return it;
    }

    class ConnectorIterator implements Iterator<IConnector>{

        private int currentIndex = 0;

        @Override public synchronized boolean hasNext() {
            return currentIndex < currentSize && arrayList.get(currentIndex) != null;
        }

        @Override public synchronized IConnector next() {
            return arrayList.get(currentIndex++);
        }

        @Override public synchronized void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

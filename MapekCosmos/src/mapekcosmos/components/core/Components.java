package mapekcosmos.components.core;

import mapekcosmos.interfaces.IComponent;
import mapekcosmos.interfaces.IComponents;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ArchyWin on 6/5/2015.
 */
public class Components implements IComponents {
    private LinkedList<IComponent> arrayList;
    private int currentSize;

    public Components() {
        currentSize = 0;
        arrayList = new LinkedList<IComponent>();
    }

    @Override public synchronized void add(IComponent component) {
        arrayList.add(currentSize, component);
        currentSize++;
    }

    @Override public synchronized void clear() {
        arrayList.clear();
        currentSize = 0;
    }

    @Override public synchronized boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override public synchronized Iterator<IComponent> iterator() {
        Iterator<IComponent> it =new ComponentIterator();
        /* new Iterator<IComponent>() {

            private int currentIndex = 0;

            @Override public synchronized boolean hasNext() {
                return currentIndex < currentSize && arrayList.get(currentIndex) != null;
            }

            @Override public synchronized IComponent next() {
                return arrayList.get(currentIndex++);
            }

            @Override public synchronized void remove() {
                throw new UnsupportedOperationException();
            }
        };*/
        return it;
    }
    class ComponentIterator implements Iterator<IComponent>{
        private int currentIndex = 0;

        @Override public synchronized boolean hasNext() {
            return currentIndex < currentSize && arrayList.get(currentIndex) != null;
        }

        @Override public synchronized IComponent next() {
            return arrayList.get(currentIndex++);
        }

        @Override public synchronized void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

package api.server.datastructure;

import java.util.LinkedList;

/**
 * Modified by Junior Cupe on 9/3/2015 using the edu.princeton's implementation as reference
 */
public class QuadTree<Key extends Comparable<Key>, Value>{
    private Node root;

    // helper node data type
    private class Node {
        Key x, y;              // x- and y- coordinates
        Node NW, NE, SE, SW;   // four subtrees
        Value value;           // associated data

        Node(Key x, Key y, Value value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    public String toString(){
        return null;
    }
    public boolean uploadString(){
        return true;
    }


    /***********************************************************************
     *  Insert (x, y) into appropriate quadrant
     ***************************************************************************/
    public void insert(Key x, Key y, Value value) {
        root = insert(root, x, y, value);
    }

    private Node insert(Node h, Key x, Key y, Value value) {
        if (h == null) return new Node(x, y, value);
            //// if (eq(x, h.x) && eq(y, h.y)) h.value = value;  // duplicate
        else if ( less(x, h.x) &&  less(y, h.y)) h.SW = insert(h.SW, x, y, value);
        else if ( less(x, h.x) && !less(y, h.y)) h.NW = insert(h.NW, x, y, value);
        else if (!less(x, h.x) &&  less(y, h.y)) h.SE = insert(h.SE, x, y, value);
        else if (!less(x, h.x) && !less(y, h.y)) h.NE = insert(h.NE, x, y, value);
        return h;
    }

    /***********************************************************************
     *  Remove (x, y) into appropriate quadrant
     ***************************************************************************/
    public void remove(Key x, Key y, Value value) {
        root = insert(root, x, y, value);
    }

    private Node remove(Node h, Key x, Key y, Value value) {
        if (h == null) return new Node(x, y, value);
            //// if (eq(x, h.x) && eq(y, h.y)) h.value = value;  // duplicate
        else if ( less(x, h.x) &&  less(y, h.y)) h.SW = insert(h.SW, x, y, value);
        else if ( less(x, h.x) && !less(y, h.y)) h.NW = insert(h.NW, x, y, value);
        else if (!less(x, h.x) &&  less(y, h.y)) h.SE = insert(h.SE, x, y, value);
        else if (!less(x, h.x) && !less(y, h.y)) h.NE = insert(h.NE, x, y, value);
        return h;
    }


    /***********************************************************************
     *  Range search.
     ***************************************************************************/

    public void query2D(Interval2D<Key> rect) {
        query2D(root, rect);
    }

    private void query2D(Node h, Interval2D<Key> rect) {
        if (h == null) return;
      /*  Key xmin = rect.intervalX.low; rect.getIntervalX_Low()
        Key ymin = rect.intervalY.low; rect.getIntervalY_Low()
        Key xmax = rect.intervalX.high; rect.getIntervalX_High()
        Key ymax = rect.intervalY.high;  rect.getIntervalY_High()
        */
        Key xmin = rect.getIntervalX_Low();
        Key ymin = rect.getIntervalY_Low();
        Key xmax = rect.getIntervalX_High();
        Key ymax = rect.getIntervalY_High();
        if (rect.contains(h.x, h.y)){}
           // StdOut.println("    (" + h.x + ", " + h.y + ") " + h.value);
        if ( less(xmin, h.x) &&  less(ymin, h.y)) query2D(h.SW, rect);
        if ( less(xmin, h.x) && !less(ymax, h.y)) query2D(h.NW, rect);
        if (!less(xmax, h.x) &&  less(ymin, h.y)) query2D(h.SE, rect);
        if (!less(xmax, h.x) && !less(ymax, h.y)) query2D(h.NE, rect);
    }
    /***********************************************************************
     *  Range search 2.
     ***************************************************************************/

    public LinkedList<Value> query2DB(Interval2D<Key> rect) {
        LinkedList<Value> items= new LinkedList<Value>();
        query2DB(root, rect, items);
        return items;
    }

    private void query2DB(Node h, Interval2D<Key> rect,LinkedList<Value> items) {
        if (h == null) return;
      /*  Key xmin = rect.intervalX.low; rect.getIntervalX_Low()
        Key ymin = rect.intervalY.low; rect.getIntervalY_Low()
        Key xmax = rect.intervalX.high; rect.getIntervalX_High()
        Key ymax = rect.intervalY.high;  rect.getIntervalY_High()
        */
        Key xmin = rect.getIntervalX_Low();
        Key ymin = rect.getIntervalY_Low();
        Key xmax = rect.getIntervalX_High();
        Key ymax = rect.getIntervalY_High();
        if (rect.contains(h.x, h.y)){
            //StdOut.println("    (" + h.x + ", " + h.y + ") " + h.value);
            items.add(h.value);
        }

        if ( less(xmin, h.x) && less(ymin, h.y)) query2DB(h.SW, rect,items);
        if ( less(xmin, h.x) && !less(ymax, h.y)) query2DB(h.NW, rect,items);
        if (!less(xmax, h.x) &&  less(ymin, h.y)) query2DB(h.SE, rect,items);
        if (!less(xmax, h.x) && !less(ymax, h.y)) query2DB(h.NE, rect,items);
    }


    /***************************************************************************
     *  helper comparison functions
     ***************************************************************************/

    private boolean less(Key k1, Key k2) { return k1.compareTo(k2) <  0; }
    private boolean eq  (Key k1, Key k2) { return k1.compareTo(k2) == 0; }

}

package a05;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.RedBlackBST;

/**
 * A symbol table with Point2D.
 */
public class PointST<Value> {

    RedBlackBST<Point2D, Value>  st= new RedBlackBST<>();;

    /**
     * Constructs an empty symbol table of points
     */
    public PointST(){}

    /**
     * @return if the ST is empty
     */
    public boolean isEmpty(){
        return st.isEmpty();
    }

    /**
     * @return num of points in the table
     */
    public int size(){
        return st.size();
    }

    /**
     * Associate the value val with point p
     * in the symbol table.
     * @param p point
     * @param val value
     * @throws NullPointerException if <code>p</code> is null
     */
    public void put(Point2D p, Value val) {
        if (p == null) {
            throw new NullPointerException();
        }
        st.put(p,val);
    }

    /**
     * @param p point to get from the ST
     * @return value associated with that point
     * @throws NullPointerException if <code>p</code> is null
     */
    public Value get(Point2D p){
        if (p == null) {
            throw new NullPointerException();
        }
        return st.get(p);
    }

    /**
     * @param p point
     * @return  if point is contained in the symbol table.
     * @throws NullPointerException if <code>p</code> is null
     */
    public boolean contains(Point2D p){
        if (p == null) {
            throw new NullPointerException();
        }
        return st.contains(p);
    }

    /**
     * @return all points in the symbol table
     */
    public Iterable<Point2D> points(){
        Queue<Point2D> allPoints = new Queue<>();
        for (Point2D point: st.keys()) {
            allPoints.enqueue(point);
        }
        return allPoints;
    }

    /**
     * @param rect rectangle
     * @return range of points which points are in the rectangle
     * @throws NullPointerException if <code>rect</code> is null.
     */
    public Iterable<Point2D> range(RectHV rect){
        if (rect == null) {
            throw new NullPointerException();
        }

        Queue<Point2D> containedPoints = new Queue<>();

        for (Point2D point: st.keys()) {
            if(rect.contains(point)){
                containedPoints.enqueue(point);
            }
        }
        return containedPoints;
    }

    /**
     * Gives the nearest approximate point to the given point
     * @param p given point
     * @return nearest point to given point.
     * @throws NullPointerException if <code>rect</code> is null.
     */
    public Point2D nearest(Point2D p){
        if (p == null) {
            throw new NullPointerException();
        }

        Point2D nearestPoint = null;
        double distanceRecord = 0;

        for (Point2D point: st.keys()){
            if (nearestPoint == null){
                distanceRecord = p.distanceSquaredTo(point);
                nearestPoint = point;
            }

            if (p.distanceSquaredTo(point) < distanceRecord){
                distanceRecord = p.distanceSquaredTo(point);
                nearestPoint = point;
            }
        }
        return nearestPoint;
    }

    // unit testing of the methods (not graded)
    public static void main(String[] args){
    }
}

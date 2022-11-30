package graphGenerators;
import edu.princeton.cs.algs4.*;

public class DemoGraphGenerators {
    public static void main (String args []){
        StdOut.println("Simple Graph:");
        //prints adjacent list for a simple graph:
        StdOut.println(GraphGenerator.simple(7, 11));

        StdOut.println("Simple Digraph:");
        //prints adjacent list for a simple digraph (directed graph):
        StdOut.println(DigraphGenerator.simple(10,15));
    }
}

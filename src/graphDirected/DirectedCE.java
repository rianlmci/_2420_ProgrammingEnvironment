package graphDirected;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Topological;

import java.util.ArrayList;

public class DirectedCE {
    public static void main(String[] args) {
        In graphFile = new In("src/graphDirected/resources/TopologicalOrderGraph.txt");
        Digraph digraph = new Digraph(graphFile);

        //Vert connections:
        StdOut.println("Adj. List:");
        StdOut.println(digraph.toString());


        //Topo order:
        Topological topological = new Topological(digraph);
        if (topological.hasOrder()) {
            StdOut.print("Graph in topological order: ");
            for (Integer oneVert:
                    topological.order()) {
                StdOut.print(oneVert + " ");
            }
        }
        else {
            StdOut.print("This graph does not have a topological order");
        }
    }
}
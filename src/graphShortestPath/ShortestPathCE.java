package graphShortestPath;

import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

public class ShortestPathCE {
    // = = = = TEST CLIENT = = = = //
    public static void main (String [] args){
        String filepath = "src/graphShortestPath/resources/airports.txt";
        EdgeWeightedSymbolDigraph sg = new EdgeWeightedSymbolDigraph(filepath, " ");

        EdgeWeightedDigraph graph = sg.digraph();
        String start = "Start"; // hard coded input
        String end = "End"; // hard coded input

        DijkstraSP sp = new DijkstraSP(graph,sg.indexOf(start));
        double length = 0;
        System.out.println("Shortest path from " + start + " to " + end + ":");
        System.out.println("--------------------------------");

        if(sp.hasPathTo(sg.indexOf(end))){
            for (DirectedEdge edge:
            sp.pathTo(sg.indexOf(end))) {
                System.out.printf("%s to %s (%.1f)\n",
                        sg.nameOf(edge.from()), sg.nameOf(edge.to()), edge.weight());
                length += edge.weight();
            }
        }
        System.out.println("Total length from Start to End: " + length);
    }
}

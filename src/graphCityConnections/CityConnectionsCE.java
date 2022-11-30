package graphCityConnections;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.PrimMST;

public class CityConnectionsCE {
    public static void main(String [] args){
        String filePath = "src/graphCityConnections/resources/CityConnections.csv";
        EdgeWeightedSymbolGraph symbolGraph =
                new EdgeWeightedSymbolGraph(filePath,",");
        EdgeWeightedGraph graph = symbolGraph.graph();
        PrimMST primMst = new PrimMST(graph);
        int totalWeight = 0;
        System.out.println("Cities to connect with a bike trail:");
        System.out.println("------------------------------------");
        for (Edge oneEdge: primMst.edges()) {
            System.out.printf("%s to %s (%d)\n",
                    symbolGraph.nameOf(oneEdge.either()),
                    symbolGraph.nameOf(oneEdge.other(oneEdge.either())),
                    (int)oneEdge.weight());
            totalWeight += oneEdge.weight();
        }
    System.out.println("Total length of the bike trail: " + totalWeight + "!");
    }
}

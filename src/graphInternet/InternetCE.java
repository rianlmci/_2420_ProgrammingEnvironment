package graphInternet;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.KruskalMST;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class InternetCE {

    public static void main(String[] args) {
        In in = new In("src/graphInternet/GraphInternet.txt");
        EdgeWeightedGraph graph = new EdgeWeightedGraph(in);
        KruskalMST mst = new KruskalMST(graph);

        int routerVertex = 8;
        Queue<Integer> queue = new Queue<>();
        double totalCost = 0;

        StdOut.print("Offices needing to be connected: ");
        for (Edge e : mst.edges()) {
            if (e.other(e.either()) != routerVertex) {
                StdOut.print(e.either() + "-" + e.other(e.either()) + " ");
                totalCost += e.weight();
            }
            else {
                queue.enqueue(e.other(routerVertex));
                totalCost += e.weight();
            }
        }
        StdOut.println();

        StdOut.print("Offices needing a router: ");
        for (int i = 0; i <= queue.size(); i++) {
            StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println();
        StdOut.printf("Total cost: $%.2f", totalCost);
    }
}

// if it (edge) does not connect to the router vertex
// print offices that need a connection
// else
// store the other vertex that is not the router vertex and store it
// in a list or queue. Those are the offices that need a router
//relative path: src/packageName/folderName/fileName
package graphSymbol;

import edu.princeton.cs.algs4.*;

public class RouteFinder {
    public static void findRoute(){
        String filename  = "src/graphSymbol/resources/routes.txt"; //args[0];
        String delimiter = " "; //args[1];
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph graph = sg.graph();
        String source = new String();

        while (!source.equalsIgnoreCase("done")) {
            StdOut.print("\nPlease enter a departure airport, or type done to exit: ");
            source = StdIn.readLine();

            if (sg.contains(source)) {
                BreadthFirstPaths bfp = new BreadthFirstPaths(graph,sg.indexOf(source));
                StdOut.println("Shortest flight path departing from " + source + "...");
                for (int i = 0; i < graph.V(); i++){
                    if (bfp.hasPathTo(i)) {
                        Iterable<Integer> shortestPath = bfp.pathTo(i);
                        StringBuilder sb = new StringBuilder();
                        sb.append("[" + source + " to " + sg.nameOf(i) + "] : ");
                        for (Integer vertex:
                            shortestPath) {
                            sb.append(sg.nameOf(vertex) + " ~> " );
                        }
                        sb = sb.delete(sb.length()-4,sb.length());
                        StdOut.println(sb.toString());
                    }
                }
            }

            else if (!source.equalsIgnoreCase("done")) {
                StdOut.println("input not contain '" + source + "'");
            }
        }
    }
    // = = = = TEST CLIENT = = = =//
    public static void main(String args[]){
        findRoute();
    }
}

package ceDFSvsBFS;

import edu.princeton.cs.algs4.*;

public class DFSvsBFS {

    private static void printAdjList(Graph graph) {
        StringBuilder sb = new StringBuilder();
        sb.append("Adjacency List:\n");
        sb.append("---------------\n");
        for (int v = 0; v < graph.V(); v++) {
            sb.append(v + ": ");
            for (int w : graph.adj(v)) {
                sb.append(w + " -> ");
            }
            sb.delete(sb.length()-4,sb.length());
            sb.append("\n");
        }
        StdOut.println(sb);
    }
    private static void printDFSAndBFS(int source, Graph graph){
        DepthFirstPaths dfs = new DepthFirstPaths(graph,source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(graph,source);
        StringBuilder sb = new StringBuilder();
        sb.append("Paths DFS:\t\tShortest Paths BFS:\n");
        sb.append("---------------\t-------------------\n");
        for (int v = 0; v < graph.V(); v++){
            if(dfs.hasPathTo(v) && bfs.hasPathTo(v)) {
                //DFS
                String stringTempDFS = dfs.pathTo(v).toString();
                stringTempDFS = stringTempDFS.replaceAll("\\s", "..");
                stringTempDFS = stringTempDFS.substring(0,stringTempDFS.length()-2);

                //BFS
                String stringTempBFS = bfs.pathTo(v).toString();
                stringTempBFS = stringTempBFS.replaceAll("\\s", "..");
                stringTempBFS = stringTempBFS.substring(0,stringTempBFS.length()-2);
                sb.append(String.format("%-16s%-10s\n",stringTempDFS,stringTempBFS));
            }
        }
        StdOut.println(sb);
    }


//= = = = = = = = Test Client= = = =  = = = =//
    public static void main(String args []){
        In graphFile = new In("src/ceDFSvsBFS/resources/SimpleGraph.txt");
        Graph graph = new Graph(graphFile);
        DFSvsBFS dfsVsBfs= new DFSvsBFS();

        dfsVsBfs.printAdjList(graph);
        int source = 1;
        dfsVsBfs.printDFSAndBFS(source,graph);
    }
}

package Graphs;

import java.util.*;

// A class to store a graph edge
class Edge {
    int source, dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}

// A class to represent a graph object
class Graph {
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;

    // stores in-degree of a vertex
    List<Integer> indegree = null;

    // Constructor
    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // initialize in-degree of each vertex by 0
        indegree = new ArrayList<>(Collections.nCopies(n, 0));

        // add edges to the directed graph
        for (Edge edge : edges) {
            int src = edge.source;
            int dest = edge.dest;

            // add an edge from source to destination
            adjList.get(src).add(dest);

            // increment in-degree of destination vertex by 1
            indegree.set(dest, indegree.get(dest) + 1);
        }
    }
}

public class AllTopologicalOrders {
    // Recursive function to find all topological orderings of a given DAG
    public static void findAllTopologicalOrderings(Graph graph, Stack<Integer> path,
            boolean[] discovered, int n) {
        // do for every vertex
        for (int v = 0; v < n; v++) {
            // proceed only if the current node's in-degree is 0 and
            // the current node is not processed yet
            if (graph.indegree.get(v) == 0 && !discovered[v]) {
                // for every adjacent vertex `u` of `v`, reduce the in-degree of
                // `u` by 1
                for (int u : graph.adjList.get(v)) {
                    graph.indegree.set(u, graph.indegree.get(u) - 1);
                }

                // include the current node in the path and mark it as discovered
                path.add(v);
                discovered[v] = true;

                // recur
                findAllTopologicalOrderings(graph, path, discovered, n);

                // backtrack: reset in-degree information for the current node
                for (int u : graph.adjList.get(v)) {
                    graph.indegree.set(u, graph.indegree.get(u) + 1);
                }

                // backtrack: remove the current node from the path and
                // mark it as undiscovered
                path.pop();
                discovered[v] = false;
            }
        }

        // print the topological order if all vertices are included in the path
        if (path.size() == n) {
            System.out.println(path);
        }
    }

    // Print all topological orderings of a given DAG
    public static void printAllTopologicalOrders(Graph graph) {
        // get the total number of nodes in the graph
        int n = graph.adjList.size();

        // create an auxiliary array to keep track of whether a vertex is discovered
        boolean[] discovered = new boolean[n];

        // list to store the topological order
        Stack<Integer> path = new Stack<>();

        // find all topological ordering and print them
        findAllTopologicalOrderings(graph, path, discovered, n);
    }

    public static void main(String[] args) {

        // List of graph edges as per the above diagram
        // List<Edge> edges = Arrays.asList(
        // new Edge(0, 6), new Edge(1, 2), new Edge(1, 4), new Edge(1, 6),
        // new Edge(3, 0), new Edge(3, 4), new Edge(5, 1), new Edge(7, 0),
        // new Edge(7, 1));

        int[][] a = new int[][] { { 1, 4 }, { 1, 2 }, { 4, 2 }, { 4, 3 }, { 3, 2 }, { 5, 2 }, { 3, 5 }, { 7, 2 },
                { 8, 6 } };

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Edge e = new Edge(a[i][0], a[i][1]);
            edges.add(e);
        }

        // total number of nodes in the graph (labelled from 0 to 7)
        int n = 8;

        // build a graph from the given edges
        Graph graph = new Graph(edges, n);

        // print all topological ordering of the graph
        printAllTopologicalOrders(graph);
    }
}
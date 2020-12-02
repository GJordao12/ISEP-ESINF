package adjacencyMap;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The type Graph algorithms.
 *
 * @author DEI -ESINF
 */
public class GraphAlgorithms {

    /**
     * Performs breadth-first search of a Graph starting in a Vertex
     *
     * @param <V>            the type parameter
     * @param <E>            the type parameter
     * @param g              Graph instance
     * @param vert           information of the Vertex that will be the source of the search
     * @param amountOfLayers the amount of layers
     * @return a queue with the vertices of the n amount of layers
     */
    public static <V, E> LinkedList<V> BreadthFirstSearch(Graph<V, E> g, V vert, int amountOfLayers) {
        if (!g.validVertex(vert)) {
            return null;
        }
        LinkedList<V> neighbors = new LinkedList<>();
        LinkedList<V> auxiliar = new LinkedList<>();
        LinkedList<V> countries = new LinkedList<>();
        auxiliar.add(vert);
        neighbors.add(vert);
        countries.add(vert);
        int layers = 1;
        int connections;
        int totalConnections = 0;
        int vertices = 0;
        while (!auxiliar.isEmpty() && layers <= amountOfLayers) {
            vert = auxiliar.remove();
            connections = 0;
            for (V adj : g.adjVertices(vert)) {
                if (!neighbors.contains(adj)) {
                    if (layers <= amountOfLayers) {
                        countries.add(adj);
                    }
                    neighbors.add(adj);
                    auxiliar.add(adj);
                    connections++;
                }
            }
            totalConnections += connections;
            if (vertices == 0) {
                layers++;
                vertices = totalConnections;
                totalConnections = 0;
            }
            vertices--;
        }
        return countries;
    }

    /**
     * Performs depth-first search starting in a Vertex
     *
     * @param g     Graph instance
     * @param vOrig Vertex of graph g that will be the source of the search
     * @param qdfs  queue with vertices of depth-first search
     * @param <E>   edge
     * @param <V>   vertex
     */
    private static <V, E> void DepthFirstSearch(Graph<V, E> g, V vOrig, LinkedList<V> qdfs) {
        qdfs.add(vOrig);
        for (V adj : g.adjVertices(vOrig)) {
            if (!qdfs.contains(adj)) {
                DepthFirstSearch(g, adj, qdfs);
            }
        }
    }

    /**
     * Depth first search linked list.
     *
     * @param <V>  the type parameter
     * @param <E>  the type parameter
     * @param g    Graph instance
     * @param vert information of the Vertex that will be the source of the search
     * @return qdfs a queue with the vertices of depth-first search
     */
    public static <V, E> LinkedList<V> DepthFirstSearch(Graph<V, E> g, V vert) {
        if (!g.validVertex(vert)) {
            return null;
        }
        LinkedList<V> path = new LinkedList<>();
        DepthFirstSearch(g, vert, path);
        return path;
    }

    /**
     * Returns all paths from vOrig to vDest
     *
     * @param g       Graph instance
     * @param vOrig   Vertex that will be the source of the path
     * @param vDest   Vertex that will be the end of the path
     * @param path    stack with vertices of the current path (the path is in reverse order)
     * @param paths   ArrayList with all the paths (in correct order)
     * @param visited visited
     * @param <E>     edge
     * @param <V>     vertex
     */
    private static <V, E> void allPaths(Graph<V, E> g, V vOrig, V vDest, boolean[] visited, LinkedList<V> path, ArrayList<LinkedList<V>> paths) {
        path.push(vOrig);
        int vKey = g.getKey(vOrig);
        visited[vKey] = true;

        for (V vAdj : g.adjVertices(vOrig)) {

            if (vAdj.equals(vDest)) {
                path.push(vAdj);
                LinkedList<V> revpath = revPath(path);
                paths.add(new LinkedList(revpath));
                path.pop();
            } else {
                vKey = g.getKey(vAdj);
                if (!visited[vKey]) {
                    allPaths(g, vAdj, vDest, visited, path, paths);
                }
            }
        }
        V vElem = path.pop();
        vKey = g.getKey(vElem);
        visited[vKey] = false;
    }

    /**
     * Returns all paths from vOrig to vDest
     *
     * @param g                 Graph instance
     * @param vOrig             Vertex that will be the source of the path
     * @param vDest             Vertex that will be the end of the path
     * @param path              stack with vertices of the current path (the path is in reverse order)
     * @param paths             ArrayList with all the paths (in correct order)
     * @param <V>               vertex
     * @param visited           visited
     * @param <E>               edge
     * @param necessaryVertices list with the necessary vertices that he has to go through
     */
    private static <V, E> void allPaths(Graph<V, E> g, V vOrig, V vDest, boolean[] visited, LinkedList<V> path, ArrayList<LinkedList<V>> paths, LinkedList<V> necessaryVertices) {
        path.push(vOrig);
        int vKey = g.getKey(vOrig);
        visited[vKey] = true;

        for (V vAdj : g.adjVertices(vOrig)) {

            if (vAdj.equals(vDest)) {
                path.push(vAdj);
                LinkedList<V> revpath = revPath(path);
                if (revpath.size() >= (necessaryVertices.size() + 2) && revpath.containsAll(necessaryVertices)) {
                    paths.add(new LinkedList(revpath));
                }
                path.pop();
            } else {
                vKey = g.getKey(vAdj);
                if (!visited[vKey]) {
                    allPaths(g, vAdj, vDest, visited, path, paths, necessaryVertices);
                }
            }
        }
        V vElem = path.pop();
        vKey = g.getKey(vElem);
        visited[vKey] = false;
    }


    /**
     * All paths array list.
     *
     * @param <V>   the type parameter
     * @param <E>   the type parameter
     * @param g     Graph instance
     * @param vOrig information of the Vertex origin
     * @param vDest information of the Vertex destination
     * @return paths ArrayList with all paths from voInf to vdInf
     */
    public static <V, E> ArrayList<LinkedList<V>> allPaths(Graph<V, E> g, V vOrig, V vDest) {

        LinkedList<V> path = new LinkedList<>();
        ArrayList<LinkedList<V>> paths = new ArrayList<>();
        boolean[] visited = new boolean[g.numVertices()];

        if (g.validVertex(vOrig) && g.validVertex(vDest)) {
            allPaths(g, vOrig, vDest, visited, path, paths);
        }

        return paths;
    }

    /**
     * All paths array list.
     *
     * @param <V>               the type parameter
     * @param <E>               the type parameter
     * @param g                 Graph instance
     * @param vOrig             information of the Vertex origin
     * @param vDest             information of the Vertex destination
     * @param necessaryVertices list with the necessary vertices that he has to go through
     * @return paths ArrayList with all paths from voInf to vdInf
     */
    public static <V, E> ArrayList<LinkedList<V>> allPaths(Graph<V, E> g, V vOrig, V vDest, LinkedList<V> necessaryVertices) {

        LinkedList<V> path = new LinkedList<>();
        ArrayList<LinkedList<V>> paths = new ArrayList<>();
        boolean[] visited = new boolean[g.numVertices()];

        if (g.validVertex(vOrig) && g.validVertex(vDest)) {
            allPaths(g, vOrig, vDest, visited, path, paths, necessaryVertices);
        }

        return paths;
    }

    /**
     * Computes shortest-path distance from a source vertex to all reachable
     * vertices of a graph g with nonnegative edge weights
     * This implementation uses Dijkstra's algorithm
     *
     * @param <V>      the type parameter
     * @param <E>      the type parameter
     * @param g        Graph instance
     * @param vOrig    Vertex that will be the source of the path
     * @param vertices the vertices
     * @param visited  set of discovered vertices
     * @param pathKeys minimum path vertices keys
     * @param dist     minimum distances
     */
    protected static <V, E> void shortestPathLength(Graph<V, E> g, V vOrig, V[] vertices,
                                                    boolean[] visited, int[] pathKeys, double[] dist) {
        int vkey = g.getKey(vOrig);
        dist[vkey] = 0;
        while (vkey != -1) {
            vOrig = vertices[vkey];
            visited[vkey] = true;
            for (V vAdj : g.adjVertices(vOrig)) {
                int vkeyAdj = g.getKey(vAdj);
                Edge<V, E> edge = g.getEdge(vOrig, vAdj);
                if (!visited[vkeyAdj] && dist[vkeyAdj] > dist[vkey] + edge.getWeight()) {
                    dist[vkeyAdj] = dist[vkey] + edge.getWeight();
                    pathKeys[vkeyAdj] = vkey;
                }
            }
            double minDist = Double.MAX_VALUE;
            vkey = -1;
            for (int i = 0; i < g.numVertices(); i++) {
                if (!visited[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    vkey = i;
                }
            }
        }
    }

    /**
     * Extracts from pathKeys the minimum path between voInf and vdInf
     * The path is constructed from the end to the beginning
     *
     * @param <V>      the type parameter
     * @param <E>      the type parameter
     * @param g        Graph instance
     * @param vOrig    information of the Vertex origin
     * @param vDest    information of the Vertex destination
     * @param verts    the verts
     * @param pathKeys minimum path vertices keys
     * @param path     stack with the minimum path (correct order)
     */
    protected static <V, E> void getPath(Graph<V, E> g, V vOrig, V vDest, V[] verts, int[] pathKeys, LinkedList<V> path) {

        if (!vOrig.equals(vDest)) {
            path.push(vDest);
            int vKey = g.getKey(vDest);
            int prevVKey = pathKeys[vKey];
            vDest = verts[prevVKey];

            getPath(g, vOrig, vDest, verts, pathKeys, path);
        } else {
            path.push(vOrig);
        }
    }

    /**
     * Shortest path double.
     *
     * @param <V>       the type parameter
     * @param <E>       the type parameter
     * @param g         the g
     * @param vOrig     the v orig
     * @param vDest     the v dest
     * @param shortPath the short path
     * @return the double
     */
//shortest-path between vOrig and vDest
    public static <V, E> double shortestPath(Graph<V, E> g, V vOrig, V vDest, LinkedList<V> shortPath) {

        if (!g.validVertex(vOrig) || !g.validVertex(vDest))
            return 0;

        int nverts = g.numVertices();
        boolean[] visited = new boolean[nverts];
        int[] pathKeys = new int[nverts];
        double[] dist = new double[nverts];
        V[] vertices = g.allkeyVerts();

        for (int i = 0; i < nverts; i++) {
            dist[i] = Double.MAX_VALUE;
            pathKeys[i] = -1;
        }
        shortestPathLength(g, vOrig, vertices, visited, pathKeys, dist);
        double lengthPath = dist[g.getKey(vDest)];

        if (lengthPath != Double.MAX_VALUE) {

            getPath(g, vOrig, vDest, vertices, pathKeys, shortPath);
            return lengthPath;
        }

        return 0;
    }

    /**
     * Shortest path double.
     *
     * @param <V>             the type parameter
     * @param <E>             the type parameter
     * @param g               the g
     * @param vOrig           the v orig
     * @param vDest           the v dest
     * @param shortPath       the short path
     * @param visitedVertices the visited vertices
     * @return the double
     */
//shortest-path between vOrig and vDest
    public static <V, E> double shortestPath(Graph<V, E> g, V vOrig, V vDest, LinkedList<V> shortPath, LinkedList<V> visitedVertices) {

        if (!g.validVertex(vOrig) || !g.validVertex(vDest))
            return 0;

        int nverts = g.numVertices();
        boolean[] visited = new boolean[nverts];
        int[] pathKeys = new int[nverts];
        double[] dist = new double[nverts];
        V[] vertices = g.allkeyVerts();

        for (int i = 0; i < (visitedVertices.size() - 1); i++) {
            visited[g.getKey(visitedVertices.get(i))] = true;
        }

        for (int i = 0; i < nverts; i++) {
            dist[i] = Double.MAX_VALUE;
            pathKeys[i] = -1;
        }
        shortestPathLength(g, vOrig, vertices, visited, pathKeys, dist);
        double lengthPath = dist[g.getKey(vDest)];

        if (lengthPath != Double.MAX_VALUE) {

            getPath(g, vOrig, vDest, vertices, pathKeys, shortPath);
            return lengthPath;
        }

        return 0;
    }

    /**
     * Shortest paths boolean.
     *
     * @param <V>   the type parameter
     * @param <E>   the type parameter
     * @param g     the g
     * @param vOrig the v orig
     * @param paths the paths
     * @param dists the dists
     * @return the boolean
     */
    public static <V, E> boolean shortestPaths(Graph<V, E> g, V vOrig, ArrayList<LinkedList<V>> paths, ArrayList<Double> dists) {

        if (!g.validVertex(vOrig)) return false;
        int nverts = g.numVertices();
        boolean[] visited = new boolean[nverts];
        int[] pathKeys = new int[nverts];
        double[] dist = new double[nverts];
        V[] vertices = g.allkeyVerts();

        for (int i = 0; i < nverts; i++) {
            dist[i] = Double.MAX_VALUE;
            pathKeys[i] = -1;
        }

        shortestPathLength(g, vOrig, vertices, visited, pathKeys, dist);

        dists.clear();
        paths.clear();
        for (int i = 0; i < nverts; i++) {
            paths.add(null);
            dists.add(null);
        }
        for (int i = 0; i < nverts; i++) {
            LinkedList<V> shortPath = new LinkedList<>();
            if (dist[i] != Double.MAX_VALUE)
                getPath(g, vOrig, vertices[i], vertices, pathKeys, shortPath);
            paths.set(i, shortPath);
            dists.set(i, dist[i]);
        }

        return true;
    }

    /**
     * Reverses the path
     *
     * @param path stack with path
     * @param <E>  edge
     * @param <V>  vertex
     * @return pathrev
     */
    private static <V, E> LinkedList<V> revPath(LinkedList<V> path) {

        LinkedList<V> pathcopy = new LinkedList<>(path);
        LinkedList<V> pathrev = new LinkedList<>();

        while (!pathcopy.isEmpty())
            pathrev.push(pathcopy.pop());

        return pathrev;
    }

    /**
     * Length path.
     *
     * @param <V>  the type parameter
     * @param <E>  the type parameter
     * @param g    the graph object
     * @param path the path
     * @return the length
     */
    public static <V, E> double lengthPath(Graph<V, E> g, LinkedList<V> path) {
        double length = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            V v1 = path.get(i);
            V v2 = path.get(i + 1);
            length = length + g.getEdge(v1, v2).getWeight();
        }
        return length;
    }

    /**
     * Breadth first search boolean.
     *
     * @param <V>     the type parameter
     * @param <E>     the type parameter
     * @param g       the g
     * @param vert    the vert
     * @param vToFind the v to find
     * @return the boolean
     */
    public static <V, E> boolean BreadthFirstSearch(Graph<V, E> g, V vert, V vToFind) {
        if (!g.validVertex(vert) || !g.validVertex(vToFind)) {
            return false;
        }

        LinkedList<V> neighbors = new LinkedList<>();
        LinkedList<V> auxiliar = new LinkedList<>();

        auxiliar.add(vert);
        neighbors.add(vert);

        while (!auxiliar.isEmpty()) {
            vert = auxiliar.remove();
            for (V adj : g.adjVertices(vert)) {
                if (!neighbors.contains(adj)) {
                    if (adj.equals(vToFind)) {
                        return true;
                    }
                    neighbors.add(adj);
                    auxiliar.add(adj);
                }
            }
        }
        return false;
    }
}
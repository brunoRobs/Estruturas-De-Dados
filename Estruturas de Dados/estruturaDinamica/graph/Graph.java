package estruturaDinamica.graph;

import java.util.*;

public class Graph<T> {
    private Hashtable<Vertex<T>, List<Vertex<T>>> graph;
    private boolean directed;

    public Graph(boolean directed) {
        this.graph = new Hashtable<Vertex<T>, List<Vertex<T>>>();
        this.directed = directed;
    }

    public int vertexNum() {
        return this.graph.size();
    }

    public int edgeNum() {
        int result = 0;
        for (Enumeration<Vertex<T>> vertex = this.graph.keys(); vertex.hasMoreElements();) {
            Vertex<T> v = vertex.nextElement();
            List<Vertex<T>> adjacent = this.graph.get(v);
            if (adjacent != null) {
                result += adjacent.size();
            }
        }
        return result;
    }

    public void addVertex(Vertex<T> vertex) {
        if (!this.graph.containsKey(vertex)) {
            this.graph.put(vertex, new LinkedList<Vertex<T>>());
        }
    }

    public void addEdge(Vertex<T> v, Vertex<T> w) {
        addVertex(v);
        addVertex(w);
        List<Vertex<T>> adjacent = this.graph.get(v);
        if (!adjacent.contains(w)) {
            adjacent.add(w);
        }
        if (!this.directed) {
            adjacent = this.graph.get(w);
            if (!adjacent.contains(v)) {
                adjacent.add(v);
            }
        }
    }

    public Iterator<Vertex<T>> adjacentVertex(Vertex<T> vertex) {
        Iterator<Vertex<T>> result = null;
        if (this.graph.containsKey(vertex)) {
            result = this.graph.get(vertex).iterator();
        }
        return result;
    }

    public boolean areAdjacent(Vertex<T> v, Vertex<T> w) {
        boolean result = false;
        if (this.graph.containsKey(v)) {
            result = this.graph.get(v).contains(w);
        }
        return result;
    }

    public void removeVertex(Vertex<T> vertex) {
        for (Enumeration<Vertex<T>> v = this.graph.keys(); v.hasMoreElements();) {
            Vertex<T> w = v.nextElement();
            List<Vertex<T>> adjacent = this.graph.get(w);
            if (adjacent.contains(vertex)) {
                adjacent.remove(vertex);
            }
        }
        this.graph.remove(vertex);
    }

    public void removeEdge(Edge<T> edge) {
        if (this.graph.containsKey(edge.origin) && this.graph.containsKey(edge.destiny)) {
            if (this.graph.get(edge.origin).contains(edge.destiny)) {
                this.graph.get(edge.origin).remove(edge.destiny);
            }
            if (!this.directed) {
                if (this.graph.get(edge.destiny).contains(edge.origin)) {
                    this.graph.get(edge.destiny).remove(edge.origin);
                }
            }
        }
    }

    public String toString() {
        String string = "";
        for (Enumeration<Vertex<T>> vertex = this.graph.keys(); vertex.hasMoreElements();) {
            Vertex<T> w = vertex.nextElement();
            List<Vertex<T>> adjacent = this.graph.get(w);
            string += w + " -> " + adjacent + "\n";
        }
        return string;
    }

    public void print() {
        System.out.println(this.toString());
    }
}
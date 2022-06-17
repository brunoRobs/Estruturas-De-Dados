package estruturaDinamica.graph;

@SuppressWarnings("rawtypes")
public class Vertex<T> {
    T info;

    public Vertex(T vertex) {
        this.info = vertex;
    }

    public int hashCode() {
        return this.info.hashCode();
    }

    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Vertex) {
            result = this.info.equals(((Vertex) o).info);
        }
        return result;
    }

    public String toString() {
        return "" + this.info;
    }
}
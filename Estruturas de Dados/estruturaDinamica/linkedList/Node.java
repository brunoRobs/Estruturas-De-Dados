package estruturaDinamica.linkedList;

public class Node<T> {
    public T element;
    public Node<T> nextElement;

    public Node(T element) {
        this.element = element;
    }

    public String toString() {
        return "" + this.element;
    }
}
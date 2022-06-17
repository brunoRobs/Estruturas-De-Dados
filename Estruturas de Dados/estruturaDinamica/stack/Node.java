package estruturaDinamica.stack;

public class Node<T> {
    public T element;
    public Node<T> nextElement;

    public Node(T novo) {
        this.element = novo;
    }

    public String toString() {
        return "" + this.element;
    }
}
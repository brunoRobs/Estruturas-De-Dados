package estruturaDinamica.binaryTree;

public class BinaryNode<T> {
    T element;
    BinaryNode<T> left, right;

    public BinaryNode(T element) {
        this.element = element;
    }

    public String toString() {
        return "" + this.element;
    }
}

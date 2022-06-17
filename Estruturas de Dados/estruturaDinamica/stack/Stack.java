package estruturaDinamica.stack;

public class Stack<T> {
    private Node<T> top;
    private int qtd;

    public void push(T element) {
        Node<T> newElement = new Node<T>(element);
        if (this.top == null) {
            this.top = newElement;
            this.qtd++;
        } else {
            newElement.nextElement = this.top;
            this.top = newElement;
            this.qtd++;
        }
    }

    public T pop(T element) {
        T remove = null;
        if (this.top != null) {
            remove = this.top.element;
            this.top = this.top.nextElement;
            this.qtd--;
        }
        return remove;
    }

    public int size() {
        return this.qtd;
    }

    public T peek() {
        T end = null;
        if (this.top != null) {
            end = this.top.element;
        }
        return end;
    }

    public void clear() {
        this.top = null;
        this.qtd = 0;
    }

    public String toString() {
        String string = "";
        Node<T> aux = this.top;
        boolean initial = true;
        while (aux != null) {
            if (initial == true) {
                string += aux.element;
                initial = false;
            } else {
                string += " -> " + aux.element;
            }
            aux = aux.nextElement;
        }
        return string;
    }

    public void print() {
        System.out.println(this.toString());
    }
}